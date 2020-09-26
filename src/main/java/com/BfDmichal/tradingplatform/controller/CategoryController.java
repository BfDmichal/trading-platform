package com.BfDmichal.tradingplatform.controller;

import com.BfDmichal.tradingplatform.controller.exception.CategoryNotFoundException;
import com.BfDmichal.tradingplatform.domain.dto.CategoryDto;
import com.BfDmichal.tradingplatform.domain.dto.SubcategoryDto;
import com.BfDmichal.tradingplatform.mapper.CategoryMapper;
import com.BfDmichal.tradingplatform.mapper.SubcategoryMapper;
import com.BfDmichal.tradingplatform.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryService service;
    @Autowired
    private SubcategoryMapper subcategoryMapper;

    @RequestMapping(method = RequestMethod.GET,value = "/getCategories")
    public List<CategoryDto> getAllCategories(){
        return categoryMapper.mapToCategoryDto(service.getCategories());
    }
    @RequestMapping(method = RequestMethod.GET,value = "/getCategory")
    public CategoryDto getCategory(@RequestParam Long id) throws Exception {
        return categoryMapper.mapToCategoryDto(service.getCategoryById(id).orElseThrow(Exception::new));
    }
    @RequestMapping(method = RequestMethod.GET,value = "/getAllSubcategories")
    public List<SubcategoryDto> getAllSubcategoriesInCategory(@RequestParam Long id)throws CategoryNotFoundException {
        return subcategoryMapper.mapToSubcategoryDtoList(service.getAllSubcategoriesContainInThisCategory(id));
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/deleteCategory")
    public void deleteCategoryById(@RequestParam Long id){
        service.deleteCategory(id);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/createCategory")
    public void createCategory(@RequestBody CategoryDto categoryDto){
        service.saveCategory(categoryMapper.mapToCategory(categoryDto));
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/updateCategory")
    public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto){
        return categoryMapper.mapToCategoryDto(service.saveCategory(categoryMapper.mapToCategory(categoryDto)));
    }
}
