package com.noobsmoke.springsecure.config;

import com.noobsmoke.springsecure.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class JWTAuthFilter extends OncePerRequestFilter {

    private final JWTService jwtService;
    private final ACompleteNoobUserDetailService userDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.equals("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String authToken = authHeader.substring(7);
        final String extractedUsername = jwtService.extractUsername(authToken);

        if (extractedUsername != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            final UserDetails userDetails = userDetailService.loadUserByUsername(extractedUsername);

            if (jwtService.isTokenValid(authToken, userDetails)) {

            }
        }

    }
}
