package com.example.userDetails.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userDetails.dto.UserDTO;
import com.example.userDetails.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userService;


    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        UserDTO user = userService.addUser(userDTO);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> fetchUserById(@PathVariable int id){
        return userService.fetchUserById(id);
    }

    @GetMapping("/login")
    public ResponseEntity<UserDTO> verifyLogin(@RequestParam String userName, @RequestParam String userPassword){
        return userService.verifyLogin(userName,userPassword);
    }


}
