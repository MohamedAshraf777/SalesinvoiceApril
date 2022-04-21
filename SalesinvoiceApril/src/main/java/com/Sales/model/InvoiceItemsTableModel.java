/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Sales.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mohamed.ashraf
 */
public class InvoiceItemsTableModel extends AbstractTableModel {
    
    private ArrayList <InvoiceItems> itemsArray;
    private String []columns;
    
    public InvoiceItemsTableModel(ArrayList<InvoiceItems> itemsArray) {
       this.columns = new String[]{"No.","Item Name", "Item Price", "Count", "Item Total"};
        this.itemsArray = itemsArray;
    }


    @Override
    public int getRowCount() {
        return itemsArray == null ? 0 : itemsArray.size();
    }
    
    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        if (itemsArray == null){
            return "";
        }
        else {
        
        InvoiceItems invItems = itemsArray.get(rowIndex);
        switch (columnIndex){
            
            case 0 ->{
            
                return invItems.getHeader().getNum();
            }
            
            case 1 -> {
                return invItems.getItemName();
            }
            case 2 -> {
                return invItems.getItemPrice();
            }
            case 3 -> {
                return invItems.getItemCount();
            }
            case 4 -> {
                return invItems.getItemsTotal();
            }
        }
        }return "";
    }
    public String getColumnName(int column) {
      //return "Column";

        return columns[column]; 
    }
    
}
