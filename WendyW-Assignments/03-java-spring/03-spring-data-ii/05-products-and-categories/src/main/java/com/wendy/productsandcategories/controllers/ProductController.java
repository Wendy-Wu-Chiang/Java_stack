package com.wendy.productsandcategories.controllers;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Product> products = productService.getAllProducts();
		List<Category> categories = categoryService.getAllCategories();
		model.addAttribute("products", products);
		model.addAttribute("categories", categories);
		return "index.jsp";
	}
	
	@GetMapping("/new/product")
	public String getProduct(@ModelAttribute("products") Product product) {
		return "products.jsp";
	}
	
	@PostMapping("add/product")
	public String addProduct(@Valid @ModelAttribute("products") Product product, BindingResult result) {
		
		if(result.hasErrors()) {
			return "products.jsp";
			
		}else {
			
			this.productService.createProduct(product);
			return "redirect:/";
			
		}
	}
	
	@RequestMapping("/show/product/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product thisProduct = productService.getProduct(id);
		model.addAttribute("product", thisProduct);
		List<Category> categoryNotInProduct = categoryService.findCategoriesNotInProduct(thisProduct);
		model.addAttribute("categoryNotInProduct", categoryNotInProduct);
		return "showProducts.jsp";
	}
	
	@PostMapping("/product/{id}")
	public String addCateToProduct(@RequestParam("category") Long cateId, @PathVariable("id") Long prodId) {
		Product thisProduct = productService.getProduct(prodId);
		Category thisCategory = categoryService.getCategory(cateId);
		productService.addCategoryToProduct(thisProduct, thisCategory);
		return "redirect:/show/product/" + prodId;
	}
	
	@GetMapping("/new/category")
	public String getCategory(@ModelAttribute("categories") Category category) {
		return "categories.jsp";
	}
	
	@PostMapping("/add/category")
	public String addCategory(@Valid @ModelAttribute("categories") Category category, BindingResult result) {
		
		if(result.hasErrors()) {
			return "categories.jsp";
		}else {
			this.categoryService.createCategory(category);
			return "redirect:/";
		}
		
	}
	
	@RequestMapping("/show/category/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category thisCate = categoryService.getCategory(id);
		model.addAttribute("category", thisCate);
		List<Product> productNotInCategory = productService.findProductsNotInCategory(thisCate);
		model.addAttribute("productNotInCategory", productNotInCategory);
		
		return "showCategories.jsp";
	}
	
	@PostMapping("/category/{id}")
	public String addProductToCategory(@RequestParam("product") Long cateId, @PathVariable("id") Long prodId) {
		Category thisCategory = categoryService.getCategory(cateId);
		Product selectedProduct = productService.getProduct(prodId);
		categoryService.addProductToCategory(selectedProduct, thisCategory);
		
		return "redirect:/show/category/" + cateId;
	}
}
