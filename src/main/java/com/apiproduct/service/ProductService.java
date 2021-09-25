package com.apiproduct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiproduct.model.Product;
import com.apiproduct.repository.ProductRepository;

@Service
public class ProductService {
	//1.Buscar todos (lista)
	//2.Buscar por Id 
	//3.Salvar
	//4.Update
	//5.Delete
	
	@Autowired
	private ProductRepository repository;
	
	public Product save(Product product) {
		return repository.save(product);
	}
}
