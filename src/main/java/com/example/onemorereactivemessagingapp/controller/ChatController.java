package com.example.onemorereactivemessagingapp.controller;

import com.example.onemorereactivemessagingapp.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController("chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;
}
