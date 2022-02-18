package com.example.onemorereactivemessagingapp.controller;

import com.example.onemorereactivemessagingapp.domain.User;
import com.example.onemorereactivemessagingapp.dto.PostUserDto;
import com.example.onemorereactivemessagingapp.dto.mapper.MapStructMapper;
import com.example.onemorereactivemessagingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("add")
    public Mono<User> addUser(@RequestBody @Valid PostUserDto postUserDto) {
        return userService.addNewUser(postUserDto);
    }

    @GetMapping("all")
    public Flux<User> getUsers() {
        return userService.getAllUsers();
    }
}
