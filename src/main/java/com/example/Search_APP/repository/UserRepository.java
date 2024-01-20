package com.example.Search_APP.repository;

import com.example.Search_APP.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByDeviceId(String deviceId);
}
