package com.example.onemorereactivemessagingapp.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public final class NewUserDto {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @Email
    private String email;
    private boolean active = true;
    private String phone;
    private String address;
    private String userPic;
    private List<String> contacts = new ArrayList<>();
    private List<String> blackList = new ArrayList<>();
}
