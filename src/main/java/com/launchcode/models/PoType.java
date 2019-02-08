package com.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PoType {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @NotNull
    @Column(name = "poType")
    private String poType;



    public int getId() {
        return id;
    }

    public String getPoType() {
        return poType;
    }

    public void setPoType(String poType) {
        this.poType = poType;
    }

    public PoType() {
    }

    public PoType(String poType) {
        this.poType = poType;
    }
}
