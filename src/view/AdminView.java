package view;

import entity.Product;
import entity.Transaction;
import service.ProductService;
import service.TransactionService;
import utils.PDFGenerator;
import com.itextpdf.text.DocumentException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class AdminView extends javax.swing.JFrame {

    private ProductService productService;
    private TransactionService transactionService;

    public AdminView() {
        productService = new ProductService();
        transactionService = new TransactionService();
        initComponents();
        loadProductTableData();
        loadTransactionTableData();
        loadProductData();
        loadTransactionData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        stockField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        printProductReportButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        transactionTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        productComboBox = new javax.swing.JComboBox<>();
        addTransactionButton = new javax.swing.JButton();
        printTransactionReportButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin");

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Harga", "Stok"
            }
        ));
        jScrollPane1.setViewportView(productTable);
        if (productTable.getColumnModel().getColumnCount() > 0) {
            productTable.getColumnModel().getColumn(0).setPreferredWidth(3);
            productTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Nama:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Harga:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Stok:");

        addButton.setText("Tambah");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Perbarui");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        printProductReportButton.setText("Cetak Laporan");
        printProductReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printProductReportButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Hapus");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(printProductReportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stockField)
                    .addComponent(nameField)
                    .addComponent(priceField, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(stockField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(updateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printProductReportButton)
                    .addComponent(deleteButton))
                .addContainerGap())
        );

        JTabbedPane.addTab("Data Barang", jPanel1);

        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tanggal", "ID", "Produk", "Status", "Jumlah"
            }
        ));
        jScrollPane2.setViewportView(transactionTable);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Produk:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Jumlah");

        productComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        addTransactionButton.setText("Tambah");
        addTransactionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTransactionButtonActionPerformed(evt);
            }
        });

        printTransactionReportButton.setText("Cetak Laporan");
        printTransactionReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printTransactionReportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(addTransactionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printTransactionReportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quantityField)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(productComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addTransactionButton)
                    .addComponent(printTransactionReportButton))
                .addContainerGap())
        );

        JTabbedPane.addTab("Transaksi Masuk", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JTabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printTransactionReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printTransactionReportButtonActionPerformed
        PDFGenerator pdfGenerator = new PDFGenerator();
        try {
            pdfGenerator.generateTransactionOutReport("D:/Laporan Transaksi Masuk.pdf");
            JOptionPane.showMessageDialog(this, "Berhasil mencetak laporan");
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal mencetak laporan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_printTransactionReportButtonActionPerformed

    private void printProductReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printProductReportButtonActionPerformed
        PDFGenerator pdfGenerator = new PDFGenerator();
        try {
            pdfGenerator.generateTransactionOutReport("D:/Laporan Data Barang.pdf");
            JOptionPane.showMessageDialog(this, "Berhasil mencetak laporan");
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Gagal mencetak laporan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_printProductReportButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String name = nameField.getText();
        String priceText = priceField.getText();
        String stockText = stockField.getText();

        if (name.isEmpty() || priceText.isEmpty() || stockText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silahkan isi semua kolom", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        double price;
        int stock;
    
        try {
            price = Double.parseDouble(priceText);
            stock = Integer.parseInt(stockText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for price or stock", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);

        productService.addProduct(product);

        loadProductTableData();

        nameField.setText("");
        priceField.setText("");
        stockField.setText("");
    
        JOptionPane.showMessageDialog(this, "Produk berhasil ditambahkan");
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih produk yang diperbarui", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String name = nameField.getText();
        String priceText = priceField.getText();
        String stockText = stockField.getText();

        if (name.isEmpty() || priceText.isEmpty() || stockText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silahkan isi semua kolom", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double price;
        int stock;

        try {
            price = Double.parseDouble(priceText);
            stock = Integer.parseInt(stockText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for price or stock", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int productId = (int) productTable.getValueAt(selectedRow, 0);

        Product product = new Product();
        product.setId(productId);
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);

        productService.updateProduct(product);

        loadProductTableData();

        nameField.setText("");
        priceField.setText("");
        stockField.setText("");

        JOptionPane.showMessageDialog(this, "Produk berhasil diperbarui");
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih produk yang dihapus", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int productId = (int) productTable.getValueAt(selectedRow, 0);

        productService.deleteProduct(productId);

        loadProductTableData();

        JOptionPane.showMessageDialog(this, "Produk berhasil dihapus");
    }//GEN-LAST:event_deleteButtonActionPerformed

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

    private void loadProductTableData() {
        List<Product> products = productService.getAllProducts();
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        model.setRowCount(0);
        for (Product product : products) {
            model.addRow(new Object[]{product.getId(), product.getName(), product.getPrice(), product.getStock()});
        }
    }

    private void loadTransactionTableData() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        DefaultTableModel model = (DefaultTableModel) transactionTable.getModel();
        model.setRowCount(0);
        for (Transaction transaction : transactions) {
            model.addRow(new Object[]{transaction.getDate(), transaction.getId(), transaction.getProduct().getName(), transaction.getType(), transaction.getQuantity()});
        }
    }
    
    private void loadProductData() {
        List<Product> products = productService.getAllProducts();
        productComboBox.removeAllItems();
        for (Product product : products) {
            productComboBox.addItem(product.getName());
        }
    }
    
    private void loadTransactionData() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        DefaultTableModel model = (DefaultTableModel) transactionTable.getModel();
        model.setRowCount(0);

        for (Transaction transaction : transactions) {
            Object[] row = {
                transaction.getDate(),
                transaction.getId(),
                transaction.getProduct().getName(),
                transaction.getType(),
                transaction.getQuantity()
            };
            model.addRow(row);
        }
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTabbedPane;
    private javax.swing.JButton addButton;
    private javax.swing.JButton addTransactionButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField priceField;
    private javax.swing.JButton printProductReportButton;
    private javax.swing.JButton printTransactionReportButton;
    private javax.swing.JComboBox<String> productComboBox;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField quantityField;
    private javax.swing.JTextField stockField;
    private javax.swing.JTable transactionTable;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
