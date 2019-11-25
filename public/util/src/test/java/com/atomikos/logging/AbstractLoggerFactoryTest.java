/**
 * Copyright (C) 2000-2017 Atomikos <info@atomikos.com>
 *
 * LICENSE CONDITIONS
 *
 * See http://www.atomikos.com/Main/WhichLicenseApplies for details.
 */

package com.atomikos.logging;

import junit.framework.TestCase;

public abstract class AbstractLoggerFactoryTest extends TestCase {

	protected static final String MESSAGE = "warning";

	protected static final Throwable ERROR = new Exception();

	protected Logger logger;

	public void testLogTrace() {
		configureLoggingFrameworkWithTrace();
		logger.logTrace(MESSAGE);
		assertLoggedAsTrace();
	}

	protected abstract void configureLoggingFrameworkWithTrace() ;

	protected abstract void assertLoggedAsTrace();
	
	public void testLogDebug() {
		configureLoggingFrameworkWithDebug();
		logger.logDebug(MESSAGE);
		assertLoggedAsDebug();
	}

	protected abstract void assertLoggedAsDebug();

	public void testLogTraceWithException() {
		configureLoggingFrameworkWithTrace();
		logger.logTrace(MESSAGE,ERROR);
		assertLoggedAsTraceWithException();
	}
	
	protected abstract void assertLoggedAsTraceWithException() ;

	public void testLogDebugWithException() {
		configureLoggingFrameworkWithDebug();
		logger.logDebug(MESSAGE,ERROR);
		assertLoggedAsDebugWithException();
	}

	protected abstract void assertLoggedAsDebugWithException();

	public void testLoggerCreated() {
		assertNotNull(logger);
	}

	public void testLogInfo() {
		configureLoggingFrameworkWithInfo();
		logger.logInfo(MESSAGE);
		assertLoggedAsInfo();
	}

	protected abstract void assertLoggedAsInfo();

	public void testLogInfoWithException() {
		configureLoggingFrameworkWithInfo();
		logger.logInfo(MESSAGE,ERROR);
		assertLoggedAsInfoWithException();
	}

	protected abstract void assertLoggedAsInfoWithException();

	public void testLogWarning() {
		configureLoggingFrameworkWithWarning();
		logger.logWarning(MESSAGE);
		assertLoggedAsWarning();
	}

	protected abstract void assertLoggedAsWarning();

	public void testLogWarningWithException() {
		configureLoggingFrameworkWithWarning();
		logger.logWarning(MESSAGE,ERROR);
		assertLoggedAsWarningWithException();
	}

	protected abstract void assertLoggedAsWarningWithException();
	
  public void testLogError() {
  	configureLoggingFrameworkWithError();
    logger.logError(MESSAGE);
    assertLoggedAsError();
  }
  
  protected abstract void assertLoggedAsError();
  
  public void testLogErrorWithException() {
	  configureLoggingFrameworkWithError();
	  logger.logError(MESSAGE,ERROR);
	  assertLoggedAsErrorWithException();
  }
  
  protected abstract void assertLoggedAsErrorWithException();

  public void testIsTraceEnabled() {
	  	configureLoggingFrameworkWithNone();
		assertFalse(logger.isTraceEnabled());
		configureLoggingFrameworkWithTrace();
		assertTrue(logger.isTraceEnabled());
	}
	public void testIsDebugEnabled() {
		configureLoggingFrameworkWithNone();
		assertFalse(logger.isDebugEnabled());
		configureLoggingFrameworkWithDebug();
		assertTrue(logger.isDebugEnabled());
	}

	public void testIsInfoEnabled() {
		configureLoggingFrameworkWithNone();
		assertFalse(logger.isInfoEnabled());
		configureLoggingFrameworkWithInfo();
		assertTrue(logger.isInfoEnabled());
	}
	
	public void testIsErrorEnabled() {
	  configureLoggingFrameworkWithNone();
	  assertFalse(logger.isErrorEnabled());
	  configureLoggingFrameworkWithError();
	  assertTrue(logger.isErrorEnabled());
	}
	
	public void testIsWarningEnabled() {
		configureLoggingFrameworkWithNone();
		assertFalse(logger.isWarningEnabled());
		configureLoggingFrameworkWithWarning();
		assertTrue(logger.isWarningEnabled());
	}
	
	protected abstract void configureLoggingFrameworkWithNone();
	
	protected abstract void configureLoggingFrameworkWithError();
	
	protected abstract void configureLoggingFrameworkWithInfo();

	protected abstract void configureLoggingFrameworkWithDebug();
	
	protected abstract void configureLoggingFrameworkWithWarning();
}