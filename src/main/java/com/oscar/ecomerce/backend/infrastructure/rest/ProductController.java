package com.oscar.ecomerce.backend.infrastructure.rest;

import com.oscar.ecomerce.backend.application.ProductService;
import com.oscar.ecomerce.backend.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/admin/products")
@Slf4j
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    public final ProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Product> save(
            @RequestParam("code") String code,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") Double price,
            @RequestParam("imageUrl") String imageUrl,
            @RequestParam("userId") Integer userId,
            @RequestParam("categoryId") Integer categoryId,
            @RequestParam(value = "image", required = false) MultipartFile  image
    ) throws IOException {
        Product product = new Product();
        product.setCode(code);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setImage(imageUrl);
        product.setUserId(userId);
        product.setCategoryId(categoryId);
        return new ResponseEntity<>(productService.save(product, image), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
            @RequestParam("code") String code,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") Double price,
            @RequestParam("imageUrl") String imageUrl,
            @RequestParam("userId") Integer userId,
            @RequestParam("categoryId") Integer categoryId,
            @RequestParam(value = "image", required = false) MultipartFile  image,
            @PathVariable Integer id
    ) throws IOException {
        Product product = new Product();
        product.setCode(code);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setImage(imageUrl);
        product.setUserId(userId);
        product.setCategoryId(categoryId);
        return ResponseEntity.ok(productService.update(product, image, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) throws IOException {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
