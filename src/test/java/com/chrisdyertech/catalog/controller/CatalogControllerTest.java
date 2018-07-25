package com.chrisdyertech.catalog.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.chrisdyertech.catalog.controller.CatalogController;
import com.chrisdyertech.catalog.domain.Product;
import com.chrisdyertech.catalog.service.CatalogService;

/**
 * Testing for {@link CatalogController}.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CatalogController.class)
public class CatalogControllerTest {
	
	@Autowired
	@InjectMocks
	private CatalogController catalogController;
	
	@MockBean
	private CatalogService mockCatalogService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetByProductId() throws Exception {
		when(mockCatalogService.getByProductId(Mockito.anyInt()))
			.thenReturn(new Product());
		
		mockMvc.perform(get("/catalog/item/1"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	public void testGetByProductIdNotFound() throws Exception {
		when(mockCatalogService.getByProductId(Mockito.anyInt()))
			.thenReturn(null);
		
		mockMvc.perform(get("/catalog/item/1"))
		.andExpect(status().isNotFound())
		.andDo(print());
	}

}
