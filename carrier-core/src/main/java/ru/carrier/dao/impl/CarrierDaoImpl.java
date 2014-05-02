package ru.carrier.dao.impl;

import org.springframework.stereotype.Repository;
import ru.carrier.dao.CarrierDao;
import ru.carrier.entity.Carrier;

/**
 * Created by User on 16.04.2014.
 */
@Repository
public class CarrierDaoImpl extends JpaDao<Carrier> implements CarrierDao {

    public CarrierDaoImpl() {
        super(Carrier.class);
    }
}
