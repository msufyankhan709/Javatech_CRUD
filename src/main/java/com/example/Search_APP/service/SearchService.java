////package com.example.Search_APP.service;
////
////import com.example.Search_APP.entity.SearchData;
////import com.example.Search_APP.entity.User;
////import com.example.Search_APP.repository.SearchDataRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import java.util.List;
////
////@Service
////public class SearchService {
////
////    private final SearchDataRepository searchDataRepository;
////
////    @Autowired
////    public SearchService(SearchDataRepository searchDataRepository) {
////        this.searchDataRepository = searchDataRepository;
////    }
////
////    public List<String> getTopTrendSearch() {
////        // Implement logic to get top trend search data
////        // Return a list of top trend searches
////        // (Note: This is just a placeholder, actual implementation depends on your requirements)
////        return List.of("Search 1", "Search 2", "Search 3");
////    }
////
////    public void performSearch(SearchRequest request) {
////        // Implement logic to store search data
////        var user = getUserOrCreate(request.getDevice());
////        var searchData = new SearchData();
////        searchData.setQuery(request.getQuery());
////        searchData.setUser(user);
////        searchDataRepository.save(searchData);
////    }
////
////    public List<SearchData> getPreviousSearches(Long userId) {
////        // Implement logic to retrieve previous searches
////        // Use searchDataRepository to find searches by user ID
////        return searchDataRepository.findByUserId(userId);
////    }
////
////    public void deleteSearchData(Long userId) {
////        // Implement logic to delete search data
////        // Use searchDataRepository to delete searches by user ID
////        searchDataRepository.deleteByUserId(userId);
////    }
////
////    private User getUserOrCreate(String deviceId) {
////        // Implement logic to get user by device ID or create a new user
////        // Use userRepository to find or save the user
////        var user = userRepository.findByDeviceId(deviceId);
////        if (user == null) {
////            user = new User();
////            user.setDeviceId(deviceId);
////            userRepository.save(user);
////        }
////        return user;
////    }
////}
//
//package com.example.Search_APP.service;
//
//import com.example.Search_APP.entity.SearchData;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//public interface SearchService {
//    List<SearchData> getTopTrendSearch();
//    SearchData performSearch(String query, String device);
//    List<SearchData> retrievePreviousSearches(Long id, String device);
//    void deleteSearchData(Long id, String device, String location);
//}
// SearchService.java
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
        User user = getUserOrCreate(request.getDevice());
        SearchData searchData = new SearchData();
        searchData.setQuery(request.getQuery());
        searchData.setUser(user);
        searchDataRepository.save(searchData);
    }

    public List<SearchData> getPreviousSearches(Long userId) {
        List<SearchData> searches= searchDataRepository.findByUserId(userId);
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

