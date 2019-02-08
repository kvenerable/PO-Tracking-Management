package com.launchcode.models;

import javax.persistence.*;

@Entity
public class PurchaseOrder {

    @Id
    @GeneratedValue
    @Column(name ="id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "number")
    private String number;

    @Column(name ="date")
    private String date;

    @Column(name ="coordinatorName")
    private String coordinatorName;

    @Column(name="poAmount")
    private Integer poAmount;

    @Column(name = "poBalance")
    private Integer poBalance;


   @ManyToOne
    private  PoType poType;




    public PurchaseOrder(String name, String number, String date, String coordinatorName, Integer poAmount, Integer poBalance) {
        this();
        this.name = name;
        this.number = number;
        this.date = date;
        this.coordinatorName = coordinatorName;
        this.poAmount = poAmount;
        this.poBalance = poBalance;
    }

    public PurchaseOrder() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCoordinatorName() {
        return coordinatorName;
    }

    public void setCoordinatorName(String coordinatorName) {
        this.coordinatorName = coordinatorName;
    }

    public Integer getPoAmount() { return poAmount; }

    public void setPoAmount(int poAmount) {
        this.poAmount = poAmount;
    }

    public Integer getPoBalance() {
        return poBalance;
    }

    public void setPoBalance(int poBalance) {
        this.poBalance = poBalance;
    }

    public PoType getPoType() {
        return poType;
    }

    public void setPoType(PoType poType) {
        this.poType = poType;
    }
}
