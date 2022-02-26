package com.example.onemorereactivemessagingapp.service;

import com.example.onemorereactivemessagingapp.config.SecurityConfig;
import com.example.onemorereactivemessagingapp.domain.Invite;
import com.example.onemorereactivemessagingapp.domain.User;
import com.example.onemorereactivemessagingapp.dto.GetUserDto;
import com.example.onemorereactivemessagingapp.dto.InviteDto;
import com.example.onemorereactivemessagingapp.dto.NewUserDto;
import com.example.onemorereactivemessagingapp.dto.PostUserDto;
import com.example.onemorereactivemessagingapp.dto.mapper.MapStructMapper;
import com.example.onemorereactivemessagingapp.repository.InviteRepository;
import com.example.onemorereactivemessagingapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService {
    private final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final InviteRepository inviteRepository;
    private final MapStructMapper mapper;
    private final PasswordEncoder encoder;

    public Mono<GetUserDto> addNewUser(NewUserDto newUserDto) {
        return userRepository.findByUsername(newUserDto.getUsername())
                .switchIfEmpty(userRepository.save(mapper.newUserDtoToUser(newUserDto)))
                        .flatMap(u -> {
                            u.setPassword(encoder.encode(u.getPassword()));
                            log.info(u + " created");
                            return Mono.just(mapper.userToGetUserDto(u));
                        });
    }

    public Mono<InviteDto> createInvite(InviteDto inviteDto) {
       return inviteRepository.findByFromAndTo(inviteDto.getFrom(), inviteDto.getTo())
                .switchIfEmpty(inviteRepository.save(mapper.inviteDtoToInvite(inviteDto)))
                .flatMap(invite -> Mono.just(mapper.inviteToInviteDto(invite)));
    }

    public Flux<GetUserDto> getContactsOfUser(Principal principal) {
        return userRepository.findByUsername(principal.getName())
                .flatMap(user -> Mono.just(user.getContacts()))
                .flatMapMany(Flux::fromIterable)
                .flatMap(userRepository::findByUsername)
                .flatMap(user -> Flux.just(mapper.userToGetUserDto(user)));
    }

    public Flux<InviteDto> getAllInvites(Principal principal) {
        return inviteRepository.findAllByTo(principal.getName())
                .flatMap(invite -> Flux.just(mapper.inviteToInviteDto(invite)));
    }

    public Mono<Void> addToContactsOrDiscard(InviteDto inviteDto) {
        if (inviteDto.isApproved()) {
            userRepository.findByUsername(inviteDto.getFrom()).flatMap(userFrom -> {
                userFrom.getContacts().add(inviteDto.getTo());
                return userRepository.save(userFrom);
            }).subscribeOn(Schedulers.boundedElastic())
                    .subscribe(user -> log.info(user + " edited"), t -> log.error(t.getMessage()));
            userRepository.findByUsername(inviteDto.getTo()).flatMap(userTo -> {
                userTo.getContacts().add(inviteDto.getFrom());
                return userRepository.save(userTo);
            }).subscribeOn(Schedulers.boundedElastic())
                    .subscribe(user -> log.info(user + " edited"), t -> log.error(t.getMessage()));
        }

        return inviteRepository.findById(inviteDto.getId()).flatMap(this::deleteInvite);
    }

    private Mono<Void> deleteInvite(Invite invite) {
        return inviteRepository.delete(invite);
    }
}
