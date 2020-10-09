package com.BfDmichal.tradingplatform.mapper;

import com.BfDmichal.tradingplatform.domain.dto.PhotoDto;
import com.BfDmichal.tradingplatform.domain.Photo;
import org.springframework.stereotype.Component;

@Component
public class PhotoMapper {
    public Photo mapToPhoto(PhotoDto photoDto){
        return new Photo(photoDto.id, photoDto.secure_url);
    }
}
