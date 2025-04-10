package com.oscar.ecomerce.backend.infrastructure.rest;

import com.oscar.ecomerce.backend.application.ProductService;
import com.oscar.ecomerce.backend.domain.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/home")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomeController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }
}
