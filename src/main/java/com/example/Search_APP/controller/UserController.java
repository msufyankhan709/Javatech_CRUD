// AddUserController.java
package com.example.Search_APP.controller;

import com.example.Search_APP.dto.UserDataRequest;
import com.example.Search_APP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/add/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<String> addUserData(@RequestBody UserDataRequest request) {
        try {
            userService.addUserData(request);
            return ResponseEntity.ok("User data added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding user data");
        }
    }
}
