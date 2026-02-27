package com.noobsmoke.springsecure.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class HomeController {

    @GetMapping()
    public String homeController() {
        return "Uyster Da Brewster";
    }

    @GetMapping("/token")
    public CsrfToken getCSRFToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/greet")
    public String greet(HttpServletRequest request) {
        return "Welcome ACompleteNoobSmoke: " + request.getSession().getId();
    }
}
