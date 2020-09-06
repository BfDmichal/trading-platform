package com.BfDmichal.tradingplatform.mapper;

import com.BfDmichal.tradingplatform.domain.Advertisement;
import com.BfDmichal.tradingplatform.domain.dto.AdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdvertisementMapper {
    @Autowired
    private SubcategoryMapper subcategoryMapper;
    @Autowired
    private UserMapper userMapper;

    public Advertisement mapToAdvertisement(AdvertisementDto dto){
        return new Advertisement(dto.getId(),subcategoryMapper.mapToSubcategory(dto.getSubcategoryDto()),dto.getTitle(),dto.getDescription(),dto.getPrice(),userMapper.mapToUser(dto.getUserDto()));
    }
    public AdvertisementDto mapToAdvertisementDto(Advertisement ad){
        return new AdvertisementDto(ad.getId(),subcategoryMapper.mapToSubcategoryDto(ad.getSubcategory()),ad.getTitle(),ad.getDescription(),ad.getDuration(),ad.getPrice(),userMapper.mapToUserDto(ad.getUser()));
    }
    public List<AdvertisementDto> mapToAdvertisementDtoList(List<Advertisement> list){
        return list.stream()
                .map(this::mapToAdvertisementDto)
                .collect(Collectors.toList());
    }
    public List<Advertisement> mapToAdvertisementList(List<AdvertisementDto> list){
        return list.stream()
                .map(this::mapToAdvertisement)
                .collect(Collectors.toList());
    }

}
