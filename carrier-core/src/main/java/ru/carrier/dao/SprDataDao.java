package ru.carrier.dao;

import org.springframework.stereotype.Repository;
import ru.carrier.entity.Bus;
import ru.carrier.entity.SprData;

/**
 * Created by User on 14.04.2014.
 */
@Repository
public interface SprDataDao<T extends SprData> extends Dao<T> {
    
}
