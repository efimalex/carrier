package ru.carrier.domain.impl;

import ru.carrier.domain.Persistence;

/**
 * The default implementation of <code>Persistence</code>.
 */
public abstract class AbstractPersistenceImpl extends AbstractDomainImpl implements Persistence {
	/**
	 * Serial version id.
	 */
	public static final long serialVersionUID = 5000000001L;

	/** Precision to be used for persisting decimal fields. */
	public static final int DECIMAL_PRECISION = 19;

	/** Scale to be used for persisting decimal fields. */
	public static final int DECIMAL_SCALE = 2;

	/**
	 * True if the object has previously been persisted.
	 * 
	 * @return true if the object has previously been persisted.
	 */
	public boolean isPersistent() {
		return getId() > 0;
	}

	/**
	 * Interceptor to perform tasks before persisting changes.
	 */
	public void executeBeforePersistAction() {
		// do nothing.
	}

}
