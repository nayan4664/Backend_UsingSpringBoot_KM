package com.kavyamargin.backend.dto;

public record AuthResponse(
    String _id,
    String fullName,
    String email,
    String role,
    String contactNo,
    String address,
    String companyName,
    String token
) {
}
