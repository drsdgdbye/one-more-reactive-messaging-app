package com.example.onemorereactivemessagingapp.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "invites")
public class Invite {
    @Id
    private String id;
    private String from;
    private String to;
    private boolean approved;
}
