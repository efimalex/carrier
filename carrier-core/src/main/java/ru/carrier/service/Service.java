package ru.carrier.service;

import ru.carrier.domain.AppEntity;
import ru.carrier.entity.Carrier;

import java.util.List;

/**
 * Created by Саня on 23.05.2014.
 */
public interface Service<T extends AppEntity> {

    void save(T entity);

    T saveOrUpdate(T entity);

    T delete(T entity);

    T find(Class<T> aClass,Long id);

    List<T> findAll();

}
