/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Sales.model;

import com.Sales.view.InvoiceFrame;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mohamed.ashraf
 */
public class InvoiceHeaderTableModel extends AbstractTableModel  {
    
    private ArrayList <InvoiceHeader>invoicesArray;
    private String []columns;

    public InvoiceHeaderTableModel(ArrayList<InvoiceHeader> invoicesArray) {
       this.columns = new String[]{"No.", "Date", "Customer", "Total"};
        this.invoicesArray = invoicesArray;
    }

    @Override
    public int getRowCount() {// Reserve number of rows need to draw 
        return invoicesArray.size();
      // return 5; 
    }

    @Override
    public int getColumnCount() {// Reserve number of colum need to draw 
        return columns.length;
        //return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       // return "test";
       // To draw each cell value 
        InvoiceHeader inv = invoicesArray.get(rowIndex);
        switch (columnIndex){
            case 0 -> {
                return inv.getNum();
            }
            case 1 -> {
                return InvoiceFrame.dateFormat.format( inv.getDt());
            }
            case 2 -> {
                return inv.getCustomer();
            }
            case 3 -> {
                return inv.getInvTotal();
            }
        }return "";
    }
    @Override
    public String getColumnName(int column) {
      //return "Column";

        return columns[column]; 
}
    
}

          
        

          
    

    
    
    
    

