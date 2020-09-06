package com.BfDmichal.tradingplatform.domain.dto;

import java.util.List;

public class CategoryDto {
    private Long id;
    private String type;
    private List<SubcategoryDto> subcategoryDtos;

    public CategoryDto(Long id,String type, List<SubcategoryDto> subcategoryDtos) {
        this.id = id;
        this.type = type;
        this.subcategoryDtos = subcategoryDtos;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public List<SubcategoryDto> getSubcategoryDtos() {
        return subcategoryDtos;
    }
}
