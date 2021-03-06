package com.heimlich.common.exception;

/** 
 * 共用錯誤訊息
 */
public class TxBusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public TxBusinessException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	public TxBusinessException(final String message) {
		super(message);
	}

}
