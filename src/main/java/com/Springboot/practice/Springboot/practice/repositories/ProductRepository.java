package com.Springboot.practice.Springboot.practice.repositories;

import org.springframework.data.repository.CrudRepository;

import com.Springboot.practice.Springboot.practice.Models.Product;

public interface ProductRepository extends CrudRepository<Product, String> {
	Iterable<Product>findByCategoryID(String categoryID);
}
