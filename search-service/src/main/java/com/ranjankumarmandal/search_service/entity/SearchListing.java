package com.ranjankumarmandal.search_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "search_listings")
@Getter
@Setter
public class SearchListing {

    @Id
    private Long id;

    private Long hostId;

    private String title;

    private String location;

    private Integer guests;

    private BigDecimal pricePerNight;

    @Enumerated(EnumType.STRING)
    private ListingType type;

    private Boolean available;
}