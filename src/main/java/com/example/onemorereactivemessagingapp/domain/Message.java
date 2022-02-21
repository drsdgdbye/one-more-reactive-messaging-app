package com.example.onemorereactivemessagingapp.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Builder
@Document(collection = "messages")
public class Message {
    @Id
    private String id;
    private String chat_id;
    private String from;
    private String to;
    private String data;
    private Instant timestamp;
    private String status;
}
