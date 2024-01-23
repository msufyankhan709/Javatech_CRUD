package com.example.Search_APP.service;

import com.example.Search_APP.dto.SearchRequest;
import com.example.Search_APP.entity.SearchData;
import com.example.Search_APP.entity.User;
import com.example.Search_APP.repository.SearchDataRepository;
import com.example.Search_APP.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private final SearchDataRepository searchDataRepository;
    private final UserRepository userRepository;

    @Autowired
    public SearchService(SearchDataRepository searchDataRepository, UserRepository userRepository) {
        this.searchDataRepository = searchDataRepository;
        this.userRepository = userRepository;
    }

    public List<String> getTopTrendSearch() {
        return List.of("Search 1", "Search 2", "Search 3");
    }

public void performSearch(SearchRequest request) {
    try {
        User user = getUserOrCreate(request.getDevice());
        SearchData searchData = new SearchData();
        searchData.setQuery(request.getQuery());
        searchData.setUser(user);
        searchDataRepository.save(searchData);
    } catch (Exception e) {
        // Handle the exception (log or rethrow if necessary)
    }
}


    public List<SearchData> getPreviousSearches(Long userId) {
        List<SearchData> searches = searchDataRepository.findByUserId(userId);
         return searches;
    }

    public void deleteSearchData(Long userId) {
        searchDataRepository.deleteByUserId(userId);
    }

    private User getUserOrCreate(String deviceId) {
        User user = userRepository.findByDeviceId(deviceId);
        if (user == null) {
            user = new User();
            user.setDeviceId(deviceId);
            userRepository.save(user);
        }
        System.out.println(user);
        return user;
    }
}

