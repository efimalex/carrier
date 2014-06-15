package ru.carrier.service.impl;

import org.springframework.stereotype.Service;
import ru.carrier.dao.Dao;
import ru.carrier.entity.BusBrandSpr;
import ru.carrier.entity.SprData;
import ru.carrier.service.SprDataManagement;

import java.util.List;

/**
 * Created by Саня on 27.05.2014.
 */
@Service("sprDataManagement")
public class SprDataManagementImpl extends ServiceImpl<SprData> implements SprDataManagement {
    @Override
    protected Dao<SprData> getDao() {
        return dao;
    }

    @Override
    public List<BusBrandSpr> getAllBusBrands() {
        dao.findById(BusBrandSpr.class, 1L);
        //return dao;
    }
}
