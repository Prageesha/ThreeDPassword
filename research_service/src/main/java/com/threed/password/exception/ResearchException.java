package com.threed.password.exception;

import javax.ws.rs.core.Response.Status;

public class ResearchException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Status httpStatus;

	public ResearchException(String message) {
		super(message);
	}

	public ResearchException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResearchException(String message, Status httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public Status getHttpStatus() {
		return httpStatus;
	}
}
