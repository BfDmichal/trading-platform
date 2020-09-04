package com.BfDmichal.tradingplatform.repositories;

import com.BfDmichal.tradingplatform.domain.Advertisement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends CrudRepository<Advertisement,Integer> {
//    @Override
//    Advertisement save(Advertisement advertisement);

    @Override
    void delete(Advertisement advertisement);

    @Override
    List<Advertisement> findAll();
}

