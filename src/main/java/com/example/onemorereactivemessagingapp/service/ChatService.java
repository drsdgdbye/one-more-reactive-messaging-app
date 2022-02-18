package com.example.onemorereactivemessagingapp.service;

import com.example.onemorereactivemessagingapp.repository.ChatRepository;
import com.example.onemorereactivemessagingapp.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;
}
