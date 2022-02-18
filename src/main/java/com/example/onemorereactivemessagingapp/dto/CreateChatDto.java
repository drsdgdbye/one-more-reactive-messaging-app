package com.example.onemorereactivemessagingapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateChatDto {
    private List<String> members;
}
