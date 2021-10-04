package com.heimlich.common.exception;

import com.tradevan.commons.logging.Logger;

public class ExceptionHander {
	
	public static void handError(Logger logger, Object message, Throwable throwable) {
		logger.error(message, throwable);
	}

	public static void handError(Logger logger, Throwable throwable) {
		logger.error(throwable);
	}

	public static void handError(Logger logger, String message) {
		logger.error(message);
	}

}
