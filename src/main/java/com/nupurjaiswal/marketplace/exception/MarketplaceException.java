package com.nupurjaiswal.marketplace.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MarketplaceException extends RuntimeException {

	public MarketplaceException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
