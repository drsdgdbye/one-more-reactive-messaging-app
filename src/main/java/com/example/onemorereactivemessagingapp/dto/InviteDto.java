package com.example.onemorereactivemessagingapp.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class InviteDto {
    private String id;
    @NotNull
    private String from;
    @NotNull
    private String to;
    private boolean approved;
}
