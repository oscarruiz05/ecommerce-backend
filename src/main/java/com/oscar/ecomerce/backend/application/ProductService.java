package com.oscar.ecomerce.backend.application;

import com.oscar.ecomerce.backend.domain.model.Product;
import com.oscar.ecomerce.backend.domain.port.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private final IProductRepository productRepository;

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    public Product update(Product product, Integer id) {
        return productRepository.update(product, id);
    }

    public void delete(Integer id) {
        productRepository.delete(id);
    }
}
