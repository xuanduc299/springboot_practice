package com.Springboot.practice.Springboot.practice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Springboot.practice.Springboot.practice.Models.Category;
import com.Springboot.practice.Springboot.practice.repositories.CategoryRepository;

@Controller
@RequestMapping (path = "categories")
//http:localhost:8080/categories
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;
	//return name of "jsp file"
	//http:localhost:8081/categories
	@RequestMapping (value = "", method = RequestMethod.GET)
	public String getAllCategories (ModelMap modelMap) {
	    //data sent to jsp => ModelMap
//		modelMap.addAttribute("name" , "Hoang");
//		modelMap.addAttribute("age", 18);
		Iterable<Category> categories = categoryRepository.findAll();
		modelMap.addAttribute("categories" , categories);
	    System.out.println("haha");
	    return "category";
	}
}
