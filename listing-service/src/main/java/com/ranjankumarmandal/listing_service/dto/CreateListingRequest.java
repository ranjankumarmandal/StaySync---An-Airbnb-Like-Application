package com.ranjankumarmandal.listing_service.dto;

import com.airbnbclone.listing.entity.ListingType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateListingRequest {

    private Long hostId;

    private String title;

    private String description;

    private String location;

    private Integer guests;

    private Integer bedrooms;

    private Integer beds;

    private Integer bathrooms;

    private BigDecimal pricePerNight;

    private ListingType type;
}