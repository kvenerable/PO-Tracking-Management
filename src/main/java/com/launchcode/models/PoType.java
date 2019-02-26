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


    @Column(name = "name")
    @NotNull
    private String name;

    @OneToMany
    @JoinColumn(name = "po_type_id")
    private List<PurchaseOrder> purchaseOrders = new ArrayList<>();


    public PoType() { }

    public PoType(String name) { this.name = name; }

    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoType() { return name; }

    public void setPoType(String name) { this.name = name; }


    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }
}

