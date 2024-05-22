package com.example.userserviceajch.user;


import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;



@Entity
@Getter
@Setter
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String userName;
    private String imageUrl;
    private String userId;

    public UserEntity() {
        userId = UUID.randomUUID().toString();
    }

    public UserEntity(String userName, String imageUrl) {
        this.imageUrl = imageUrl;
        this.userName = userName;
        userId = UUID.randomUUID().toString();
    }

}


