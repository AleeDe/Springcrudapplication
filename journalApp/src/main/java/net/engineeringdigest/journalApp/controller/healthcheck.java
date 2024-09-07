package net.engineeringdigest.journalApp.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthcheck {
    @GetMapping("/healthcheck")
    public String healthcheck(){
        return "okay ";
    }
}
