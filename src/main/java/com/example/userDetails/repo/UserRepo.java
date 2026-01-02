package com.example.userDetails.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userDetails.models.*;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
    Optional<User> findByUserNameAndUserPassword(String userName,String userPassword);
}
