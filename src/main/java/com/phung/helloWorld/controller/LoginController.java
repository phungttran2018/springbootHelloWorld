package com.phung.helloWorld.controller;

import com.phung.helloWorld.model.requests.RegisterUserRequest;
import com.phung.helloWorld.service.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    Login loginService;

    @PostMapping("/registerAUser")
    public ResponseEntity<?> registerAUser (@RequestBody RegisterUserRequest request){
        loginService.registerUser(request);
        return new ResponseEntity<>("added!", HttpStatus.OK);
    }
}
