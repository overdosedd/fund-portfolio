package com.example.mutualfundportfolio.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Value("${jwt.secret}")
    private String secretKey;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return; // no token, continue without authentication
        }

        final String token = authHeader.substring(7);
        System.out.println("Auth header: " + authHeader);
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String username = claims.getSubject();
            System.out.println("Parsed username from token: " + username);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        } catch (Exception e) {
            // invalid token
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        filterChain.doFilter(request, response);
    }
}
