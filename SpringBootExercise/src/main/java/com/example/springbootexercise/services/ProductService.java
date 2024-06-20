package com.example.springbootexercise.services;

import com.example.springbootexercise.models.Product;
import com.example.springbootexercise.repository.ProuductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    private ProuductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(int id, Product newProductData) {
        return productRepository.findById(id).map(product -> {
            product.setName(newProductData.getName());
            product.setPricePerUnit(newProductData.getPricePerUnit());
            product.setActiveForSell(newProductData.isActiveForSell());
            return productRepository.save(product);
        }).orElseGet(() -> {
            newProductData.setId(id);
            return productRepository.save(newProductData);
        });
    }
}
