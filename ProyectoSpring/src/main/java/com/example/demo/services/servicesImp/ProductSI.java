package com.example.demo.services.servicesImp;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.repository.dao.IProductDao;
import com.example.demo.repository.dtos.ProductDto;
import com.example.demo.repository.entities.Product;
import com.example.demo.services.*;
@Service
public class ProductSI implements IProductS {
	
	   @Autowired
	    private IProductDao iProductDao;

	    @Override
	    public ResponseEntity<Product> getProduct(Long idProduct) {
	    	 Optional<ProductDto> listap = iProductDao.findAll().stream()
	      		   .filter(p->p.getIdProduct().equals(idProduct))	
	      		   .map(p->{ProductDto producto = new ProductDto();
	      		 producto.setIdProduct(p.getIdProduct());
                 producto.setName(p.getName());
                 producto.setPrice(p.getPrice());
	      		   return producto;
	      		   }).findFirst();
	  	return new ResponseEntity<Product>(HttpStatus.OK);
	    }

	    @Override
	    public ResponseEntity<Product> addProduct(Product product) {
	    	Product addProduct = iProductDao.save(product);
	    	return new ResponseEntity<Product>(addProduct,HttpStatus.OK);
	    }

	    @Override
	    public ResponseEntity<Product> setProduct(Product product, Long idProduct) {
	    	Product prod = this.iProductDao.getOne(idProduct);
			prod.setIdProduct(idProduct);
			prod.setName(product.getName());
			prod.setPrice(product.getPrice());
	    	return new ResponseEntity<>(this.iProductDao.save(prod), HttpStatus.OK);
	    }

	    @Override
	    public ResponseEntity<Long> removeProduct(Long idProduct) {
	    	this.iProductDao.deleteById(idProduct);
			return new ResponseEntity<Long>(1L, HttpStatus.OK);
	    }
		@Override
	    public ResponseEntity<Product> save(Product product) {
			Product addProducto2 = iProductDao.save(product);
			return new ResponseEntity<Product>(addProducto2,HttpStatus.OK);
		}

		@Override
		public List<Product> findAll() {
			return iProductDao.findAll();
		}
}
