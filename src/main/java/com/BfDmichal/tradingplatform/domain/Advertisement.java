package com.BfDmichal.tradingplatform.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name="ADVERTISEMENTS")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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

    private void setId(Long id) {
        this.id = id;
    }

    private void setCategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setDuration(LocalDate duration) {
        this.duration = duration;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
    }

    private void setUser(User user) {
        this.user = user;
    }
}
