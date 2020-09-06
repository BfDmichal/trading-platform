package com.BfDmichal.tradingplatform.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CATEGORIES")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NAME", nullable = false, unique = true)
    private String typeOfCategory;
    @OneToMany(
            targetEntity = Subcategory.class,
            mappedBy = "category",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Subcategory> subcategories;

    public Category() {
    }

    public Category(Long id, String typeOfCategory, List<Subcategory> subcategories) {
        this.id = id;
        this.typeOfCategory = typeOfCategory;
        this.subcategories = subcategories;
    }

    public Category(String typeOfCategory, List<Subcategory> subcategories) {
        this.typeOfCategory = typeOfCategory;
        this.subcategories = subcategories;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getTypeOfCategory() {
        return typeOfCategory;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    private void setTypeOfCategory(String type) {
        this.typeOfCategory = type;
    }

    private void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }
}
