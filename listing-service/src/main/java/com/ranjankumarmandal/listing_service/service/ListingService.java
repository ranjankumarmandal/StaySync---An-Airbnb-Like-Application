package com.ranjankumarmandal.listing_service.service;

import com.airbnbclone.listing.dto.CreateListingRequest;
import com.airbnbclone.listing.entity.Listing;
import com.airbnbclone.listing.repository.ListingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListingService {

    private final ListingRepository listingRepository;

    public Listing create(CreateListingRequest request) {

        Listing listing = new Listing();

        listing.setHostId(request.getHostId());
        listing.setTitle(request.getTitle());
        listing.setDescription(request.getDescription());
        listing.setLocation(request.getLocation());
        listing.setGuests(request.getGuests());
        listing.setBedrooms(request.getBedrooms());
        listing.setBeds(request.getBeds());
        listing.setBathrooms(request.getBathrooms());
        listing.setPricePerNight(request.getPricePerNight());
        listing.setType(request.getType());
        listing.setAvailable(true);

        return listingRepository.save(listing);
    }

    public List<Listing> getAll() {

        return listingRepository.findAll();
    }

    public Listing getById(Long id) {

        return listingRepository.findById(id)
                .orElseThrow();
    }

    public void delete(Long id) {

        listingRepository.deleteById(id);
    }
}