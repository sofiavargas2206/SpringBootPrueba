package com.example.demo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.repository.entities.Product;


public interface IProductS {
	    public List<Product> findAll();
	    ResponseEntity<Product> getProduct(Long idProduct);
	    ResponseEntity<Product> addProduct(Product product);
	    ResponseEntity<Product> setProduct(Product product, Long idProduct);
	   
	    ResponseEntity<Long> removeProduct(Long idProduct);
		ResponseEntity<Product> save(Product product);
		
}
