package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import service.ProductService;
import service.TransactionService;
import service.UserService;

public class DatabaseConnection {

    private static Connection connection;
    private static ProductService productService;
    private static TransactionService transactionService;
    private static UserService userService;

    public static ProductService getProductService() {
        if (productService == null) {
            productService = new ProductService();
        }
        return productService;
    }

    public static TransactionService getTransactionService() {
        if (transactionService == null) {
            transactionService = new TransactionService();
        }
        return transactionService;
    }

    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorydb", "root", "");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
