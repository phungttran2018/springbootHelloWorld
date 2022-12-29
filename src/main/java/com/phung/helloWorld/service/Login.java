package com.phung.helloWorld.service;

import com.phung.helloWorld.model.requests.RegisterUserRequest;
import com.phung.helloWorld.repository.inventory.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Login {
    @Autowired
    UsersRepository usersRepository;

    public void registerUser(RegisterUserRequest user){
//        usersRepository.save(user);
    }
}
