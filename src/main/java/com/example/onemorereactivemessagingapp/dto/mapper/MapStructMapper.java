package com.example.onemorereactivemessagingapp.dto.mapper;

import com.example.onemorereactivemessagingapp.domain.Chat;
import com.example.onemorereactivemessagingapp.domain.Invite;
import com.example.onemorereactivemessagingapp.domain.User;
import com.example.onemorereactivemessagingapp.dto.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    GetUserDto userToGetUserDto(User user);

    User postUserDtoToUser(PostUserDto postUserDto);

    Chat createChatDtoToChat(CreateChatDto createChatDto);

    InviteDto inviteToInviteDto(Invite invite);

    Invite inviteDtoToInvite(InviteDto inviteDto);

    User newUserDtoToUser(NewUserDto newUserDto);

    NewUserDto userToNewUserDto(User user);
}
