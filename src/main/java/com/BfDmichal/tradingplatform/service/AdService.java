package com.BfDmichal.tradingplatform.service;

import com.BfDmichal.tradingplatform.domain.Advertisement;
import com.BfDmichal.tradingplatform.repositories.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdService {
    @Autowired
    private AdRepository repository;

    public List<Advertisement> getAdvertisements(){
        return repository.findAll();
    }

    public Optional<Advertisement> getAdvertisementById(final int id){
        return repository.findById(id);
    }

    public Advertisement saveAdvertisement(final Advertisement advertisement){
        return repository.save(advertisement);
    }

    public void deleteAdvertisement(final int id){
        repository.deleteById(id);
    }
    public void archiveAdvertisement(final int id){
        //set record on activate/deactivate(archived)
    }

}
