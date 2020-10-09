package com.BfDmichal.tradingplatform.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ADVERTISEMENTS")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(
            targetEntity = Photo.class,
            mappedBy = "advertisement",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Photo> photos = new ArrayList<>();
    @ManyToOne()
    @JoinColumn(name = "SUBCATEGORIES_ID")
    private Subcategory subcategory;
    @Column(name = "TITLE",length = 50,nullable = false)
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DURATION")
    private LocalDate duration;
    @Column(name = "PRICE",nullable = false)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "USERS_ID")
    private User user;


    public Advertisement(Long id, Subcategory subcategory, String title, String description, BigDecimal price, User user) {
        this.id = id;
        this.subcategory = subcategory;
        this.title = title;
        this.description = description;
        this.price = price;
        this.user = user;
    }

    public Advertisement() {
    }

    public Long getId() {
        return id;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public Subcategory getSubcategory() {
        return subcategory;
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

    public User getUser() {
        return user;
    }
}
