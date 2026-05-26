package com.ranjankumarmandal.search_service.repository;

import com.ranjankumarmandal.search_service.entity.SearchListing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchRepository extends JpaRepository<SearchListing, Long> {

    List<SearchListing> findByLocationContainingIgnoreCase(String location);

    List<SearchListing> findByHostId(Long hostId);
}