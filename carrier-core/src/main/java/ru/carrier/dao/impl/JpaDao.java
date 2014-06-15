package ru.carrier.dao.impl;

import org.apache.commons.lang.ArrayUtils;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import ru.carrier.dao.Dao;
import ru.carrier.domain.AppEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

import static org.apache.commons.lang.StringUtils.isNotBlank;
import static org.hibernate.criterion.Restrictions.*;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 11.10.13
 * Time: 21:21
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class JpaDao<T extends AppEntity> implements Dao<T> {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    private Class<T> type;

    /**
     * Constructor for setting up concrete Entity type.
     *
     * @param type an implementation (not interface) class of corresponding entity
     */
    protected JpaDao(final Class<T> type) {
        this.type = type;
    }

    /**
     * Default constructor.
     */
    protected JpaDao() {
        // Empty
    }

    @Override
    public void save(T entity) {
        em.persist(entity);
    }

    @Override
    public T saveOrUpdate(T entity) {
        return em.merge(entity);
    }

    /**
     * Saves or updates an collection of entities.
     *
     * @param entityObjects an collection of entities
     */
    @Override
    public void saveOrUpdate(final Collection<T> entityObjects) {
        for (Iterator<T> iterator = entityObjects.iterator(); iterator.hasNext();) {
            T entity = iterator.next();
            em.merge(entity);
        }
    }

    @Override
    public void save(final Collection<T> entityObjects) {
        for (Iterator<T> iterator = entityObjects.iterator(); iterator.hasNext();) {
            T entity = iterator.next();
            em.persist(entity);
        }
    }

    @Override
    public void refresh(final T entityObject) {
        em.refresh(entityObject);
    }

    @Override
    public T delete(T entity) {
        em.remove(entity);
        em.flush();
        return entity;
    }

    /**
     * Deletes an Entity object by Entity id from a database.
     *
     * @param entityId if of entity to load
     * @param aType class of an entity to load
     */
    @Override
    public void delete(final Class<T> aType, final Long entityId) {
        T entityObject = em.find(aType, entityId);
        em.remove(entityObject);
    }


    @Override
    public T findById(Class<T> aType, final Long entityId) {
       return em.find(aType, entityId);
    }

    /**
     * Finder method. If ids are not specified null is returned.
     *
     * @return List of updatable Entities
     */
    public List<T> findByIds(final Long... ids) {
        if (ArrayUtils.isEmpty(ids)) {
            return null;
        }
        Query query = em.createQuery(" from " + this.type.getSimpleName() + " WHERE id IN (:ids)");
        query.setParameter("ids", ids);
        return query.getResultList();
    }

    /**
     * Finder method.
     *
     * @return List of updatable Entities
     */
    @Override
    public List<T> findAll() {
        Query query = em.createQuery(" from " + this.type.getSimpleName());
        return query.getResultList();
    }

    protected EntityManager getEm() {
        return em;
    }

    /**
     * Creates HQL criteria base on backed entity class.
     *
     * @return created criteria
     */
    protected Criteria createCriteria() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        return (Criteria) builder.createQuery(type);
    }

    protected Criteria createCriteria(Class<T> aType) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        return (Criteria) builder.createQuery(aType);
    }

    /**
     * Adds eq expression.
     *
     * @param criteria Criteria
     * @param propName search value
     * @param value property name
     */
    protected void addEqStringRestriction(final Criteria criteria, final String propName, final String value) {
        if (isNotBlank(value)) {
            criteria.add(eq(propName, StringUtils.trimWhitespace(value)));
        }
    }

    /**
     * Adds eq expression.
     *
     * @param criteria Criteria
     * @param propName property name
     * @param value search value
     * @return
     */
    protected Criteria addEqRestriction(final Criteria criteria, final String propName, final Object value) {
        if (value != null) {
            return criteria.add(eq(propName, value));
        }

        return criteria;
    }

    /**
     * Adds ne("not equal") expression.
     *
     * @param criteria Criteria
     * @param propName property name
     * @param value search value
     */
    protected void addNeRestriction(final Criteria criteria, final String propName, final Object value) {
        if (value != null) {
            criteria.add(ne(propName, value));
        }
    }

    /**
     * Adds gt expression.
     *
     * @param criteria Criteria
     * @param propName property name
     * @param value search value
     */
    protected void addGtRestriction(final Criteria criteria, final String propName, final Object value) {
        if (value != null) {
            criteria.add(gt(propName, value));
        }
    }

    /**
     * Adds lt expression.
     *
     * @param criteria Criteria
     * @param propName property name
     * @param value search value
     */
    protected void addLtRestriction(final Criteria criteria, final String propName, final Object value) {
        if (value != null) {
            criteria.add(lt(propName, value));
        }
    }

    /**
     * Adds ge "greater than or equal" expression.
     *
     * @param criteria Criteria
     * @param propName property name
     * @param value search value
     */
    protected void addGeRestriction(final Criteria criteria, final String propName, final Object value) {
        if (value != null) {
            criteria.add(ge(propName, value));
        }
    }

    /**
     * Adds le "less than or equal" expression.
     *
     * @param criteria Criteria
     * @param propName property name
     * @param value search value
     */
    protected void addLeRestriction(final Criteria criteria, final String propName, final Object value) {
        if (value != null) {
            criteria.add(le(propName, value));
        }
    }

    /**
     * Adds expression which check a value being in a collection.
     *
     * @param criteria Criteria
     * @param propName property name
     * @param values search value
     */
    protected void addCollectionInRestriction(final Criteria criteria, final String propName, final java.util.Collection<?> values) {
        if (values != null) {
            criteria.add(in(propName, values));
        }
    }

    /**
     * Adds expression which check a value being in a collection.
     *
     * @param criteria Criteria
     * @param propName property name
     * @param value search value
     */
    protected void addCollectionInRestriction(final Criteria criteria, final String propName, final Object value) {
        if (value != null) {
            Collection collection = new ArrayList(1);
            collection.add(value);
            addCollectionInRestriction(criteria, propName, collection);
        }
    }

    /**
     * Adds expression which check a value being in a collection.
     *
     * @param criteria Criteria
     * @param propName property name
     * @param value search value
     */
    protected void addCollectionInArrayRestriction(final Criteria criteria, final String propName, final Object[] value) {
        if (value != null && value.length > 0 && value[0] != null) {
            Collection collection = new ArrayList(value.length);
            collection.addAll(Arrays.asList(value));
            addCollectionInRestriction(criteria, propName, collection);
        }
    }

    /**
     * Adds eq expression.
     *
     * @param criteria Criteria
     * @param propertyName property name
     * @param value search value
     */
    protected void addEqRestriction(final Criteria criteria, final String propertyName, final String value) {
        if (isNotBlank(value)) {
            criteria.add(eq(propertyName, StringUtils.trimWhitespace(value)));
        }
    }

    /**
     * Adds ilike expression.
     *
     * @param criteria Criteria
     * @param propertyName property name
     * @param searchValue search value
     */
    protected void addLikeRestriction(final Criteria criteria, final String propertyName, final String searchValue) {
        if (isNotBlank(searchValue)) {
            criteria.add(ilike(propertyName, StringUtils.trimWhitespace(searchValue)));
        }
    }

    /**
     * Adds "is Null" restriction expression.
     *
     * @param criteria Criteria
     * @param propertyName property name
     */
    protected void addIsNullRestriction(final Criteria criteria, final String propertyName) {
        if (isNotBlank(propertyName)) {
            criteria.add(isNull(propertyName));
        }
    }

    /**
     * Adds "between" restriction expression.
     *
     * @param criteria Criteria
     * @param propertyName property name
     * @param lo
     * @param hi
     */
    protected void addBetweenRestriction(final Criteria criteria, final String propertyName, final Object lo, final Object hi) {
        if (lo != null && hi != null) {
            criteria.add(between(propertyName, lo, hi));
        } else {
            addLeRestriction(criteria, propertyName, hi);
            addGeRestriction(criteria, propertyName, lo);
        }
    }

}
