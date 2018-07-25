package com.chrisdyertech.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chrisdyertech.catalog.domain.Product;
import com.chrisdyertech.catalog.exception.ProductNotFoundException;
import com.chrisdyertech.catalog.service.CatalogService;

/**
 * Main controller <code>class</code> for retrieving catalog items.
 */
@RestController
@RequestMapping(path = "/catalog")
public class CatalogController {
	
	@Autowired
	private CatalogService catalogService;
	
	@GetMapping("/item/{productId}")
	public Product getByProductId(@PathVariable int productId) {
		Product product = catalogService.getByProductId(productId);
		if (product != null) {
			return product;
		}
		throw new ProductNotFoundException(
				"Unable to locate product with id: " + productId);
	}

}
