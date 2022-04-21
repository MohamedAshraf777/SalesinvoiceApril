/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.Sales.view;

import com.Sales.controller.InvoiceActionListener;
import com.Sales.controller.InvoiceSelectionListener;
import com.Sales.model.InvoiceHeader;
import com.Sales.model.InvoiceHeaderTableModel;
import com.Sales.model.InvoiceItems;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author mohamed.ashraf
 */
public class InvoiceFrame extends javax.swing.JFrame {

    /**
     * Creates new form InvoiceForm
     */
    public InvoiceFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        InvoicesTable = new javax.swing.JTable();
        createNewInvoiceButton = new javax.swing.JButton();
        deleteInvoiceButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        InvoicesItemsTable = new javax.swing.JTable();
        saveItemsButton = new javax.swing.JButton();
        cancelItemsButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        invID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        invDate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cusName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        invTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        InvoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        InvoicesTable.getSelectionModel().addListSelectionListener(selectionListener);
        jScrollPane1.setViewportView(InvoicesTable);

        createNewInvoiceButton.setText("Create New Invoice");
        createNewInvoiceButton.setToolTipText("");
        createNewInvoiceButton.setActionCommand("New Invoice");
        createNewInvoiceButton.addActionListener(actionListener);
        createNewInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewInvoiceButtonActionPerformed(evt);
            }
        });

        deleteInvoiceButton.setText("Delete Invoice");
        deleteInvoiceButton.addActionListener(actionListener);

        InvoicesItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(InvoicesItemsTable);

        saveItemsButton.setText("Save");
        saveItemsButton.setActionCommand("Save Invoice");
        saveItemsButton.addActionListener(actionListener);
        saveItemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveItemsButtonActionPerformed(evt);
            }
        });

        cancelItemsButton.setText("Cancel");
        cancelItemsButton.setActionCommand("Cancel Changes");
        cancelItemsButton.addActionListener(actionListener);

        jLabel1.setText("Invoice Number:");

        jLabel3.setText("Invoice Date:");

        jLabel2.setText("Customer Name:");

        jLabel4.setText("Invoice Total:");

        jLabel5.setText("Invoices Table");

        jLabel6.setText("Invoice Items");

        jMenu1.setText("File");

        loadMenuItem.setText("Load Files");
        loadMenuItem.addActionListener(actionListener);
        loadMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(loadMenuItem);

        saveMenuItem.setText("Save Files");
        saveMenuItem.addActionListener(actionListener);
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(saveMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(createNewInvoiceButton)
                        .addGap(55, 55, 55)
                        .addComponent(deleteInvoiceButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(saveItemsButton)
                        .addGap(97, 97, 97)
                        .addComponent(cancelItemsButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invTotal)
                                    .addComponent(cusName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(invDate)
                                    .addComponent(invID, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(invID, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(invDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cusName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(invTotal))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createNewInvoiceButton)
                    .addComponent(deleteInvoiceButton)
                    .addComponent(saveItemsButton)
                    .addComponent(cancelItemsButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void loadMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadMenuItemActionPerformed

    private void createNewInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewInvoiceButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createNewInvoiceButtonActionPerformed

    private void saveItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveItemsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveItemsButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoiceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable InvoicesItemsTable;
    private javax.swing.JTable InvoicesTable;
    private javax.swing.JButton cancelItemsButton;
    private javax.swing.JButton createNewInvoiceButton;
    private javax.swing.JLabel cusName;
    private javax.swing.JButton deleteInvoiceButton;
    private javax.swing.JLabel invDate;
    private javax.swing.JLabel invID;
    private javax.swing.JLabel invTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JButton saveItemsButton;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
    public static SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");

    private InvoiceActionListener actionListener = new InvoiceActionListener(this);
    private ArrayList <InvoiceHeader> invoicesArray;
    private InvoiceSelectionListener selectionListener=new InvoiceSelectionListener(this);
    private InvoiceHeaderTableModel headerTableModel;
    private ArrayList<InvoiceItems>itemsArray;
    


    public void setInvoicesArray(ArrayList<InvoiceHeader> invoicesArray) {
        this.invoicesArray = invoicesArray;
    }

    public ArrayList<InvoiceHeader> getInvoicesArray() {
        return invoicesArray;
    }

    public ArrayList<InvoiceItems> getItemsArray() {
        return itemsArray;
    }

    public void setItemsArray(ArrayList<InvoiceItems> itemsArray) {
        this.itemsArray = itemsArray;
    }
    
    

    
    
    public InvoiceHeader getInvObject(int invId){
    
        for (InvoiceHeader inv:invoicesArray){
        
            if(inv.getNum()==invId){
            
                return inv;
            }
        }
        
        return null;
    }

    public InvoiceHeaderTableModel getHeaderTableModel() {
        return headerTableModel;
    }

    public void setHeaderTableModel(InvoiceHeaderTableModel headerTableModel) {
        this.headerTableModel = headerTableModel;
    }
    
    

    public JTable getInvoicesItemsTable() {
        return InvoicesItemsTable;
    }

    public JTable getInvoicesTable() {
        return InvoicesTable;
    }

    public JLabel getCusName() {
        return cusName;
    }

    public JLabel getInvDate() {
        return invDate;
    }

    public JLabel getInvID() {
        return invID;
    }

    public JLabel getInvTotal() {
        return invTotal;
    }

    public InvoiceActionListener getActionListener() {
        return actionListener;
    }
    
            

}

