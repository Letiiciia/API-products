package com.apiproduct.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apiproduct.model.Product;
import com.apiproduct.repository.ProductRepository;


@Service
public class ProductService {
	//1.Get all rpoducts (list)
	//2.Get by Id 
	//3.Create
	//4.Update
	//5.Delete
	
	@Autowired
	private ProductRepository repository;
	
	public Product create(Product product) {
		return repository.save(product);
	}
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Integer id) {
		Optional<Product> product = repository.findById(id);
		return  product.orElseThrow(() ->
		new RuntimeException("Object Not Found"));
	}
		
	public Product delete(Integer id) {
		Product product = findById(id);
		repository.deleteById(product.getId());
		
		return product;
	}
	
	public Product update(Product product) {
		product.setId(product.getId());
		product =repository.save(product);
		
		return repository.save(product);
	}
	
//	private void updateData(Product newProduct, Product product) {
//		newProduct.setName(product.getName());
//		newProduct.setPrice(product.getPrice());
//		newProduct.setDescription(product.getDescription());
//
//	}
}
