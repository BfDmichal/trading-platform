package com.BfDmichal.tradingplatform.domain.dto;

import java.util.List;

public class SubcategoryDto {
    private Long id;
    private String type;
    private List<AdvertisementDto> advertisementDtoList;

    public SubcategoryDto(Long id, String type, List<AdvertisementDto> advertisementDtoList) {
        this.id = id;
        this.type = type;
        this.advertisementDtoList = advertisementDtoList;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public List<AdvertisementDto> getAdvertisementDtoList() {
        return advertisementDtoList;
    }
}
