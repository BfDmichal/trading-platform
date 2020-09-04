package com.BfDmichal.tradingplatform.domain;

import com.BfDmichal.tradingplatform.domain.User;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ADVERTISEMENTS")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "CATEGORY",nullable = false)
    private String category;
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

    public Advertisement(String category, String title, String description, BigDecimal price, User user) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.price = price;
        this.user = user;
    }
}
