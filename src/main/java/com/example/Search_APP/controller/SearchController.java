// SearchController.java
package com.example.Search_APP.controller;

import com.example.Search_APP.dto.SearchRequest;
import com.example.Search_APP.entity.SearchData;
import com.example.Search_APP.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/top")
    public List<String> getTopTrendSearch() {
        return searchService.getTopTrendSearch();
    }

    @PostMapping
    public ResponseEntity<String> performSearch(@RequestBody SearchRequest request) {
        try {
            searchService.performSearch(request);
            return ResponseEntity.ok("Search performed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error performing search");
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<SearchData>> getPreviousSearches(@PathVariable Long userId) {
        List<SearchData> searches = searchService.getPreviousSearches(userId);
        return ResponseEntity.ok(searches);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteSearchData(@PathVariable Long userId) {
        try {
            searchService.deleteSearchData(userId);
            return ResponseEntity.ok("Search data deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting search data");
        }
    }
}


