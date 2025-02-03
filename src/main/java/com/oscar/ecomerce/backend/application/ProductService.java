package com.oscar.ecomerce.backend.application;

import com.oscar.ecomerce.backend.domain.model.Product;
import com.oscar.ecomerce.backend.domain.port.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
public class ProductService {
    private final IProductRepository productRepository;
    private final UploadFile uploadFile;

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product, MultipartFile multipartFile) throws IOException {
        product.setImage(uploadFile.upload(multipartFile));
        return productRepository.save(product);
    }

    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    public Product update(Product product, MultipartFile multipartFile, Integer id) throws IOException {
        if (multipartFile == null) {
            product.setImage(product.getImage());
        } else {
            String imageUrl = product.getImage().split("/")[product.getImage().split("/").length - 1];
            uploadFile.delete(imageUrl);
            product.setImage(uploadFile.upload(multipartFile));
        }
        return productRepository.update(product, id);
    }

    public void delete(Integer id) throws IOException {
        Product product = findById(id);
        String imageUrl = product.getImage().split("/")[product.getImage().split("/").length - 1];
        uploadFile.delete(imageUrl);
        productRepository.delete(id);
    }
}
