package com.example.onemorereactivemessagingapp.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PostUserDto {
    private String id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @Email
    private String email;
    private boolean active;
    private String phone;
    private String address;
    private String userPic;
    private List<String> contacts;
    private List<String> blackList;
}
