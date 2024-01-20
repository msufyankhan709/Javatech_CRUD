package com.example.Search_APP.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_id")
    private String deviceId;

    @OneToMany(mappedBy = "user")
    private List<SearchData> searches;

    @OneToMany(mappedBy = "user")
    private List<UserData> userData;

    // Add other fields as needed
}
