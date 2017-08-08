package com.packt.webstore.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.webstore.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
	List<Product> getProductsByCategory(String category);
	Product getProductById(String ProductID);
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
}
