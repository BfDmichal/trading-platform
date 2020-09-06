package com.BfDmichal.tradingplatform.service;

import com.BfDmichal.tradingplatform.controller.exception.SubcategoryNotFoundException;
import com.BfDmichal.tradingplatform.domain.Advertisement;
import com.BfDmichal.tradingplatform.domain.Subcategory;
import com.BfDmichal.tradingplatform.repositories.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoryService {
    @Autowired
    private SubcategoryRepository repository;

    public List<Subcategory> getSubcategories(){
        return repository.findAll();
    }
    public List<Advertisement> getAllAdvertisementsInSubcategoryById(final int id) throws SubcategoryNotFoundException {
        Subcategory subcategory = repository.findById(id).orElseThrow(SubcategoryNotFoundException::new);
        return subcategory.getAdvertisementList();
    }
    public void deleteSubcategoryById(final int id){
        repository.deleteById(id);
    }
    public Subcategory saveSubcategory(final Subcategory subcategory){
        return repository.save(subcategory);
    }
}
