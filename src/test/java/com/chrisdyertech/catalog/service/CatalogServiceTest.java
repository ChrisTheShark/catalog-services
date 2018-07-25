package com.chrisdyertech.catalog.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.chrisdyertech.catalog.domain.Product;
import com.chrisdyertech.catalog.domain.Review;
import com.chrisdyertech.catalog.service.CatalogService;
import com.chrisdyertech.catalog.service.CatalogServiceImpl;
import com.chrisdyertech.catalog.service.ProductsService;
import com.chrisdyertech.catalog.service.ReviewsService;

/**
 * Testing for {@link CatalogService}.
 */
@RunWith(MockitoJUnitRunner.class)
public class CatalogServiceTest {
	
	@InjectMocks
	private CatalogService service = new CatalogServiceImpl();
	
	@Mock
	private ReviewsService reviewsService;
	
	@Mock
	private ProductsService productsService;

	@Test
	public void testGetItemByProductId() throws Exception {
		when(reviewsService.getByProductId(Mockito.anyInt()))
			.thenReturn(Arrays.asList(new Review()));
		when(productsService.getByProductId(Mockito.anyInt()))
			.thenReturn(new Product());
		
		Product product = service.getByProductId(1);
				
		assertNotNull(product);
		assertEquals(1, product.getReviews().size());
	}

}
