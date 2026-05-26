package com.ranjankumarmandal.search_service.controller;

import com.ranjankumarmandal.search_service.entity.SearchListing;
import com.ranjankumarmandal.search_service.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping
    public List<SearchListing> search(
            @RequestParam String location
    ) {

        return searchService.searchByLocation(location);
    }

    @GetMapping("/host/{hostId}")
    public List<SearchListing> getByHost(
            @PathVariable Long hostId
    ) {

        return searchService.getByHost(hostId);
    }
}