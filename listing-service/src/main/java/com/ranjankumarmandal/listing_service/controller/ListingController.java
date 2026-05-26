package com.ranjankumarmandal.listing_service.controller;

import com.airbnbclone.listing.dto.CreateListingRequest;
import com.airbnbclone.listing.entity.Listing;
import com.airbnbclone.listing.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listings")
@RequiredArgsConstructor
public class ListingController {

    private final ListingService listingService;

    @PostMapping
    public Listing create(
            @RequestBody CreateListingRequest request
    ) {

        return listingService.create(request);
    }

    @GetMapping
    public List<Listing> getAll() {

        return listingService.getAll();
    }

    @GetMapping("/{id}")
    public Listing getById(
            @PathVariable Long id
    ) {

        return listingService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {

        listingService.delete(id);
    }
}