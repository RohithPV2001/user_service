package com.example.userDetails.mapper;

import org.mapstruct.Mapper;

import com.example.userDetails.models.User;
import com.example.userDetails.dto.UserDTO;

@Mapper(componentModel =  "spring")
public interface UserMapper {
    UserDTO mapUserToUserDTO(User user);
    User mapUserDTOtoUser(UserDTO userDTO);
}
