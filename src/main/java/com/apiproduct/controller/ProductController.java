package com.apiproduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiproduct.model.Product;
import com.apiproduct.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping
	public ResponseEntity<Product> create(@RequestBody Product product) {
		product = service.create(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Product> findById(@PathVariable Integer id){
		Product product  = service.findById(id);
		return ResponseEntity.ok().body(product);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Product> delete(@PathVariable Integer id) {
		Product product = service.delete(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(product);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Integer id) {
		product.setId(id);
		product = service.update(product);
		
		return ResponseEntity.ok(product);
	}
	
}
