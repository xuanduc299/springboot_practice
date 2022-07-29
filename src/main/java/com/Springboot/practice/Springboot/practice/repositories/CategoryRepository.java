package com.Springboot.practice.Springboot.practice.repositories;

import org.springframework.data.repository.CrudRepository;
import com.Springboot.practice.Springboot.practice.Models.Category;

public interface CategoryRepository  extends CrudRepository<Category, String> {
	
}
