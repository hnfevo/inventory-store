package service;

import entity.Product;
import entity.Transaction;
import utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionService {
    private Connection connection;

    public TransactionService() {
        connection = DatabaseConnection.getConnection();
    }

    public void addTransaction(Transaction transaction) {
        try {
            String query = "INSERT INTO transactions (date, type, product_id, quantity) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, new java.sql.Date(transaction.getDate().getTime()));
            statement.setString(2, transaction.getType());
            statement.setInt(3, transaction.getProduct().getId());
            statement.setInt(4, transaction.getQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try {
            String query = "SELECT t.id, t.date, t.type, t.quantity, p.id AS product_id, p.name AS product_name, p.price AS product_price, p.stock AS product_stock " +
                    "FROM transactions t " +
                    "JOIN products p ON t.product_id = p.id";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(resultSet.getInt("id"));
                transaction.setDate(resultSet.getDate("date"));
                transaction.setType(resultSet.getString("type"));
                transaction.setQuantity(resultSet.getInt("quantity"));

                Product product = new Product();
                product.setId(resultSet.getInt("product_id"));
                product.setName(resultSet.getString("product_name"));
                product.setPrice(resultSet.getDouble("product_price"));
                product.setStock(resultSet.getInt("product_stock"));

                transaction.setProduct(product);
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    public void updateTransaction(Transaction transaction) {
        try {
            String query = "UPDATE transactions SET date = ?, type = ?, product_id = ?, quantity = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, new java.sql.Date(transaction.getDate().getTime()));
            statement.setString(2, transaction.getType());
            statement.setInt(3, transaction.getProduct().getId());
            statement.setInt(4, transaction.getQuantity());
            statement.setInt(5, transaction.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteTransactionsByProductId(int productId) {
        try {
            String query = "DELETE FROM transactions WHERE product_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}