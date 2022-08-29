package com.wendy.productsandcategories.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wendy.productsandcategories.models.Category;
import com.wendy.productsandcategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	List<Category> findByProductsNotContains(Product product);
	
}