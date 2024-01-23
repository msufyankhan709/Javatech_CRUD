package com.example.Search_APP.repository;

import com.example.Search_APP.entity.SearchData;
import com.example.Search_APP.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDataRepository extends JpaRepository<UserData, Long> {
    List<UserData> findByUserId(Long userId);

}


