package com.packt.webstore.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ProductController {

	@RequestMapping
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/all")
	public String allProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/products/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
		model.addAttribute("products", productService.getProductsByCategory(productCategory));
		return "products";
	}

	@RequestMapping("/products/filter/{ByCriteria}")
	public String getProductsByFilter(Model model,
			@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams) {
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		return "products";
	}

	@RequestMapping("/products/filter/byPrize/{prize}")
	public String getProductsByPrize(Model model,
			@MatrixVariable(pathVar = "prize") Map<String, List<String>> filterParams) {
		model.addAttribute("products", productService.getProductsByPrize(filterParams));
		return "products";
	}

	@RequestMapping("/products/{category}/{prize}")
	public String getProductsByCategoryAndPrizeAndManufacturer(Model model,
			@PathVariable("category") String productCategory,
			@MatrixVariable(pathVar = "prize") Map<String, List<String>> filterParams,
			@RequestParam("manufacturer") String productManufacturer) {
		model.addAttribute("products", productService.getProductsByManPrize(filterParams, productCategory, productManufacturer));

		
		return "products";
	}

	@RequestMapping("/products/product")
	public String getProductById(Model model, @RequestParam("id") String productId) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}

	@RequestMapping("/products/product-by-man")
	public String getProductsByManufacturer(Model model, @RequestParam("manufacturer") String productManufacturer) {
		model.addAttribute("products", productService.getProductsByManufacturer(productManufacturer));
		return "products";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
	Product newProduct = new Product();
	model.addAttribute("newProduct", newProduct);
	return "addProduct";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
	productService.addProduct(newProduct);
	return "redirect:/products";
	}
	
	@Autowired
	private ProductService productService;

}
