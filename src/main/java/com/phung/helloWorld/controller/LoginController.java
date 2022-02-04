package com.phung.helloWorld.controller;

import com.phung.helloWorld.model.Entities.Users;
import com.phung.helloWorld.service.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginController {

    @Autowired
    Login loginService;

    @PostMapping("/registerAUser")
    public ResponseEntity<?> registerAUser (){
        Users user = new Users("Phung", "Tran", "genius124", "123", "admin", "f", "@gmail.com", new Date());
        loginService.registerUser(user);
        return new ResponseEntity<>("added!", HttpStatus.OK);
    }
}
