package com.example.onemorereactivemessagingapp.repository;

import com.example.onemorereactivemessagingapp.domain.Message;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends ReactiveMongoRepository<Message, String> {
}
