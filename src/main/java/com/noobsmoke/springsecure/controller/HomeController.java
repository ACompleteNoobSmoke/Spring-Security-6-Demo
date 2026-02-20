package com.noobsmoke.springsecure.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class HomeController {

    @GetMapping("/")
    public String homeController() {
        return "Uyster Da Brewster";
    }

    @GetMapping("/greet")
    public String greet(HttpServletRequest request) {
        return "Welcome ACompleteNoobSmoke: " + request.changeSessionId();
    }
}
