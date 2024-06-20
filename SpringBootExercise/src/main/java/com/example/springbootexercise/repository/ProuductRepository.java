package com.example.springbootexercise.repository;

import com.example.springbootexercise.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProuductRepository extends JpaRepository<Product, Integer> {
}
