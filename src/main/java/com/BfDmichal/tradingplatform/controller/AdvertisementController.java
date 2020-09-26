package com.BfDmichal.tradingplatform.controller;

import com.BfDmichal.tradingplatform.domain.dto.PhotoDto;
import com.BfDmichal.tradingplatform.controller.exception.AdvertisementNotFoundException;
import com.BfDmichal.tradingplatform.domain.dto.AdvertisementDto;
import com.BfDmichal.tradingplatform.mapper.AdvertisementMapper;
import com.BfDmichal.tradingplatform.mapper.PhotoMapper;
import com.BfDmichal.tradingplatform.service.AdService;
//import com.BfDmichal.tradingplatform.service.PhotoService;
import com.BfDmichal.tradingplatform.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class AdvertisementController {
    @Autowired
    private AdService service;
    @Autowired
    private AdvertisementMapper mapper;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private PhotoMapper photoMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/getAdvertisements")
    public List<AdvertisementDto> getAllAdvertisements() {
        return mapper.mapToAdvertisementDtoList(service.getAdvertisements());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAdvertisement")
    public AdvertisementDto getAdvertisement(@RequestParam int id) throws AdvertisementNotFoundException {
        return mapper.mapToAdvertisementDto(service.getAdvertisementById(id).orElseThrow(AdvertisementNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteAdvertisement")
    public void deleteAdvertisement(@RequestParam int id) {
        service.deleteAdvertisement(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createAdvertisement")
    public void createNewAdvertisement(@RequestBody AdvertisementDto advertisementDto) {
        service.saveAdvertisement(mapper.mapToAdvertisement(advertisementDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateAdvertisement")
    public AdvertisementDto updateAdvertisement(@RequestBody AdvertisementDto advertisementDto) {
        return mapper.mapToAdvertisementDto(service.saveAdvertisement(mapper.mapToAdvertisement(advertisementDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getImage")
    public Map getImage() throws Exception {
        return photoService.getImage();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/uploadImage")
    public String uploadImage(@RequestBody PhotoDto photoDto) throws Exception {
        photoService.saveImageInDatabase(photoMapper.mapToPhoto(photoDto));
        return String.valueOf(photoService.uploadImage());
    }
}
