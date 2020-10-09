package com.BfDmichal.tradingplatform.domain;



import javax.persistence.*;

@Entity
@Table(name = "PHOTOS")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "URL")
    private String url;
    @Column(name = "PUBLIC_ID")
    private String publicId;
    @ManyToOne
    @JoinColumn(name = "ADVERTISEMENT_ID")
    private Advertisement advertisement;

    public Photo() {
    }

    public Photo(Long id, String url) {
        this.id = id;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
