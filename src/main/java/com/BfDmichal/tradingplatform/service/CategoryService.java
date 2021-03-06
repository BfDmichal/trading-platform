package com.BfDmichal.tradingplatform.service;

import com.BfDmichal.tradingplatform.exception.CategoryNotFoundException;
import com.BfDmichal.tradingplatform.domain.Category;
import com.BfDmichal.tradingplatform.domain.Subcategory;
import com.BfDmichal.tradingplatform.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> getCategories(){
        return repository.findAll();
    }
    public Optional<Category> getCategoryById(Long id){
        return repository.findById(id);
    }
    public List<Subcategory> getAllSubcategoriesContainInThisCategory(final Long id) throws CategoryNotFoundException {
        Category category = repository.findById(id).orElseThrow(CategoryNotFoundException::new);
        return category.getSubcategories();
    }
    public Category saveCategory(final Category category){
        return repository.save(category);
    }
    public void deleteCategory(final Long id){
        repository.deleteById(id);
    }
}
