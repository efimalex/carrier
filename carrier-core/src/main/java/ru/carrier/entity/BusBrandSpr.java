package ru.carrier.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Саня on 25.05.2014.
 */
@Table(name = "bus_brand_spr")
@Entity
public class BusBrandSpr extends SprData {

    @OneToMany(targetEntity = BusModelSpr.class, mappedBy = "busBrandSpr", fetch = FetchType.LAZY)
    private List<BusModelSpr> busModels;
}
