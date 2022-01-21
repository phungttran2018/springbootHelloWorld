package com.phung.helloWorld.controller;

import com.phung.helloWorld.model.RandomNumberRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorldController {
    @PostMapping("/testing")
    public List<Integer> getTesting (@RequestBody String a){
        Integer in = Integer.parseInt(a);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < in; i++){
            list.add((int) Math.random());
        }
        return list;
    }

    @GetMapping("/testing1/{id}")
    public List<Integer> getRandomNumbers (@PathVariable String id){
        Integer in = Integer.parseInt(id);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < in; i++){
            list.add((int) Math.random());
        }
        return list;
    }

    @PostMapping("/testing23")
    public List<Integer> getRandomTrstNumber (@RequestBody RandomNumberRequest request){
        List<Integer> list = new ArrayList<>();
        //your program will only process for us country only
        //pass in country as Japan
//testing
        return list;
    }
}
