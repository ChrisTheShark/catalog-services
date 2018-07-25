package com.chrisdyertech.catalog.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chrisdyertech.catalog.domain.Product;

/**
 * Simple <code>interface</code> responsible for defining operations
 * required of services providing access to products.
 */
@FeignClient(name = "products", url = "${products.service.host}:${products.service.port}" )
public interface ProductsService {
	
	@RequestMapping(method = RequestMethod.GET, value = "/products/{productId}")
	Product getByProductId(@PathVariable("productId") int productId);

}
