package com.ranjankumarmandal.search_service.service;

import com.ranjankumarmandal.search_service.entity.SearchListing;
import com.ranjankumarmandal.search_service.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchRepository searchRepository;

    public List<SearchListing> searchByLocation(String location) {

        return searchRepository
                .findByLocationContainingIgnoreCase(location);
    }

    public List<SearchListing> getByHost(Long hostId) {

        return searchRepository.findByHostId(hostId);
    }
}