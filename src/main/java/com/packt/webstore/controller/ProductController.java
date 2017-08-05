package com.packt.webstore.controller;

import java.math.BigDecimal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ProductController {
	@RequestMapping("/products")
	public String list(Model model) {
		model.addAttribute("products", productRepository.getAllProducts());
		return "products";
	}
	@Autowired
	private ProductService productRepository;
	
}
