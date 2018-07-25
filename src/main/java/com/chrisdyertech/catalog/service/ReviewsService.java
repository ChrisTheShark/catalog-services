package com.chrisdyertech.catalog.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chrisdyertech.catalog.domain.Review;

/**
 * Simple <code>interface</code> responsible for defining operations
 * required of services providing access to reviews.
 */
@FeignClient(name = "reviews", url = "${reviews.service.host}:${reviews.service.port}")
public interface ReviewsService {

	@RequestMapping(method = RequestMethod.GET, value = "/reviews/product/{productId}")
	List<Review> getByProductId(@PathVariable("productId") int productId);
	
}
