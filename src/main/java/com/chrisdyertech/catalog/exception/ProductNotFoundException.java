package com.chrisdyertech.catalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.chrisdyertech.catalog.domain.Product;

/**
 * Simple {@link RuntimeException} extension class for {@link Product}s
 * that cannot be located.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ProductNotFoundException(String message) {
		super(message);
	}

}
