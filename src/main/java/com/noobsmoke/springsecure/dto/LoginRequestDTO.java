package com.noobsmoke.springsecure.dto;

public record LoginRequestDTO(
        String username,
        String password
) {
}
