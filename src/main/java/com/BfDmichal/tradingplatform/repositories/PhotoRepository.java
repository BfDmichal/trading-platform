package com.BfDmichal.tradingplatform.repositories;

import com.BfDmichal.tradingplatform.domain.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhotoRepository extends CrudRepository<Photo,Integer> {
    @Override
    Photo save(Photo photo);

    @Override
    Optional<Photo> findById(Integer integer);

    @Override
    Iterable<Photo> findAllById(Iterable<Integer> integers);

  //  Iterable<Integer> findByAdvertisement_Id(Iterable<Integer> advertisementId);

    @Override
    void deleteById(Integer integer);

}
