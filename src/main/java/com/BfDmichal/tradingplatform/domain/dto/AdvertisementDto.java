package com.BfDmichal.tradingplatform.domain.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

public class AdvertisementDto {
    private Long id;
    private SubcategoryDto subcategoryDto;
    private String title;
    private String description;
    private LocalDate duration;
    private BigDecimal price;
    private UserDto userDto;

    public AdvertisementDto(Long id, SubcategoryDto subcategoryDto, String title, String description, LocalDate duration, BigDecimal price,UserDto userDto) {
        this.id = id;
        this.subcategoryDto = subcategoryDto;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.price = price;
        this.userDto = userDto;
    }

    public Long getId() {
        return id;
    }

    public SubcategoryDto getSubcategoryDto() {
        return subcategoryDto;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDuration() {
        return duration;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public UserDto getUserDto() {
        return userDto;
    }
}
