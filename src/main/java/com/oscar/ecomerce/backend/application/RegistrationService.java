package com.oscar.ecomerce.backend.application;

import com.oscar.ecomerce.backend.domain.model.User;
import com.oscar.ecomerce.backend.domain.port.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final IUserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
