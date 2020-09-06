package com.BfDmichal.tradingplatform.mapper;

import com.BfDmichal.tradingplatform.domain.Subcategory;
import com.BfDmichal.tradingplatform.domain.dto.SubcategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubcategoryMapper {
    @Autowired
    private AdvertisementMapper mapper;

    public Subcategory mapToSubcategory(SubcategoryDto dto){
        return new Subcategory(dto.getId(),dto.getType(),mapper.mapToAdvertisementList(dto.getAdvertisementDtoList()));
    }
    public SubcategoryDto mapToSubcategoryDto(Subcategory subcategory){
        return new SubcategoryDto(subcategory.getId(),subcategory.getTypeOfSubcategory(),mapper.mapToAdvertisementDtoList(subcategory.getAdvertisementList()));
    }
    public List<Subcategory> mapToSubcategoryList(List<SubcategoryDto> subcategoryDtoList){
        return subcategoryDtoList.stream()
                .map(this::mapToSubcategory)
                .collect(Collectors.toList());
    }
    public List<SubcategoryDto> mapToSubcategoryDtoList(List<Subcategory> subcategoryList){
        return subcategoryList.stream()
                .map(this::mapToSubcategoryDto)
                .collect(Collectors.toList());
    }
}
