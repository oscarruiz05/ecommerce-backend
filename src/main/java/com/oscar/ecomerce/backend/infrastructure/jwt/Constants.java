package com.oscar.ecomerce.backend.infrastructure.jwt;

import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;

public class Constants {
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer";
    public static final String SUPER_SECRET_KEY = "6d21371cd8c4d3cd7e96f89069267e3fee4365e41462a652dc77172408123c3be3f08e17a5158fec16ba5d6db5595be054f6f9f8b8a683ac84e5a18b3658550de423b87219e37da04705a17d2d68030ce264c25ad7d92ba0eec7bab8c2d50fc95a8d71689b7bf316c595cd860758276de8ae787f19bfac8959a6ea293b8faf9394aed694ed75d70fac87cab54839861b10bf8f988ea5ead97b358ce934f83c7f5d756f62a8c852eb02582ed4b7666a62b81d58b15edbb0dc4bff57fcfdc3052b6ce9e7bff4b68534aa682a8a87ce3d6738a5383cb5271a275a269b9346170721013d180724213cd55966b4d9fac60527e40a9b81a08259cbdbb0c22f5ab6e8ee";
    public static final long TOKEN_EXPIRATION_TIME = 1500000; // 15 minutes

    public static Key getSignedKey(String secretKey) {
        byte [] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
