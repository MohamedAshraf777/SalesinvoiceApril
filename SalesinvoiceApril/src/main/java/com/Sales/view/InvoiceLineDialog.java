/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Sales.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.Sales.controller.InvoiceActionListener;
import com.Sales.controller.InvoiceSelectionListener;
import com.Sales.model.InvoiceHeader;
import com.Sales.model.InvoiceHeaderTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author DELL
 */
public class InvoiceLineDialog extends JDialog{
    private JTextField itemNameField;
    private JTextField itemCountField;
    private JTextField itemPriceField;
    private JLabel itemNameLbl;
    private JLabel itemCountLbl;
    private JLabel itemPriceLbl;
    private JButton saveBtn;
    private JButton deleteBtn;
    
    public InvoiceLineDialog(InvoiceFrame frame) {
        itemNameField = new JTextField(20);
        itemNameLbl = new JLabel(" Item Name");
        
        itemCountField = new JTextField(20);
        itemCountLbl = new JLabel(" Item Count");
        
        itemPriceField = new JTextField(20);
        itemPriceLbl = new JLabel(" Item Price");
        
        saveBtn = new JButton("Save");
        deleteBtn = new JButton("Cancel");
        
        saveBtn.setActionCommand("newLineSave");
        deleteBtn.setActionCommand("newLineDelete");
        
        saveBtn.addActionListener(frame.getActionListener());
        deleteBtn.addActionListener(frame.getActionListener());
        setLayout(new GridLayout(4, 2));
        
        add(itemNameLbl);
        add(itemNameField);
        add(itemCountLbl);
        add(itemCountField);
        add(itemPriceLbl);
        add(itemPriceField);
        add(saveBtn);
        add(deleteBtn);
        
        pack();
    }

   

    

    public JTextField getItemNameField() {
        return itemNameField;
    }

    public JTextField getItemCountField() {
        return itemCountField;
    }

    public JTextField getItemPriceField() {
        return itemPriceField;
    }
}
