package com.apiproduct.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apiproduct.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

}
