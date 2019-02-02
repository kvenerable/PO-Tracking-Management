package com.launchcode.models;

public class PurchaseOrder {

    private String name;
    private String number;
    private String date;
    private String coordinatorName;
    private int poId;
    private static int nextId =1;


    public PurchaseOrder(String name, String number, String date, String coordinatorName) {
        this();
        this.name = name;
        this.number = number;
        this.date = date;
        this.coordinatorName = coordinatorName;
    }

    public PurchaseOrder() {
        poId = nextId;
        nextId++;
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

    public void setCoordonatorName(String coordinatorName) {
        this.coordinatorName = coordinatorName;
    }

    public int getPoId() {
        return poId;
    }

    public void setPoId(int poId) {
        this.poId = poId;
    }
}
