/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Sales.controller;

import com.Sales.model.InvoiceHeader;
import com.Sales.model.InvoiceItems;
import com.Sales.model.InvoiceItemsTableModel;
import com.Sales.view.InvoiceFrame;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author mohamed.ashraf
 */
public class InvoiceSelectionListener implements ListSelectionListener{

    private InvoiceFrame frame;
    @Override
    public void valueChanged(ListSelectionEvent e) {
        //Get ID of Selected line in invoice table
        int numInvSelected=frame.getInvoicesTable().getSelectedRow();
        System.out.println("Selected Invoice" +numInvSelected );
        if(numInvSelected != -1){
        //Get Data of Selected Line
        InvoiceHeader invSelected =frame.getInvoicesArray().get(numInvSelected);
        ArrayList<InvoiceItems> rowSelected=invSelected.getItems();
        InvoiceItemsTableModel itemsTableModel=new InvoiceItemsTableModel(rowSelected);
        frame.setItemsArray(rowSelected);
        frame.getInvoicesItemsTable().setModel(itemsTableModel);
        frame.getCusName().setText(invSelected.getCustomer());
        frame.getInvID().setText(""+invSelected.getNum());
        frame.getInvTotal().setText(""+invSelected.getInvTotal());
        frame.getInvDate().setText(InvoiceFrame.dateFormat.format(invSelected.getDt()));
        }
        
              
        
    }

    public InvoiceSelectionListener(InvoiceFrame frame) {
        this.frame = frame;
    }
    
    
    
}
