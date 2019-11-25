/**
 * Copyright (C) 2000-2017 Atomikos <info@atomikos.com>
 *
 * LICENSE CONDITIONS
 *
 * See http://www.atomikos.com/Main/WhichLicenseApplies for details.
 */

package com.atomikos.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;

import com.atomikos.datasource.xa.session.SessionHandleState;
import com.atomikos.logging.Logger;
import com.atomikos.logging.LoggerFactory;

class AtomikosJmsMessageProducerProxy extends ConsumerProducerSupport implements
		MessageProducer {
	private static final Logger LOGGER = LoggerFactory.createLogger(AtomikosJmsMessageProducerProxy.class);
	
	private MessageProducer delegate;
	
	AtomikosJmsMessageProducerProxy ( MessageProducer delegate , SessionHandleState state ) 
	{
		super ( state );
		this.delegate = delegate;
	}
	
	public void send ( Message msg ) throws JMSException {
		LOGGER.logDebug ( this + ": send ( message )..." );
		enlist ( );
		delegate.send ( msg );
		LOGGER.logTrace ( this + ": send done." );
	}

	public void close() throws JMSException {
		LOGGER.logDebug( this + ": close..." );
		delegate.close();
		LOGGER.logTrace ( this + ": close done." );
	}

	public int getDeliveryMode() throws JMSException {
		LOGGER.logDebug ( this + ": getDeliveryMode()..." );
		int ret = delegate.getDeliveryMode();
		LOGGER.logTrace ( this + ": getDeliveryMode() returning " + ret );
		return ret;
	}

	public Destination getDestination() throws JMSException {
		LOGGER.logDebug ( this + ": getDestination()..." );
		Destination ret = delegate.getDestination();
		LOGGER.logTrace ( this + ": getDestination() returning " + ret );
		return ret;
	}

	public boolean getDisableMessageID() throws JMSException {
		LOGGER.logDebug ( this + ": getDisableMessageID()..." );
		boolean ret = delegate.getDisableMessageID();
		LOGGER.logTrace ( this + ": getDisableMessageID() returning " + ret );
		return ret;
	}

	public boolean getDisableMessageTimestamp() throws JMSException {
		LOGGER.logDebug ( this + ": getDisableMessageTimestamp()..." );
		boolean ret = delegate.getDisableMessageTimestamp();
		LOGGER.logTrace ( this + ": getDisableMessageTimestamp() returning " + ret );
		return ret;
	}

	public int getPriority() throws JMSException {
		LOGGER.logDebug ( this + ": getPriority()..." );
		int ret =  delegate.getPriority();
		LOGGER.logTrace ( this + ": getPriority() returning " + ret );
		return ret;
	}

	public long getTimeToLive() throws JMSException {
		LOGGER.logDebug ( this + ": getTimeToLive()..." );
		long ret =  delegate.getTimeToLive();
		LOGGER.logTrace ( this + ": getTimeToLive() returning " + ret );
		return ret;
	}



	public void send(Destination dest , Message msg ) throws JMSException {
		LOGGER.logDebug ( this + ": send ( destination , message )..." );
		enlist ( );
		delegate.send ( dest , msg );
		LOGGER.logTrace ( this + ": send done." );
	}

	public void send(Message msg , int deliveryMode , int priority , long timeToLive )
			throws JMSException {
		LOGGER.logDebug ( this + ": send ( message , deliveryMode , priority , timeToLive )..." );
		enlist ( );
		delegate.send (  msg , deliveryMode , priority , timeToLive );
		LOGGER.logTrace ( this + ": send done." );
	}

	public void send ( Destination dest , Message msg , int deliveryMode , int priority ,
			long timeToLive ) throws JMSException {
		LOGGER.logDebug ( this + ": send ( destination , message , deliveryMode , priority , timeToLive )..." );
		enlist ( );
		delegate.send (  dest , msg , deliveryMode , priority , timeToLive );
		LOGGER.logTrace ( this + ": send done." );
	}

	public void setDeliveryMode ( int mode ) throws JMSException {
		LOGGER.logDebug ( this + ": setDeliveryMode ( " + mode + " )..." );
		delegate.setDeliveryMode ( mode );
		LOGGER.logTrace ( this + ": setDeliveryMode done." );
	}

	public void setDisableMessageID ( boolean mode ) throws JMSException {
		LOGGER.logDebug ( this + ": setDisableMessageID ( " + mode + " )..." );
		delegate.setDisableMessageID ( mode );
		LOGGER.logTrace ( this + ": setDisableMessageID done." );
	}

	public void setDisableMessageTimestamp ( boolean mode ) throws JMSException {
		LOGGER.logDebug ( this + ": setDisableMessageTimestamp ( " + mode + " )..." );
		delegate.setDisableMessageTimestamp ( mode );
		LOGGER.logTrace ( this + ": setDisableMessageTimestamp done." );
	}

	public void setPriority ( int pty ) throws JMSException {
		LOGGER.logDebug ( this + ": setPriority ( " + pty + " )..." );
		delegate.setPriority ( pty );
		LOGGER.logTrace ( this + ": setPriority done." );
	}

	public void setTimeToLive ( long ttl ) throws JMSException {
		LOGGER.logDebug ( this + ": setTimeToLive ( " + ttl + " )..." );
		delegate.setTimeToLive ( ttl );
		LOGGER.logTrace ( this + ": setTimeToLive done." );
	}
	
	public String toString() 
	{
		return "atomikos MessageProducer proxy for " + delegate;
	}

}
