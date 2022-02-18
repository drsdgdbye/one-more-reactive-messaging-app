package com.example.onemorereactivemessagingapp.controller;

import com.example.onemorereactivemessagingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController("profile")
@RequiredArgsConstructor
public class ProfileController {
    private final UserService userService;
}
