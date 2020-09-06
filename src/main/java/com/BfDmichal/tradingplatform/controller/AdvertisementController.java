package com.BfDmichal.tradingplatform.controller;

import com.BfDmichal.tradingplatform.controller.exception.AdvertisementNotFoundException;
import com.BfDmichal.tradingplatform.domain.dto.AdvertisementDto;
import com.BfDmichal.tradingplatform.mapper.AdvertisementMapper;
import com.BfDmichal.tradingplatform.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advertisement")
@CrossOrigin(origins = "*")
public class AdvertisementController {
    @Autowired
    private AdService service;
    @Autowired
    private AdvertisementMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "/getAdvertisements")
    public List<AdvertisementDto> getAllAdvertisements(){
        return mapper.mapToAdvertisementDtoList(service.getAdvertisements());
    }
    @RequestMapping(method = RequestMethod.GET,value = "/getAdvertisement")
    public AdvertisementDto getAdvertisement(@RequestParam int id) throws AdvertisementNotFoundException {
        return mapper.mapToAdvertisementDto(service.getAdvertisementById(id).orElseThrow(AdvertisementNotFoundException::new));
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/deleteAdvertisement")
    public void deleteAdvertisement(@RequestParam int id){
        service.deleteAdvertisement(id);
    }
    @RequestMapping(method = RequestMethod.POST,value = "createAdvertisement")
    public void createNewAdvertisement(@RequestBody AdvertisementDto advertisementDto){
        service.saveAdvertisement(mapper.mapToAdvertisement(advertisementDto));
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/updateAdvertisement")
    public AdvertisementDto updateAdvertisement(@RequestBody AdvertisementDto advertisementDto){
        return mapper.mapToAdvertisementDto(service.saveAdvertisement(mapper.mapToAdvertisement(advertisementDto)));
    }
}
