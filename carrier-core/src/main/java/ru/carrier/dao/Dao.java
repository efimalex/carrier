package ru.carrier.dao;


import ru.carrier.domain.AppEntity;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 11.10.13
 * Time: 21:15
 * To change this template use File | Settings | File Templates.
 */
public interface Dao<T extends AppEntity> {
    /**
     * Base method for object saving (controls object inserting and updating).
     *
     * @param entity object to save
     */
    public void save(T entity);

    T saveOrUpdate(T entity);

    void saveOrUpdate(final Collection<T> entityObjects);

    void save(final Collection<T> entityObjects);

    void refresh(final T entityObject);

    /**
     * Base method for object deleting that bases on object class and id.
     *
     * @param id - an id (primary key) of the object
     */
    public T delete(T entity);

    /**
     * Deletes an Entity object by Entity id from a database.
     *
     * @param entityId if of entity to load
     * @param aType class of an entity to load
     */

    public void delete(final Class<T> aType, final Long entityId);

    /**
     * Base method for extracting object that bases on object class and id. If
     * no object found returns null
     *
     * @param entityId the identifier (primary key) of the class
     * @return filled object
     */
    public T findById(Class<T> aType, final Long entityId);

    /**
     * Finder method.
     *
     * @return List of updatable Entities
     */
    public List<T> findAll();

}
