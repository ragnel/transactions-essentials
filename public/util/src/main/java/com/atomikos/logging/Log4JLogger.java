/**
 * Copyright (C) 2000-2017 Atomikos <info@atomikos.com>
 *
 * LICENSE CONDITIONS
 *
 * See http://www.atomikos.com/Main/WhichLicenseApplies for details.
 */

package com.atomikos.logging;

import org.apache.log4j.Level;

class Log4JLogger implements Logger {

	private final org.apache.log4j.Logger log4jLogger;

	public Log4JLogger(Class<?> clazz) {
		log4jLogger = org.apache.log4j.Logger.getLogger(clazz);
	}

	public void logWarning(String message) {
		if (isWarningEnabled()) {
			log4jLogger.warn(message);
		}
	}

	@Override
	public void logInfo(String message) {
		if (isInfoEnabled()) {
			log4jLogger.info(message);
		}
	}

	public void logDebug(String message) {
		if (isDebugEnabled()) {
			log4jLogger.debug(message);
		}
	}

	public void logTrace(String message) {
		if (isTraceEnabled()) {
			log4jLogger.trace(message);
		}
	}

	public void logWarning(String message, Throwable error) {
		if (isWarningEnabled()) {
			log4jLogger.warn(message, error);
		}
	}

	public void logDebug(String message, Throwable error) {
		if (isDebugEnabled()) {
			log4jLogger.debug(message, error);
		}
	}

	public void logTrace(String message, Throwable error) {
		if (isTraceEnabled()) {
			log4jLogger.trace(message, error);
		}
	}

	public boolean isTraceEnabled() {
		return log4jLogger.isTraceEnabled();
	}

	public boolean isDebugEnabled() {
		return log4jLogger.isDebugEnabled();
	}

	public void logError(String message) {
		log4jLogger.error(message);
	}

	public void logError(String message, Throwable error) {
		if (isErrorEnabled()) {
			log4jLogger.error(message, error);
		}
	}

	public boolean isErrorEnabled() {
		return log4jLogger.isEnabledFor(Level.ERROR);
	}

	@Override
	public void logInfo(String message, Throwable error) {
		if (isInfoEnabled()) {
			log4jLogger.info(message, error);
		}
	}

	@Override
	public boolean isInfoEnabled() {
		return log4jLogger.isInfoEnabled();
	}
	
	@Override
	public boolean isWarningEnabled() {
		return log4jLogger.isEnabledFor(Level.WARN);
	}
	
	@Override
	public void logFatal(String message) {
		log4jLogger.fatal(message);
	}

	@Override
	public void logFatal(String message, Throwable error) {
		log4jLogger.fatal(message, error);
	}

}
