package com.BfDmichal.tradingplatform.domain;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "EMAIL", nullable = false, unique = true, length = 30)
    private String email;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "PHONE", nullable = false, length = 9)
    private int phone;
    @OneToMany(
            targetEntity = Advertisement.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Advertisement> advertisementList = new ArrayList<>();
    private Role role;

    public User(int id, String email, String password, int phone, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    public User() {
    }

    public Role getRole() {
        return role;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getPhone() {
        return phone;
    }

    public List<Advertisement> getAdvertisementList() {
        return advertisementList;
    }
}
