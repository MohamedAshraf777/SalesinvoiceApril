/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Sales.model;

/**
 *
 * @author mohamed.ashraf
 */
public class InvoiceItems {
    
    private int invId;
    private String itemName;
    private double itemPrice;
    private int itemCount;
    
    private InvoiceHeader header;

    public InvoiceItems() {
    }

    public InvoiceItems(String item, double price, int count, InvoiceHeader header) {
        
        this.itemName = item;
        
        this.itemPrice = price;
        this.itemCount = count;
        this.header = header;
    }

    public InvoiceHeader getHeader() {
        return header;
    }

    public void setHeader(InvoiceHeader header) {
        this.header = header;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
    
    public double getItemsTotal(){
    return itemPrice*itemCount;
    }

    @Override
    public String toString() {
        return header.getNum() + ","  + itemName + "," + itemPrice + "," + itemCount;
    }

    public int getInvId() {
        return invId;
    }

    public void setInvId(int invId) {
        this.invId = invId;
    }
    
    
}
