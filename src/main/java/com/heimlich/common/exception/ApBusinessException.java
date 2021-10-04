package com.heimlich.common.exception;

/**
 * 業務錯誤訊息
 */
public class ApBusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ApBusinessException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	public ApBusinessException(final String message) {
		super(message);
	}

}
