package ru.carrier.service;

import ru.carrier.entity.BusBrandSpr;
import ru.carrier.entity.SprData;

import java.util.List;

/**
 * Created by Саня on 27.05.2014.
 */
public interface SprDataManagement<T extends SprData> extends Service<SprData> {

    List<BusBrandSpr> getAllBusBrands();

}
