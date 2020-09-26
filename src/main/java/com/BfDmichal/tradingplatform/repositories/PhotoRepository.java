package com.BfDmichal.tradingplatform.repositories;

import com.BfDmichal.tradingplatform.domain.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends CrudRepository<Photo,Integer> {
    @Override
    Photo save(Photo photo);

    @Override
    List<Photo> findAll();

    @Override
    void deleteById(Integer integer);

}
