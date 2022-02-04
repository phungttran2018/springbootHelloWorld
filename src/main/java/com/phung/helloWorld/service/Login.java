package com.phung.helloWorld.service;

import com.phung.helloWorld.model.Entities.Users;
import com.phung.helloWorld.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Login {
    @Autowired
    UsersRepository usersRepository;

    public void registerUser(Users user){
        usersRepository.save(user);
    }
}
