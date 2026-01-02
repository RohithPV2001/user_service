package com.example.userDetails.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.userDetails.dto.UserDTO;
import com.example.userDetails.mapper.UserMapper;
import com.example.userDetails.models.User;
import com.example.userDetails.repo.UserRepo;

@Service
public class UserService{

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserMapper mapper;

    public UserDTO addUser(UserDTO user){
        User savedUser = userRepo.save(mapper.mapUserDTOtoUser(user));
        return mapper.mapUserToUserDTO(savedUser);
    }

    public ResponseEntity<UserDTO> fetchUserById(int id){
        Optional<User> user = userRepo.findById(id);
        if(user.isPresent()){
            return new ResponseEntity<>(mapper.mapUserToUserDTO(user.get()),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<UserDTO> verifyLogin(String userName, String userPassword){
        Optional<User> user = userRepo.findByUserNameAndUserPassword(userName,userPassword);
        if(user.isPresent()){
            return new ResponseEntity<>(mapper.mapUserToUserDTO(user.get()),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
    }

}