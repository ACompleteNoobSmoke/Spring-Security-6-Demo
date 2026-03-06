package com.noobsmoke.springsecure.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class MyUsers {

    private Long userID;
    private final String userName;
    private String password;
    private List<String> hobbies;

    public MyUsers(Builder builder) {
        this.userName = builder.userName;
        this.password = builder.password;
        this.hobbies = builder.hobbies;
    }


    public static class Builder {
        private final String userName;
        private final String password;
        private  List<String> hobbies = new ArrayList<>();

        public Builder(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public Builder hobbies(List<String> hobbies) {
            this.hobbies = hobbies;
            return this;
        }

        public MyUsers build() {
            return new MyUsers(this);
        }


    }
}
