package com.oscar.ecomerce.backend.domain.port;

import com.oscar.ecomerce.backend.domain.model.Product;

public interface IProductRepository {
    Iterable<Product> findAll();
    Product save(Product product);
    Product findById(Integer id);
    Product update(Product product, Integer id);
    void delete(Integer id);
}
