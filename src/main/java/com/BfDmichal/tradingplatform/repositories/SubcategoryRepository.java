package com.BfDmichal.tradingplatform.repositories;

import com.BfDmichal.tradingplatform.domain.Subcategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubcategoryRepository extends CrudRepository<Subcategory,Integer> {
    @Override
    Subcategory save(Subcategory subcategory);

    @Override
    List<Subcategory> findAll();

    @Override
    Optional<Subcategory> findById(Integer integer);

    @Override
    void deleteById(Integer integer);
}
