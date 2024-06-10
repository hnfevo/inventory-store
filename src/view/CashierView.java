package view;

import entity.Transaction;
import entity.Product;
import service.TransactionService;
import service.ProductService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import utils.DatabaseConnection;

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
        Produk = new javax.swing.JLabel();
        productComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        addTransactionButton = new javax.swing.JButton();
        printTransactionOutReportButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        akun = new javax.swing.JMenu();
        akunDetail = new javax.swing.JMenuItem();
        akunKeluar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kasir");

        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tanggal", "Produk", "Status", "Jumlah"
            }
        ));
        jScrollPane1.setViewportView(transactionTable);

        Produk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Produk.setText("Product:");

        productComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        productComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Jumlah:");
        jLabel2.setAutoscrolls(true);

        quantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityFieldActionPerformed(evt);
            }
        });

        addTransactionButton.setText("Tambah");
        addTransactionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTransactionButtonActionPerformed(evt);
            }
        });

        printTransactionOutReportButton.setText("Cetak");
        printTransactionOutReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printTransactionOutReportButtonActionPerformed(evt);
            }
        });

        akun.setText("Akun");
        akun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akunActionPerformed(evt);
            }
        });

        akunDetail.setText("Detail");
        akunDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akunDetailActionPerformed(evt);
            }
        });
        akun.add(akunDetail);

        akunKeluar.setText("Keluar");
        akunKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akunKeluarActionPerformed(evt);
            }
        });
        akun.add(akunKeluar);

        jMenuBar1.add(akun);

        setJMenuBar(jMenuBar1);

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
                            .addComponent(Produk))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Produk)
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
                transaction.getDate(),
                transaction.getProduct().getName(), // Product
                transaction.getType(), // Type
                transaction.getQuantity() // Quantity
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
        Map map = new HashMap();
        try {
            JasperDesign jasperDesign = JRXmlLoader.load("src/utils/transactionReport.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, DatabaseConnection.getConnection());
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setTitle("Data Barang");
            jasperViewer.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
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

            if (selectedProduct.getStock() < quantity) {
                JOptionPane.showMessageDialog(this, "Stok tidak cukup", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Transaction transaction = new Transaction();
            transaction.setDate(new java.util.Date());
            transaction.setType("out");
            transaction.setProduct(selectedProduct);
            transaction.setQuantity(quantity);

            transactionService.addTransaction(transaction);
            productService.reduceProductStock(selectedProduct.getId(), quantity);
            loadTransactionData();
            loadProductData();

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

    private void akunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_akunActionPerformed

    private void akunDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akunDetailActionPerformed
        UserDetail userDetail = new UserDetail();
        userDetail.setVisible(true);
    }//GEN-LAST:event_akunDetailActionPerformed

    private void akunKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akunKeluarActionPerformed
        this.dispose();
        new LoginView().setVisible(true);
    }//GEN-LAST:event_akunKeluarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CashierView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Produk;
    private javax.swing.JButton addTransactionButton;
    private javax.swing.JMenu akun;
    private javax.swing.JMenuItem akunDetail;
    private javax.swing.JMenuItem akunKeluar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printTransactionOutReportButton;
    private javax.swing.JComboBox<String> productComboBox;
    private javax.swing.JTextField quantityField;
    private javax.swing.JTable transactionTable;
    // End of variables declaration//GEN-END:variables
}
