package ru.carrier.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.carrier.dao.Dao;
import ru.carrier.domain.AppEntity;
import ru.carrier.service.Service;

import java.util.List;

/**
 * Created by Саня on 23.05.2014.
 */
@org.springframework.stereotype.Service
public abstract class ServiceImpl<T extends AppEntity> implements Service<T> {

    @Autowired
    protected Dao<T> dao;

    @Override
    @Transactional
    public void save(T entity) {
        getDao().save(entity);
    }

    @Override
    @Transactional
    public T saveOrUpdate(T entity) {
        return getDao().saveOrUpdate(entity);
    }

    @Override
    @Transactional
    public T delete(T entity) {
        return getDao().delete(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public T find(Class<T> aClass,Long id) {
        return getDao().findById(aClass, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return getDao().findAll();
    }

    protected abstract Dao<T> getDao();
}
