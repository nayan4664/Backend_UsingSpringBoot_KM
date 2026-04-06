package com.kavyamargin.backend.service;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.kavyamargin.backend.dto.AuthResponse;
import com.kavyamargin.backend.dto.LoginRequest;
import com.kavyamargin.backend.dto.RegisterRequest;
import com.kavyamargin.backend.model.User;
import com.kavyamargin.backend.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AuthResponse login(LoginRequest request) {
        String normalizedEmail = request.email().trim().toLowerCase();
        User user = userRepository.findByEmailIgnoreCase(normalizedEmail)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password"));

        if (!passwordEncoder.matches(request.password(), user.passwordHash())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password");
        }

        return toResponse(user);
    }

    public AuthResponse register(RegisterRequest request) {
        String normalizedEmail = request.email().trim().toLowerCase();
        
        var existingUserOpt = userRepository.findByEmailIgnoreCase(normalizedEmail);
        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            existingUser.setFullName(request.fullName().trim());
            existingUser.setPasswordHash(hashPassword(request.password()));
            existingUser.setRole(request.role().trim());
            existingUser.setContactNo(request.contactNo().trim());
            existingUser.setAddress(request.address().trim());
            existingUser.setCompanyName(request.companyName().trim());
            existingUser.setActive(true);
            User savedUser = userRepository.save(existingUser);
            return toResponse(savedUser);
        }

        User savedUser = userRepository.save(new User(
            null,
            request.fullName().trim(),
            normalizedEmail,
            hashPassword(request.password()),
            request.role().trim(),
            request.contactNo().trim(),
            request.address().trim(),
            request.companyName().trim(),
            true,
            Instant.now()
        ));
        return toResponse(savedUser);
    }

    public String hashPassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    private AuthResponse toResponse(User user) {
        String payload = user.id() + ":" + user.email() + ":" + System.currentTimeMillis();
        String token = Base64.getEncoder().encodeToString(payload.getBytes(StandardCharsets.UTF_8));
        return new AuthResponse(
            user.id(),
            user.fullName(),
            user.email(),
            user.role(),
            user.contactNo(),
            user.address(),
            user.companyName(),
            token
        );
    }
}
