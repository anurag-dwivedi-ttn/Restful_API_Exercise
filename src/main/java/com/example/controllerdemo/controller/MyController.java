package com.example.controllerdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

//    // without response body
//    @GetMapping("/without-body")
//    public String withoutBody() {
//        return "home";
//    }
    //Q1- Simple message Using RestFul API
    @GetMapping("/simpleMsg")
    @ResponseBody
    public String withBody(){
        return "Welcome to spring boot";
    }

}
