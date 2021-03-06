package com.example.onemorereactivemessagingapp.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetUserDto {
    @NotNull
    private String id;
    @NotNull
    private String username;
    private boolean active;
    private String userPic;
}
