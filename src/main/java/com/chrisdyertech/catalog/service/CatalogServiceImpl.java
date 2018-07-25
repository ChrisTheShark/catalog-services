package com.chrisdyertech.catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisdyertech.catalog.domain.Product;

/**
 * {@link CatalogService} implementation retrieves {@link Item} details.
 */
@Service
public class CatalogServiceImpl implements CatalogService {
	
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private ReviewsService reviewsService;

	@Override
	public Product getByProductId(int productId) {
		Product product = productsService.getByProductId(productId);
		product.setReviews(reviewsService.getByProductId(productId));
		return product;
	}

}
