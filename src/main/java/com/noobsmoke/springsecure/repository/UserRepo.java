package com.noobsmoke.springsecure.repository;

import com.noobsmoke.springsecure.model.MyUsers;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;

@Repository
public interface UserRepo extends JpaRepository<MyUsers, Long> {
    MyUsers findByUserID (Long userID);
    MyUsers findByUserName (String userName);
}
