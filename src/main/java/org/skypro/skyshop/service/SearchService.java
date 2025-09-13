package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Collection<SearchResult> search (String searchTerm){
        return storageService.getAllSearchable().stream()
                .filter(s -> s.findSearchTerm().contains(searchTerm))
                .map(SearchResult::fromSearchable)
                .toList();
    }
}
