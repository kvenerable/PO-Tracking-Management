package com.launchcode.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class PurchaseOrder {

    @Id
    @GeneratedValue
    @Column(name ="PoId")
    private int PoId;
    private static int nextId =1;

    @NotNull
    @Column(name = "name")
    private String name;
    @Column(name = "number")
    private String number;

    @NotNull
    @Column(name ="date")
    private String date;

    @NotNull
    @Column(name ="coordinatorName")
    private String coordinatorName;

    @NotNull
    @Column(name="poAmount")
    private Double poAmount;

    @NotNull
    @Column(name = "poBalance")
    private Double poBalance;


   @ManyToOne
    private PoType poType;






    public PurchaseOrder(String name, String number, String date, String coordinatorName, Double poAmount, Double poBalance) {
        this();
        this.name = name;
        this.number = number;
        this.date = date;
        this.coordinatorName = coordinatorName;
        this.poAmount = poAmount;
        this.poBalance = poBalance;

    }

    public PurchaseOrder() {

        PoId = nextId;
        nextId++;

    }

    public int getPoId() {
        return PoId;
    }

    public void setPoId(int poId) {
        PoId = poId;
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

    public Double getPoAmount() { return poAmount; }

    public void setPoAmount(Double poAmount) {
        this.poAmount = poAmount;
    }

    public Double getPoBalance() {
        return poBalance;
    }

    public void setPoBalance(Double poBalance) {
        this.poBalance = poBalance;
    }

    public PoType getPoType() {
        return poType;
    }

    public void setPoType(PoType poType) {
        this.poType = poType;
    }
}
