package com.chrisdyertech.catalog.service;

import com.chrisdyertech.catalog.domain.Product;

/**
 * <code>interface</code> defines operations required of implementations
 * providing access to {@link Product}s.
 */
public interface CatalogService {
	
	public Product getByProductId(int productId);

}
