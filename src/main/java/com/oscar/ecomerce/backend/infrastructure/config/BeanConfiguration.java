package com.oscar.ecomerce.backend.infrastructure.config;


import com.oscar.ecomerce.backend.application.CategoryService;
import com.oscar.ecomerce.backend.application.UserService;
import com.oscar.ecomerce.backend.domain.port.ICategoryRepository;
import com.oscar.ecomerce.backend.domain.port.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public UserService userService(IUserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    public CategoryService categoryService(ICategoryRepository categoryRepository) {
        return new CategoryService(categoryRepository);
    }
}
