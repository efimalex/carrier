package ru.carrier.domain;

/**
 * Represents domain objects need to be persisted.
 */
public interface Persistence extends Domain {
	/**
	 * Gets the unique identifier for this domain object. This unique identifier is system-dependant. That means on differenct systems(like staging
	 * and production environments), different identifiers might be assigned to the same(from business perspective) domain object.
	 * <p>
	 * Notice: not all persistent domain objects has unique identifier. Some value objects don't have unique identifer. They are cascading loaded and
	 * updated through their parents.
	 * 
	 * @return the unique identifier.
	 */
	long getId();

	/**
	 * <code>true</code> if the object has previously been persisted.
	 * <p>
	 * Notice: not all persistent domain objects has unique identifier. Some value objects don't have unique identifer. They are cascading loaded and
	 * updated through their parents. It doesn't make sense to call this method on those value object.
	 * 
	 * @return <code>true</code> if the object has previously been persisted.
	 */
	boolean isPersistent();
}
