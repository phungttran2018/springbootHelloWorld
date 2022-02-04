package com.phung.helloWorld.controller;

import com.phung.helloWorld.model.RandomNumberRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorldController {

    @PostMapping("/isHealthy")
    public String isHealthy (){
        return "helloWorld";
    }
}
