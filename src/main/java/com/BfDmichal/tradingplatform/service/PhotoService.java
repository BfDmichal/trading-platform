package com.BfDmichal.tradingplatform.service;

import com.BfDmichal.tradingplatform.configuration.PhotoUploaderConfiguration;
import com.BfDmichal.tradingplatform.domain.Advertisement;
import com.BfDmichal.tradingplatform.domain.Photo;
import com.BfDmichal.tradingplatform.exception.AdvertisementNotFoundException;
import com.BfDmichal.tradingplatform.repositories.AdRepository;
import com.BfDmichal.tradingplatform.repositories.PhotoRepository;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PhotoService {
    @Autowired
    private PhotoUploaderConfiguration configuration;
    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private AdRepository adRepository;

    public String getUrlOfImage(int id) throws Exception {
        return photoRepository.findById(id).get().getUrl();
    }

    public Object uploadImage(String localUrl) throws Exception {
        File file = new File(localUrl);
        Map result = configuration.getCloudinary().uploader().upload(file, ObjectUtils.emptyMap());
        return result.get("secure_url");
    }

    public void save(Photo photo) {
        photoRepository.save(photo);
    }

    public List<String> getPhotosListBelongsToAdvertisement(int advertisementId) throws Exception {
        Advertisement advertisement = adRepository.findById(advertisementId).orElseThrow(AdvertisementNotFoundException::new);
        List<String> listWithPhotoUrls = new ArrayList<>();
        for (Photo p :
                advertisement.getPhotos()) {
            listWithPhotoUrls.add(p.getUrl());
        }
        return listWithPhotoUrls;
    }

    public void deletePhoto(int photoId) {
        photoRepository.deleteById(photoId);
    }
}
