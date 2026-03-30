package com.noobsmoke.springsecure.service;

import com.noobsmoke.springsecure.dto.LoginRequestDTO;
import com.noobsmoke.springsecure.model.MyUsers;
import com.noobsmoke.springsecure.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyUserService {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private AuthenticationManager authenticationManager;


    public MyUsers registerNewUser(MyUsers newUser) {
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        userRepo.save(newUser);
        return newUser;
    }

    public MyUsers loginUser(LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDTO.username(),
                        loginRequestDTO.password()
                )
        );
        if (!authentication.isAuthenticated()) throw new RuntimeException("Not Authenticated");
        return userRepo.findByUserName(loginRequestDTO.username()).orElseThrow(() -> new RuntimeException("User Cannot Be Found!"));
    }
}
