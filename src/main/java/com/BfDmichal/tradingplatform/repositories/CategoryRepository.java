package com.BfDmichal.tradingplatform.repositories;

import com.BfDmichal.tradingplatform.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer> {

    @Override
    Category save(Category category);

    @Override
    List<Category> findAll();

    @Override
    Optional<Category> findById(Integer integer);

    @Override
    void deleteById(Integer integer);
}
