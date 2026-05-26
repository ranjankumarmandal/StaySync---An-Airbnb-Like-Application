package com.ranjankumarmandal.listing_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "listings")
@Getter
@Setter
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long hostId;

    private String title;

    @Column(length = 2000)
    private String description;

    private String location;

    private Integer guests;

    private Integer bedrooms;

    private Integer beds;

    private Integer bathrooms;

    private BigDecimal pricePerNight;

    @Enumerated(EnumType.STRING)
    private ListingType type;

    private Boolean available;

    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }
}