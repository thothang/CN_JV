package com.example.lab9.service;

import com.example.lab9.model.Product;
import com.example.lab9.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product replaceProduct(Long id, Product newProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setCode(newProduct.getCode());
                    product.setName(newProduct.getName());
                    product.setPrice(newProduct.getPrice());
                    product.setIllustration(newProduct.getIllustration());
                    product.setDescription(newProduct.getDescription());
                    return productRepository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return productRepository.save(newProduct);
                });
    }

    public Product updateProduct(Long id, Product partialProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    if (partialProduct.getCode() != null) product.setCode(partialProduct.getCode());
                    if (partialProduct.getName() != null) product.setName(partialProduct.getName());
                    if (partialProduct.getPrice() != null) product.setPrice(partialProduct.getPrice());
                    if (partialProduct.getIllustration() != null) product.setIllustration(partialProduct.getIllustration());
                    if (partialProduct.getDescription() != null) product.setDescription(partialProduct.getDescription());
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
