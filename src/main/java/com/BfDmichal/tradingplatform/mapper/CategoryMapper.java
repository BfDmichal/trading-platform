package com.BfDmichal.tradingplatform.mapper;

import com.BfDmichal.tradingplatform.domain.Category;
import com.BfDmichal.tradingplatform.domain.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {
    @Autowired
    private SubcategoryMapper subcategoryMapper;

    public Category mapToCategory(CategoryDto categoryDto){
        return new Category(categoryDto.getId(),categoryDto.getType(),subcategoryMapper.mapToSubcategoryList(categoryDto.getSubcategoryDtos()));
    }
    public CategoryDto mapToCategoryDto(Category category){
        return new CategoryDto(category.getId(),category.getTypeOfCategory(), subcategoryMapper.mapToSubcategoryDtoList(category.getSubcategories()));
    }
    public List<CategoryDto> mapToCategoryDto(List<Category> categoryList){
        return categoryList.stream()
                .map(this::mapToCategoryDto)
                .collect(Collectors.toList());
    }
}
