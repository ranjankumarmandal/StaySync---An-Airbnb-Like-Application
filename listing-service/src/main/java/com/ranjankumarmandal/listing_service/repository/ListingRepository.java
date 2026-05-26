package com.ranjankumarmandal.listing_service.repository;

import com.airbnbclone.listing.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, Long> {

    List<Listing> findByHostId(Long hostId);

    List<Listing> findByLocationContainingIgnoreCase(String location);
}