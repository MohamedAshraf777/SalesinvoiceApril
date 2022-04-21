/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Sales.model;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mohamed.ashraf
 */
public class InvoiceHeader {
    
    private int num;
    private String customer;
    private Date dt;
    private DateFormat dF = new SimpleDateFormat("dd-MM-yyyy");
    
    private ArrayList<InvoiceItems> items;

    public InvoiceHeader() {
        
    }

    public InvoiceHeader(int num, String customer, Date dt) {
        this.num = num;
        this.customer = customer;
        this.dt = dt;
    }

    public InvoiceHeader(int i, String customerName, String dt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return  num +"," + dF.format(dt)+","+ customer ;
    }

   

    public ArrayList<InvoiceItems> getItems() {
        if (items == null){
            items = new ArrayList<>();
        }
        
        return items;
    }

    public void setItems(ArrayList<InvoiceItems> items) {
        this.items = items;
    }
    
    
    public double getInvTotal(){
        double total=0.0;
        for (int i =0; i<getItems().size(); i++){
            total += getItems().get(i).getItemsTotal();
        }
        
        return total ;
    
    }
    
    public void addInvLine(InvoiceItems item){
    
        getItems().add(item);
    }
            
    
}
