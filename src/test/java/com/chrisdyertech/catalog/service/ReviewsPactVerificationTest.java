package com.chrisdyertech.catalog.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import com.chrisdyertech.catalog.domain.Review;
import com.chrisdyertech.catalog.service.ReviewsService;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

/**
 * Simple Pact verification test for {@link ReviewsService}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
		"reviews.service.host: localhost",
		"reviews.service.port: 8888"
})
public class ReviewsPactVerificationTest {
	
	private static final String PROVIDER_FILE_NAME = "provider/reviewProvider_reviews_by_product.json";

	@Rule
	public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("reviewsServiceProvider", "localhost", 8888, this);

	@Autowired
	private ReviewsService reviewsService;

	@Pact(consumer = "catalog-services")
	public RequestResponsePact createReviewsByProductPact(PactDslWithProvider builder) throws Exception {
		ClassLoader classLoader = getClass().getClassLoader();
		String json = IOUtils.toString(
				new FileReader(
						new File(classLoader.getResource(PROVIDER_FILE_NAME).getFile())));
		
		return builder.given("a product with created reviews")
					  .uponReceiving("a request to the reviews service")
					  .path("/reviews/product/2")
					  .method("GET")
					  .willRespondWith()
					  .status(HttpStatus.OK.value())
					  .body(json, MediaType.APPLICATION_JSON_VALUE)
					  .toPact();
	}

	@Test
	@PactVerification
	public void verifyReviewsByProductIdPact() throws Exception {
		List<Review> reviews = reviewsService.getByProductId(2);
		assertEquals(2, reviews.size());
	}

}
