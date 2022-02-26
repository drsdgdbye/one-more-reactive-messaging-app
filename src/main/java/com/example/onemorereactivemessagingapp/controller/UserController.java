package com.example.onemorereactivemessagingapp.controller;

import com.example.onemorereactivemessagingapp.dto.GetUserDto;
import com.example.onemorereactivemessagingapp.dto.InviteDto;
import com.example.onemorereactivemessagingapp.dto.NewUserDto;
import com.example.onemorereactivemessagingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "users")
public class UserController {
    private final UserService userService;

    @PostMapping("register")
    public Mono<GetUserDto> addNewUser(@RequestBody @NotNull @Valid NewUserDto newUserDto) {
        return userService.addNewUser(newUserDto);
    }

    @GetMapping("contacts")
    public Flux<GetUserDto> getContacts(Principal principal) {
        return userService.getContactsOfUser(principal);
    }

    @PostMapping("invite-to-contacts")
    public Mono<ResponseEntity<InviteDto>> inviteUserToContacts(@RequestBody @Valid InviteDto inviteDto) {
        return Mono.just(inviteDto)
                .flatMap(userService::createInvite)
                .flatMap(dto -> Mono.just(ResponseEntity.ok().body(dto)));
    }

    @GetMapping("invites")
    public Flux<InviteDto> getInvites(Principal forPrincipal) {
        return userService.getAllInvites(forPrincipal);
    }

    @PostMapping(value = "approve")
    public Mono<Void> approveInvite(@RequestBody @Valid InviteDto inviteDto) {
        return userService.addToContactsOrDiscard(inviteDto);
    }
}
