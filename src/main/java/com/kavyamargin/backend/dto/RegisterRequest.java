package com.kavyamargin.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(
    @NotBlank String fullName,
    @NotBlank String contactNo,
    @NotBlank @Email String email,
    @NotBlank String password,
    @NotBlank String role,
    @NotBlank String address,
    @NotBlank String companyName
) {
}
