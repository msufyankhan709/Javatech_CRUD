package com.example.Search_APP.repository;

import com.example.Search_APP.entity.SearchData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchDataRepository extends JpaRepository<SearchData, Long> {
    List<SearchData> findByUserId(Long userId);
    void deleteByUserId(Long userId);
}



