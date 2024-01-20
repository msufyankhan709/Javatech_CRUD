// UserService.java
package com.example.Search_APP.service;

import com.example.Search_APP.dto.UserDataRequest;
import com.example.Search_APP.entity.User;
import com.example.Search_APP.entity.UserData;
import com.example.Search_APP.repository.UserDataRepository;
import com.example.Search_APP.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService { private final UserRepository userRepository;
    private final UserDataRepository userDataRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserDataRepository userDataRepository) {
        this.userRepository = userRepository;
        this.userDataRepository = userDataRepository;
    }

    public void addUserData(UserDataRequest request) {
        User user = getUserOrCreate(request.getDevice());
        UserData userData = new UserData();
        userData.setSearchData(request.getSearchData());
        userData.setUser(user);
        userDataRepository.save(userData);
    }

    private User getUserOrCreate(String deviceId) {
        User user = userRepository.findByDeviceId(deviceId);
        if (user == null) {
            user = new User();
            user.setDeviceId(deviceId);
          user=userRepository.save(user);
        }
        return user;
    }
}


