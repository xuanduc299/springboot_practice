package com.Springboot.practice.Springboot.practice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Springboot.practice.Springboot.practice.Models.Category;
import com.Springboot.practice.Springboot.practice.Models.Product;
import com.Springboot.practice.Springboot.practice.repositories.CategoryRepository;
import com.Springboot.practice.Springboot.practice.repositories.ProductRepository;

@Controller
@RequestMapping (path = "products")
//http:localhost:8081/products
public class ProductController {
	@Autowired
	ProductRepository productRespository;
	@Autowired
	private CategoryRepository categoryRepository;
	//http:localhost:8081/products/getProductByCategoryID/C0103
	@RequestMapping (value = "/getProductByCategoryID/{categoryID}", method = RequestMethod.GET)
	
	public String getProductByCategoryID (ModelMap modelMap,@PathVariable String categoryID) {
	    Iterable<Product>products = productRespository.findByCategoryID(categoryID);
	    modelMap.addAttribute("products",products);
		return "productList"; 	
	}
	@RequestMapping (value = "/changeCategory/{productID}", method = RequestMethod.GET)
	///products/changeCategory/${category.getCategoryID()}
	public String changeCategory (ModelMap modelMap,@PathVariable String productID) {
		Iterable<Category> categories = categoryRepository.findAll();
		modelMap.addAttribute("categories" , categories);
		modelMap.addAttribute("product", productRespository.findById(productID).get());
		return "assign"; 	
	}
	@RequestMapping(value = "/updateProduct/{productID}", method = RequestMethod.POST)
	public String updateProduct (ModelMap modelMap,
            @ModelAttribute("product") Product product,
            @PathVariable String productID) {
		if(productRespository.findById(productID).isPresent()) {
			Product foundProduct = productRespository.findById(product.getProductID()).get();
			if(product.getProductID() != null) {
				foundProduct.setProductName(product.getProductName());
			}
			if(product.getCategoryID() != null) {
				foundProduct.setCategoryID(product.getCategoryID());
			}
			if(product.getDescription() != null) {
				foundProduct.setDescription(product.getDescription());
			}
			if(product.getPrice() > 0) {
				foundProduct.setPrice(product.getPrice());
			}
			productRespository.save(foundProduct);
		}
		 return "redirect:/products/getProductsByCategoryID/"+product.getCategoryID();
	}
}
