package com.cognizant.ms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5441656488294165580L;

	public UserNotFound(String exceptionMessage) {
        super(exceptionMessage);
	}
}
