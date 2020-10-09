package com.BfDmichal.tradingplatform.controller;

import com.BfDmichal.tradingplatform.exception.SubcategoryNotFoundException;
import com.BfDmichal.tradingplatform.domain.dto.AdvertisementDto;
import com.BfDmichal.tradingplatform.domain.dto.SubcategoryDto;
import com.BfDmichal.tradingplatform.mapper.AdvertisementMapper;
import com.BfDmichal.tradingplatform.mapper.SubcategoryMapper;
import com.BfDmichal.tradingplatform.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/subcategory")
@CrossOrigin(origins = "*")
public class SubcategoryController {
    @Autowired
    private SubcategoryMapper subcategoryMapper;
    @Autowired
    private SubcategoryService service;
    @Autowired
    private AdvertisementMapper advertisementMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/getSubcategories")
    public List<SubcategoryDto> getAllSubcategories() {
        return subcategoryMapper.mapToSubcategoryDtoList(service.getSubcategories());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getSubcategory")
    public List<AdvertisementDto> getAdvertisementsInSubcategory(@RequestParam int id) throws SubcategoryNotFoundException {
        return advertisementMapper.mapToAdvertisementDtoList(service.getAllAdvertisementsInSubcategoryById(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteSubcategory")
    public void deleteSubcategory(@RequestParam int id) {
        service.deleteSubcategoryById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createSubcategory")
    public void createSubcategory(@RequestBody SubcategoryDto subcategoryDto) {
        service.saveSubcategory(subcategoryMapper.mapToSubcategory(subcategoryDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateSubcategory")
    public SubcategoryDto updateSubcategory(@RequestBody SubcategoryDto subcategoryDto){
        return subcategoryMapper.mapToSubcategoryDto(service.saveSubcategory(subcategoryMapper.mapToSubcategory(subcategoryDto)));
    }
}
