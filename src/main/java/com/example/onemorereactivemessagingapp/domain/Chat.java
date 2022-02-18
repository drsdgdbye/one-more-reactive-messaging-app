package com.example.onemorereactivemessagingapp.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Chat {
    @Id
    private String id;
    private List<String> members;
    private List<String> messages;
    private boolean active;
}
