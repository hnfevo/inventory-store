package view;

import entity.Transaction;
import entity.Product;
import service.TransactionService;
import service.ProductService;
import utils.PDFGenerator;
import com.itextpdf.text.DocumentException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.List;

public class CashierView extends javax.swing.JFrame {

    private TransactionService transactionService;
    private ProductService productService;
    
    public CashierView() {
        transactionService = new TransactionService();
        productService = new ProductService();
        initComponents();
        loadTransactionData();
        loadProductData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        transactionTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        productComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        addTransactionButton = new javax.swing.JButton();
        printTransactionOutReportButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kasir");

        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Date", "Type", "Product", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(transactionTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Product:");

        productComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        productComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Quantity:");
        jLabel2.setAutoscrolls(true);

        quantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityFieldActionPerformed(evt);
            }
        });

        addTransactionButton.setText("Add Transaction");
        addTransactionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTransactionButtonActionPerformed(evt);
            }
        });

        printTransactionOutReportButton.setText("Print Transaction Out Report");
        printTransactionOutReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printTransactionOutReportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addComponent(printTransactionOutReportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addTransactionButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quantityField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addTransactionButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printTransactionOutReportButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadTransactionData() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        DefaultTableModel model = (DefaultTableModel) transactionTable.getModel();
        model.setRowCount(0);

        for (Transaction transaction : transactions) {
            Object[] row = {
                transaction.getId(),
                transaction.getDate(),
                transaction.getType(),
                transaction.getProduct().getName(),
                transaction.getQuantity()
            };
            model.addRow(row);
        }
    }
    
    private void loadProductData() {
        List<Product> products = productService.getAllProducts();
        productComboBox.removeAllItems();
        for (Product product : products) {
            productComboBox.addItem(product.getName());
        }
    }
    
    private void printTransactionOutReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printTransactionOutReportButtonActionPerformed
        PDFGenerator pdfGenerator = new PDFGenerator();
        try {
            pdfGenerator.generateTransactionOutReport("D:/Laporan Transaksi Keluar.pdf");
            JOptionPane.showMessageDialog(this, "Berhasil mencetak laporan");
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal mencetak laporan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_printTransactionOutReportButtonActionPerformed

    private void addTransactionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTransactionButtonActionPerformed
        try {
            String selectedProductName = (String) productComboBox.getSelectedItem();
            if (selectedProductName == null) {
                JOptionPane.showMessageDialog(this, "Pilih produk", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int quantity = Integer.parseInt(quantityField.getText());
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(this, "Quantity must be a positive number", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Product selectedProduct = productService.getAllProducts().stream()
                .filter(p -> p.getName().equals(selectedProductName))
                .findFirst()
                .orElse(null);

            if (selectedProduct == null) {
                JOptionPane.showMessageDialog(this, "Produk yang dipilih tidak ada", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Transaction transaction = new Transaction();
            transaction.setDate(new java.util.Date());
            transaction.setType("out");
            transaction.setProduct(selectedProduct);
            transaction.setQuantity(quantity);

            transactionService.addTransaction(transaction);
            loadTransactionData();

            // Clear input fields
            quantityField.setText("");
            productComboBox.setSelectedIndex(0);

            JOptionPane.showMessageDialog(this, "Transaksi berhasil ditambahkan");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid quantity", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addTransactionButtonActionPerformed

    private void quantityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityFieldActionPerformed
        addTransactionButtonActionPerformed(evt);
    }//GEN-LAST:event_quantityFieldActionPerformed

    private void productComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productComboBoxActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CashierView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTransactionButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printTransactionOutReportButton;
    private javax.swing.JComboBox<String> productComboBox;
    private javax.swing.JTextField quantityField;
    private javax.swing.JTable transactionTable;
    // End of variables declaration//GEN-END:variables
}
