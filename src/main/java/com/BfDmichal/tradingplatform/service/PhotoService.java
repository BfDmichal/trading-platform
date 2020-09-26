//package com.BfDmichal.tradingplatform.service;
//
//import com.BfDmichal.tradingplatform.configuration.PhotoUploaderConfiguration;
//import com.BfDmichal.tradingplatform.domain.Photo;
//import com.BfDmichal.tradingplatform.repositories.PhotoRepository;
//import com.cloudinary.utils.ObjectUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.File;
//import java.util.Map;
//
////@Service
//public class PhotoService {
//    @Autowired
//    private PhotoUploaderConfiguration configuration;
//    @Autowired
//    private PhotoRepository photoRepository;
//
//    public Map getImage() throws Exception {
//        return configuration.getCloudinary().api().resource("smuvbfmmylhxfczknwbi", ObjectUtils.emptyMap());
//    }
//    File file = new File("C:\\Users\\Majkel\\Desktop\\photos\\maj.jpg");
//    public Object uploadImage() throws Exception {
//        Map result = configuration.getCloudinary().uploader().upload(file, ObjectUtils.emptyMap());
//        return result.get("secure_url");
//    }
//    public void saveImageInDatabase(Photo photo){
//        photoRepository.save(photo);
//    }
//}
