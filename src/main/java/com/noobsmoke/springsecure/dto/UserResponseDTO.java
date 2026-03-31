package com.noobsmoke.springsecure.dto;

import com.noobsmoke.springsecure.model.MyUsers;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponseDTO {
    private String jwtToken;
    private MyUsers users;
}