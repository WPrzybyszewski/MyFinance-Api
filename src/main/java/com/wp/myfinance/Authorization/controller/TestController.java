package com.wp.myfinance.Authorization.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController("Test")
public class TestController {

    public String Test(){
        return  "Test OK ";
    }
}
