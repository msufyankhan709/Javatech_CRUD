package com.example.Search_APP.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_data")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "search_data")
    private String searchData;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Add other fields as needed
}
