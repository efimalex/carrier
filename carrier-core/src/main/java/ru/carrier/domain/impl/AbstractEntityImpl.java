package ru.carrier.domain.impl;


import ru.carrier.domain.AppEntity;

import javax.persistence.*;


/**
 * The default implementation of <code>Entity</code>.
 */
@MappedSuperclass
public abstract class AbstractEntityImpl extends AbstractPersistenceImpl implements AppEntity {
	/**
	 * Serial version id.
	 */
	public static final long serialVersionUID = 5000000001L;

	public static final int LENGTH_6 = 6;

	public static final int LENGTH_16 = 16;

	public static final int LENGTH_32 = 32;

    public static final int LENGTH_26 = 26;

	public static final int LENGTH_64 = 64;

	public static final int LENGTH_8 = 8;

	public static final int LENGTH_128 = 128;

    public static final int LENGTH_256 = 256;

    public static final int LENGTH_512 = 512;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	public long getId() {
		return id;
	}

	protected void setId(final long uidPk) {
		this.id = uidPk;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}

		if (isNew()) {
			return false;
		}

		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass() && !obj.getClass().isAssignableFrom(getClass())
				&& !getClass().isAssignableFrom(obj.getClass())) {
			return false;
		}
		final AppEntity entity = (AppEntity) obj;
		return this.id == entity.getId();
	}

	protected boolean isNew() {
		return id == 0;
	}

	/**
	 * @return hash code which is id or 0
	 */
	@Override
	public int hashCode() {
		return Long.valueOf(id).hashCode();
	}
}
