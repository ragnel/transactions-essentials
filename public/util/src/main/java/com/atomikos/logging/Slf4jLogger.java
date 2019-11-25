/**
 * Copyright (C) 2000-2017 Atomikos <info@atomikos.com>
 *
 * LICENSE CONDITIONS
 *
 * See http://www.atomikos.com/Main/WhichLicenseApplies for details.
 */

package com.atomikos.logging;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

class Slf4jLogger implements Logger {

	private final org.slf4j.Logger slf4j;
	private final Marker FATAL = MarkerFactory.getMarker("FATAL");
	
	public Slf4jLogger(Class<?> clazz) {
		slf4j = org.slf4j.LoggerFactory.getLogger(clazz);
	}

	public void logWarning(String message) {
		if (isWarningEnabled()) {
			slf4j.warn(message);
		}
	}

	public void logInfo(String message) {
		if (isInfoEnabled()) {
			slf4j.info(message);
		}
	}

	public void logDebug(String message) {
		if (isDebugEnabled()) {
			slf4j.debug(message);
		}
	}

	public void logTrace(String message) {
		if (isTraceEnabled()) {
			slf4j.trace(message);
		}
	}

	public void logWarning(String message, Throwable error) {
		if (isWarningEnabled()) {
			slf4j.warn(message, error);
		}
	}

	public void logDebug(String message, Throwable error) {
		if (isDebugEnabled()) {
			slf4j.debug(message, error);
		}
	}

	public void logTrace(String message, Throwable error) {
		if (isTraceEnabled()) {
			slf4j.trace(message, error);
		}
	}

	public boolean isTraceEnabled() {
		return slf4j.isTraceEnabled();
	}

	public boolean isDebugEnabled() {
		return slf4j.isDebugEnabled();
	}

	public void logError(String message) {
		if (isErrorEnabled()) {
			slf4j.error(message);
		}
	}

	public void logError(String message, Throwable error) {
		if (isErrorEnabled()) {
			slf4j.error(message, error);
		}
	}

	public boolean isErrorEnabled() {
		return slf4j.isErrorEnabled();
	}

	@Override
	public void logInfo(String message, Throwable error) {
		if (isInfoEnabled()) {
			slf4j.info(message, error);
		}
	}

	@Override
	public boolean isInfoEnabled() {
		return slf4j.isInfoEnabled();
	}
	
	@Override
	public boolean isWarningEnabled() {
		return slf4j.isWarnEnabled();
	}
	
	@Override
	public void logFatal(String message) {
		slf4j.error(FATAL, message);
	}

	@Override
	public void logFatal(String message, Throwable error) {		
		slf4j.error(FATAL, message, error);
	}
	
}
