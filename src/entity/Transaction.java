package entity;

import java.util.Date;

public class Transaction {
    private int id;
    private Date date;
    private String type; // "in" or "out"
    private Product product;
    private int quantity;

    // Constructor
    public Transaction() {
    }

    public Transaction(int id, Date date, String type, Product product, int quantity) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.product = product;
        this.quantity = quantity;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
