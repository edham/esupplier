package com.ebim.esupplier.web.dto;

public record TokenResponse(String accessToken, long expiresInSeconds) {}