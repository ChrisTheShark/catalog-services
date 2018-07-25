package com.chrisdyertech.catalog.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;

import org.apache.commons.io.IOUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import com.chrisdyertech.catalog.domain.Product;
import com.chrisdyertech.catalog.service.ProductsService;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

/**
 * Simple Pact verification test for {@link ProductsService}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
		"products.service.host: localhost",
		"products.service.port: 8888"
})
public class ProductsPactVerificationTest {
	
	private static final String PROVIDER_FILE_NAME = "provider/productProvider_product_by_id.json";

	@Rule
	public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("productsServiceProvider", "localhost", 8888, this);

	@Autowired
	private ProductsService productsService;

	@Pact(consumer = "catalog-services")
	public RequestResponsePact createProductByIdPact(PactDslWithProvider builder) throws Exception {
		ClassLoader classLoader = getClass().getClassLoader();
		String json = IOUtils.toString(
				new FileReader(
						new File(classLoader.getResource(PROVIDER_FILE_NAME).getFile())));
		
		return builder.given("an existing product")
					  .uponReceiving("a request to the product service")
					  .path("/products/2")
					  .method("GET")
					  .willRespondWith()
					  .status(HttpStatus.OK.value())
					  .body(json, MediaType.APPLICATION_JSON_VALUE)
					  .toPact();
	}

	@Test
	@PactVerification
	public void verifyProductByIdPact() throws Exception {
		Product product = productsService.getByProductId(2);
		assertEquals(2, product.getProductId());
	}
}
