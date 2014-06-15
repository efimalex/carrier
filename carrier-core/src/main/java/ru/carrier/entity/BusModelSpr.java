package ru.carrier.entity;

import javax.persistence.*;

/**
 * Created by User on 19.03.14.
 */
@Table(name = "bus_model_spr")
@Entity
public class BusModelSpr extends SprData {

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = BusBrandSpr.class)
    @JoinColumn(name = "bus_brand_id")
    private BusBrandSpr busBrandSpr;

    public BusBrandSpr getBusBrandSpr() {
        return busBrandSpr;
    }

    public void setBusBrandSpr(BusBrandSpr busBrandSpr) {
        this.busBrandSpr = busBrandSpr;
    }
}
