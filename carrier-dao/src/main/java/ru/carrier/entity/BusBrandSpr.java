package ru.carrier.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Саня on 25.05.2014.
 */
@Entity(name = "bus_brand_spr")
public class BusBrandSpr extends SprData {

    @OneToMany(targetEntity = BusModelSpr.class, mappedBy = "busBrandSpr", fetch = FetchType.EAGER)
    private List<BusModelSpr> busModels;

    public List<BusModelSpr> getBusModels() {
        return busModels;
    }

    public void setBusModels(List<BusModelSpr> busModels) {
        this.busModels = busModels;
    }
}
