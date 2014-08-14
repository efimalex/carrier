package ru.carrier.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.carrier.domain.impl.AbstractEntityImpl;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by Саня on 29.05.2014.
 */
@MappedSuperclass
public class SprData extends AbstractPersistable<Long> {

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SprData() {
    }
}
