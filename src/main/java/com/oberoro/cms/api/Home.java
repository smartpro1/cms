package com.oberoro.cms.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Home {

    @GetMapping
    public String homePage(){

        return "Application works, app started on " + new Date();
    }
}
