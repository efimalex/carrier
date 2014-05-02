package ru.carrier.domain;

import java.io.Serializable;

/**
 * Represents a general domain object.
 */
public interface Domain extends Serializable {

	void setDefaultValues();
}
