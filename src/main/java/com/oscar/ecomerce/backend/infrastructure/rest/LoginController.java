package com.oscar.ecomerce.backend.infrastructure.rest;

import com.oscar.ecomerce.backend.application.UserService;
import com.oscar.ecomerce.backend.domain.model.User;
import com.oscar.ecomerce.backend.infrastructure.dto.JWTClient;
import com.oscar.ecomerce.backend.infrastructure.dto.UserDto;
import com.oscar.ecomerce.backend.infrastructure.jwt.JWTGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/security")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private final JWTGenerator jwtGenerator;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<JWTClient> login(@RequestBody UserDto userDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.username(), userDto.password())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.getToken(userDto.username());
        User user = userService.findByEmail(userDto.username());

        JWTClient jwtClient = new JWTClient(user.getId(), user.getEmail(), user.getName(), token);

        return new ResponseEntity<>(jwtClient, HttpStatus.OK);
    }
}
