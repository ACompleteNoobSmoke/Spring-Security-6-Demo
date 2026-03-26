package com.noobsmoke.springsecure.service;

import com.noobsmoke.springsecure.model.MyUsers;
import com.noobsmoke.springsecure.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyUserService {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public MyUsers registerNewUser(MyUsers newUser) {
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        userRepo.save(newUser);
        return newUser;
    }
}
