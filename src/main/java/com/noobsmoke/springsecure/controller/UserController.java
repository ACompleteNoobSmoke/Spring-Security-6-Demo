package com.noobsmoke.springsecure.controller;

import com.noobsmoke.springsecure.model.MyUsers;
import com.noobsmoke.springsecure.service.MyUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
@AllArgsConstructor
public class UserController {

    private final MyUserService userService;

    @PostMapping("/register")
    public ResponseEntity<MyUsers> register(@RequestBody MyUsers newUser) {
        System.out.println("Test");
        return ResponseEntity.ok(userService.registerNewUser(newUser));
    }
}
