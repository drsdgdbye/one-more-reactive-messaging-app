package com.example.onemorereactivemessagingapp.service;

import com.example.onemorereactivemessagingapp.domain.User;
import com.example.onemorereactivemessagingapp.dto.PostUserDto;
import com.example.onemorereactivemessagingapp.dto.mapper.MapStructMapper;
import com.example.onemorereactivemessagingapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final MapStructMapper mapper;

    public Mono<User> addNewUser(PostUserDto postUserDto) {
        return userRepository.save(mapper.postUserDtoToUser(postUserDto));
    }

    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }
}
