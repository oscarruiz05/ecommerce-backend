package com.oscar.ecomerce.backend.infrastructure.dto;

import com.oscar.ecomerce.backend.domain.model.User;

public record JWTClient(Integer id, String username, String name, String token) {
}
