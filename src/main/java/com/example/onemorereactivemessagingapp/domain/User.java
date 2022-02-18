package com.example.onemorereactivemessagingapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "users")
@AllArgsConstructor
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private boolean active;
    private String phone;
    private String address;
    private String userPic;
    private List<String> contacts;
    private List<String> blackList;
}
