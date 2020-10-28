package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.repository.dtos.ProductDto;
import com.example.demo.repository.entities.Product;
import com.example.demo.services.IProductS;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

	 @Autowired
	    private IProductS productS;

	    @GetMapping("/products")
	    public List<Product> getProduct(){
	        return productS.findAll();
	    }

	    @GetMapping("/products/{idProduct}")
	    public ResponseEntity<Product> getProduct(@PathVariable Long idProduct){
	        return productS.getProduct(idProduct);
	    }

	    @PostMapping(value = "/add", consumes = {"application/json"})
	    public ResponseEntity<Product> addProduct(@RequestBody Product producto){
	        return productS.save(producto);
	       // URI productS = ServletUriComponentBuilder.fromCurrentContectPath().path("/{idProducto}");
	    }

	    @PutMapping(value = "edit/{idProducto}", consumes = {"application/json"})
	    public ResponseEntity<Product> setProducto(@RequestBody Product producto, @PathVariable Long idProducto){
	        return productS.setProduct(producto, idProducto);
	    }

	    @DeleteMapping(value = "remove", consumes = {"application/json"})
	    public ResponseEntity<Long> removeProduct(@RequestParam Long idProducto){
	        return productS.removeProduct(idProducto);
	    }
}
