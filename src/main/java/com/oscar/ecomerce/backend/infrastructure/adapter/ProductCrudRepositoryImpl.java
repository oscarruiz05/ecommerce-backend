package com.oscar.ecomerce.backend.infrastructure.adapter;

import com.oscar.ecomerce.backend.domain.model.Product;
import com.oscar.ecomerce.backend.domain.port.IProductRepository;
import com.oscar.ecomerce.backend.infrastructure.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ProductCrudRepositoryImpl implements IProductRepository {
    private final IProductCrudRepository productCrudRepository;
    private final ProductMapper productMapper;

    @Override
    public Iterable<Product> findAll() {
        return productMapper.toProducts(productCrudRepository.findAll());
    }

    @Override
    public Product save(Product product) {
        return productMapper.toProduct(productCrudRepository.save(productMapper.toProductEntity(product)));
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.toProduct(productCrudRepository.findById(id).orElse(null));
    }

    @Override
    public Product update(Product product, Integer id) {
        return productCrudRepository.findById(id)
                .map(productEntity -> {
                    productEntity.setCode(product.getCode());
                    productEntity.setName(product.getName());
                    productEntity.setDescription(product.getDescription());
                    productEntity.setPrice(product.getPrice());
                    productEntity.setStock(product.getStock());
                    productEntity.setImage(product.getImage());
                    return productMapper.toProduct(productCrudRepository.save(productEntity));
                })
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public void delete(Integer id) {
        productCrudRepository.deleteById(id);
    }
}
