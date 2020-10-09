package com.BfDmichal.tradingplatform.domain;

import com.BfDmichal.tradingplatform.repositories.CategoryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryDtoTestSuite {

    @Autowired
    CategoryRepository repository;
//    @Autowired
//    private CategoryRepository repository;
//    private Category category;
//    private Subcategory subcategory;
//    private ArrayList<Subcategory> subcategories;

    @Before
    public void setUp() {
//        subcategories = new ArrayList<>();
//        category = new Category("Motoryzacja", subcategories);
//        subcategory = new Subcategory("Obosowe", category);
    }

    @Test
    public void testCategoryDtoSave() {
        //Given
        ArrayList<Subcategory> list = new ArrayList<>();
        Category category = new Category("motoryzacja",list);
        Subcategory subcategory = new Subcategory("Osobowe",category);
        //When
        repository.save(category);
        //Then
        Long id = category.getId();
        Optional<Category> resultCategory = repository.findById(id);
        Assert.assertTrue(resultCategory.isPresent());
        //CleanUp
        repository.deleteById(id);
    }
//
//    @Test
//    public void testCategoryDtoFindById() {
//        //Given
//        repository.save(category);
//        //When
//        Long id = category.getId();
//        Optional<Category> resultCategory = repository.findById(id);
//        //Then
//        Assert.assertEquals(category.getId(), resultCategory.get().getId());
//        //CleanUp
//        repository.deleteById(id);
//    }
}
