package com.launchcode.models;

import java.util.ArrayList;

public class PurchaseOrderData {

    static ArrayList<PurchaseOrder> purchaseOrders = new ArrayList<>();

    public static ArrayList<PurchaseOrder> getAll(){
        return purchaseOrders;
    }

    public static void add(PurchaseOrder newPurchaseOrder){
        purchaseOrders.add(newPurchaseOrder);
    }

    public static PurchaseOrder getById(int id){
        PurchaseOrder thePurchaseOrder = null;

        for (PurchaseOrder onePurchaseOrder : purchaseOrders){
            if(onePurchaseOrder.getPoId()==id){
                thePurchaseOrder = onePurchaseOrder;
            }

        }
        return thePurchaseOrder;
    }
}
