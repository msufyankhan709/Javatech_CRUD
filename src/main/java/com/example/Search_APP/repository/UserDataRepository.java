package com.example.Search_APP.repository;

import com.example.Search_APP.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, Long> {
}


