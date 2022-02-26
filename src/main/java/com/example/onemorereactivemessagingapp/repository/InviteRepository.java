package com.example.onemorereactivemessagingapp.repository;

import com.example.onemorereactivemessagingapp.domain.Invite;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface InviteRepository extends ReactiveMongoRepository<Invite, String> {
    Flux<Invite> findAllByTo(String ToUsername);

    Mono<Invite> findByFromAndTo(String from, String to);
}
