/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Sales.controller;

import com.Sales.model.InvoiceHeader;
import com.Sales.model.InvoiceHeaderTableModel;
import com.Sales.model.InvoiceItems;
import com.Sales.model.InvoiceItemsTableModel;
import com.Sales.view.InvoiceFrame;
import com.Sales.view.InvoiceHeaderDialog;
import com.Sales.view.InvoiceLineDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author mohamed.ashraf
 */
public class InvoiceActionListener implements ActionListener{
    private InvoiceFrame frame;
    private InvoiceHeaderDialog headerDialog;
   
    private InvoiceLineDialog itemsDialog;
    
    
    public InvoiceActionListener(InvoiceFrame frame) {
        this.frame=frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Load Files" -> {
                try {
                    loadFiles();
                } catch (IOException | ParseException ex) {
                    Logger.getLogger(InvoiceActionListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
            case "Save Files" -> {
                try {
                    saveFiles();
                } catch (IOException ex) {
                    Logger.getLogger(InvoiceActionListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

                
            case "New Invoice" -> createNewInvoice();
                
            case "Delete Invoice" -> deleteInvoice();
        
            case "Save Invoice" -> createNewLine();
                
            case "Cancel Changes" -> deleteLine();
            
            case"addNewInvoice"-> {
                try {
                    addNewInovice();
                } catch (ParseException ex) {
                    Logger.getLogger(InvoiceActionListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            
            case"cancelInvoice"-> cancelInvoice();
            
            case"newLineSave" -> newLineSave();
            case"newLineDelete"-> newLineDelete();
            

        }
        
    }

    

    private void createNewInvoice() {
        
        headerDialog = new InvoiceHeaderDialog(frame);
        headerDialog.setVisible(true);
    }
    
    
    private void deleteInvoice() {
        int selectedInvoiceIndex = frame.getInvoicesTable().getSelectedRow();
        if(selectedInvoiceIndex != -1){
        
            frame.getInvoicesArray().remove(selectedInvoiceIndex);
            frame.getHeaderTableModel().fireTableDataChanged();
            
            frame.getInvoicesItemsTable().setModel(new InvoiceItemsTableModel (null));
            frame.setItemsArray(null);
            frame.getCusName().setText("");
            frame.getInvID().setText("");
            frame.getInvTotal().setText("");
            frame.getInvDate().setText("");
        
        
        }
        
        
    }
    private void createNewLine() {
        itemsDialog = new InvoiceLineDialog(frame);
        itemsDialog.setVisible(true);
    }
    
     
    
    private void deleteLine() {
        
        int selectedLine = frame.getInvoicesItemsTable().getSelectedRow();
        int selectedInvoice = frame.getInvoicesTable().getSelectedRow();
        if(selectedLine !=-1){
        
            frame.getItemsArray().remove(selectedLine);
            InvoiceItemsTableModel itemsTableModel =(InvoiceItemsTableModel) frame.getInvoicesItemsTable().getModel();
            itemsTableModel.fireTableDataChanged();
            frame.getInvTotal().setText(""+frame.getInvoicesArray().get(selectedInvoice).getInvTotal());
            frame.getHeaderTableModel().fireTableDataChanged();
            frame.getInvoicesTable().setRowSelectionInterval(selectedInvoice, selectedInvoice);
        }
            
    }

    

   

    

    private void saveFiles() throws IOException {
        ArrayList <InvoiceHeader> invoicesSave= frame.getInvoicesArray();
        JFileChooser fileChooser=new JFileChooser ();
        try{
        int result = fileChooser.showSaveDialog(frame);
        if(result == JFileChooser.APPROVE_OPTION){
            
            File headerFile = fileChooser.getSelectedFile();
            FileWriter headFileWriter = new FileWriter(headerFile);
            String headers="";
            String lines="";
             JOptionPane.showMessageDialog(frame, "File Header Saved successfully", "Attention", JOptionPane.WARNING_MESSAGE);
            
            for(InvoiceHeader invoicesHead : invoicesSave){
                headers += invoicesHead.toString();
                headers += "\n";
            for(InvoiceItems invoicesitems : invoicesHead.getItems()){
                lines += invoicesitems.toString();
                lines += "\n";
            }    
             
        }
                  

            headers=headers.substring(0, headers.length()-1);
            lines=lines.substring(0, lines.length()-1);
            result = fileChooser.showSaveDialog(frame);
            File lineFile = fileChooser.getSelectedFile();
            FileWriter lineFileWriter = new FileWriter(lineFile);
            JOptionPane.showMessageDialog(frame, "File Line Saved successfully", "Attention", JOptionPane.WARNING_MESSAGE);
            headFileWriter.write(headers);
            lineFileWriter.write(lines);
            headFileWriter.close();
            lineFileWriter.close();
        }
    }catch (IOException ex){
        
        JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
        
    }}

    
    
    private void loadFiles() throws IOException, ParseException {
        JOptionPane.showMessageDialog(frame, "Please Select Header File!", "Attention", JOptionPane.WARNING_MESSAGE);
        JFileChooser fileChooser=new JFileChooser();
        try{
        int result= fileChooser.showOpenDialog(frame);
        
        if (result==JFileChooser.APPROVE_OPTION)
        {
            File headerFile = fileChooser.getSelectedFile();
            Path headerpath = Paths.get(headerFile.getAbsolutePath());
            List<String> headerLines= Files.readAllLines(headerpath);
            
            ArrayList <InvoiceHeader>invHeaders=new ArrayList<>(); // Array to get All Invoice Data 
            // get file invoice header Data 
            
            for(String headerLine:headerLines){
            // Invoice Header Data 
                String []invData=headerLine.split(",");
                String el1 = invData[0];             //Invoice num (int)
                String el2=invData[1];               //Date      (Date)
                String cusName=invData[2];          // Customer name (String )
                
                 int invId=Integer.parseInt(el1);
                Date invDt=InvoiceFrame.dateFormat.parse(el2);
                //object from class invoice header
                InvoiceHeader header=new InvoiceHeader(invId, cusName, invDt); // Array to get line by line 
                
                invHeaders.add(header);
            }
            frame.setInvoicesArray(invHeaders);
            JOptionPane.showMessageDialog(frame, "Please Select Items File!", "Attention", JOptionPane.WARNING_MESSAGE);
            // get file invoice Line Data 
            result=fileChooser.showOpenDialog(frame);
            if(result==JFileChooser.APPROVE_OPTION)
            {
                File itemsFile=fileChooser.getSelectedFile();
                Path itemsPath=Paths.get(itemsFile.getAbsolutePath());
                List<String> itemsLines=Files.readAllLines(itemsPath);
                ArrayList<InvoiceItems> invItems=new ArrayList<>();

            for (String itemsLine: itemsLines )
            {
            
                String [] itemsData = itemsLine.split(",");
                //Invoice Line of items Data 
                String el1 = itemsData[0];                 // Invoice Num (int)
                String itemName=itemsData[1];             // Item Name     (String)
                String el3=itemsData[2];                 //Price          (double)
                String el4=itemsData[3];                // Count         (int)
                 
                 int Id=Integer.parseInt(el1);
                 double itemPrice=Double.parseDouble(el3);
                 int itemCount=Integer.parseInt(el4);
                 
                 InvoiceHeader inv=frame.getInvObject(Id);
                 
                 InvoiceItems items=new InvoiceItems(itemName, itemPrice, itemCount, inv);
                 inv.getItems().add(items);
            }
            
            }
            InvoiceHeaderTableModel headerTableModel=new InvoiceHeaderTableModel(invHeaders);
            frame.setHeaderTableModel(headerTableModel);
            frame.getInvoicesTable().setModel(headerTableModel);
            System.out.println("Files Read");
               }
        }catch (IOException | ParseException ex){
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        }

    private void addNewInovice() throws ParseException {
       headerDialog.setVisible(false);
       String customerName=headerDialog.getCustNameField().getText();
       
       
       String str=headerDialog.getInvDateField().getText();
       
       Date dt = new Date();
       try{
       dt = InvoiceFrame.dateFormat.parse(str);
       }catch (ParseException ex){
       
           JOptionPane.showMessageDialog(frame, "Cann't Parse Date", "Resetting to today", JOptionPane.ERROR_MESSAGE);
       }
       
       int invNum=0;
       for(InvoiceHeader inv : frame.getInvoicesArray()){
       
           if(inv.getNum() > invNum) invNum = inv.getNum();
       }
       invNum++;
       
       InvoiceHeader invoice = new InvoiceHeader(invNum,customerName,dt);
       frame.getInvoicesArray().add(invoice);
       frame.getHeaderTableModel().fireTableDataChanged();
       
      
       headerDialog.dispose();
       headerDialog = null;
       
       
    }

    private void cancelInvoice() {
       headerDialog.setVisible(false);
       headerDialog.dispose();
       headerDialog = null; 
    }

    private void newLineDelete() {
        itemsDialog.setVisible(false);
       itemsDialog.dispose();
       itemsDialog = null; 
        
    }

    private void newLineSave() {
        itemsDialog.setVisible(false);
        String itemName = itemsDialog.getItemNameField().getText();
        String count = itemsDialog.getItemCountField().getText();
        String price = itemsDialog.getItemPriceField().getText();
        
        int itemCount= 1 ;
        double itemPrice = 1;
        
        try{
        
            itemCount = Integer.parseInt(count);
        }catch(NumberFormatException ex){
        
            JOptionPane.showMessageDialog(frame, "Cannot Convert Number", "Invaild Number Format", JOptionPane.ERROR_MESSAGE);
        }try{
        
            itemPrice = Double.parseDouble(price);
        }catch(NumberFormatException ex){
        
            JOptionPane.showMessageDialog(frame, "Cannot Convert Price", "Invaild Number Format", JOptionPane.ERROR_MESSAGE);
        }
        int selectedInvoice = frame.getInvoicesTable().getSelectedRow();
        if (selectedInvoice !=-1){
            
            InvoiceHeader numHeader = frame.getInvoicesArray().get(selectedInvoice);
            InvoiceItems items = new InvoiceItems(itemName, itemPrice, itemCount, numHeader);
            //numHeader.getItems().add(items);
            frame.getItemsArray().add(items);
            InvoiceItemsTableModel itemsTableModel = (InvoiceItemsTableModel) frame.getInvoicesItemsTable().getModel();
            itemsTableModel.fireTableDataChanged();
            frame.getHeaderTableModel().fireTableDataChanged();

        }
       frame.getInvoicesTable().setRowSelectionInterval(selectedInvoice, selectedInvoice);
       itemsDialog.dispose();
       itemsDialog = null; 
        
    }
    }
    

