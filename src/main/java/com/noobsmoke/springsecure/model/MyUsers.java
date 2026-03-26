package com.noobsmoke.springsecure.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class MyUsers implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    private String userName;
    private String password;
    private List<String> hobbies;

    public MyUsers(String userName, String password, List<String> hobbies) {
        this.userName = userName;
        this.password = password;
        this.hobbies =  hobbies;
    }

    public MyUsers() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }


//    public static class Builder {
//        private final String userName;
//        private final String password;
//        private  List<String> hobbies = new ArrayList<>();
//
//        public Builder(String userName, String password) {
//            this.userName = userName;
//            this.password = password;
//        }
//
//        public Builder hobbies(List<String> hobbies) {
//            this.hobbies = hobbies;
//            return this;
//        }
//
//        public MyUsers build() {
//            return new MyUsers(this);
//        }

 //   }
}
