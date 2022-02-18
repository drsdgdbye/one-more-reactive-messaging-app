package com.example.onemorereactivemessagingapp.repository;

import com.example.onemorereactivemessagingapp.domain.Chat;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends ReactiveMongoRepository<Chat, String> {
}
