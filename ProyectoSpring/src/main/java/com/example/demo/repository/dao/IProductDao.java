package com.example.demo.repository.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entities.Product;

@Repository
public interface IProductDao extends JpaRepository<Product, Long> {
}
