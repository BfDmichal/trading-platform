package com.BfDmichal.tradingplatform.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SUBCATEGORIES")
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NAME", unique = true, nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "CATEGORIES_ID")
    private Category category;
    @OneToMany(
            targetEntity = Advertisement.class,
            mappedBy = "subcategory",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Advertisement> advertisementList;

    public Subcategory() {
    }

    public Subcategory(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public Subcategory(Long id, String name, List<Advertisement> advertisementList) {
        this.id = id;
        this.name = name;
        this.advertisementList = advertisementList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public List<Advertisement> getAdvertisementList() {
        return advertisementList;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setCategory(Category category) {
        this.category = category;
    }

    private void setAdvertisementList(List<Advertisement> advertisementList) {
        this.advertisementList = advertisementList;
    }
}
