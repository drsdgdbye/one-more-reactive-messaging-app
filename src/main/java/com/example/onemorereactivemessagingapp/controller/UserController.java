package com.example.onemorereactivemessagingapp.controller;

import com.example.onemorereactivemessagingapp.domain.User;
import com.example.onemorereactivemessagingapp.dto.PostUserDto;
import com.example.onemorereactivemessagingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.security.Principal;

@RestController
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

    @GetMapping(value = "hello")
    @ResponseStatus(HttpStatus.OK)
    public Mono<String> hello(Mono<Principal> principal) {
        return principal.map(Principal::getName).map(name -> String.format("Hello, %s", name));
    }
}
