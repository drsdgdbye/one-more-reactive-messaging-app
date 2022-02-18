package com.example.onemorereactivemessagingapp.dto.mapper;

import com.example.onemorereactivemessagingapp.domain.Chat;
import com.example.onemorereactivemessagingapp.domain.User;
import com.example.onemorereactivemessagingapp.dto.CreateChatDto;
import com.example.onemorereactivemessagingapp.dto.GetUserDto;
import com.example.onemorereactivemessagingapp.dto.PostUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    GetUserDto userToGetUserDto(User user);

    User postUserDtoToUser(PostUserDto postUserDto);

    Chat createChatDtoToChat(CreateChatDto createChatDto);
}
