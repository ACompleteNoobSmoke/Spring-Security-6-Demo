package com.noobsmoke.springsecure.config;

import com.noobsmoke.springsecure.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ACompleteNoobUserDetailService implements UserDetailsService {
    private final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("Username Does Not Exist"));
    }

    public UserDetails loadUserByID(Long userID) throws IllegalArgumentException {
        return userRepo.findByUserID(userID).orElseThrow(() -> new IllegalArgumentException("ID Could Not Be Found"));
    }
}
