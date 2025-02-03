package com.oscar.ecomerce.backend.infrastructure.config;


import com.oscar.ecomerce.backend.application.*;
import com.oscar.ecomerce.backend.domain.port.ICategoryRepository;
import com.oscar.ecomerce.backend.domain.port.IOrderRepository;
import com.oscar.ecomerce.backend.domain.port.IProductRepository;
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

    @Bean
    public ProductService productService(IProductRepository productRepository, UploadFile uploadFile) {
        return new ProductService(productRepository, uploadFile);
    }

    @Bean
    public OrderService orderService(IOrderRepository orderRepository) {
        return new OrderService(orderRepository);
    }

    @Bean
    public UploadFile uploadFile() {
        return new UploadFile();
    }
}
