package model;

import java.util.List;

public class Invoice {
    private int ID;
    private Customer customer;
    private List<Product> products;
    private boolean isPaid;

    // Constructor
    public Invoice(int ID, Customer customer, List<Product> products, boolean isPaid) {
        this.ID = ID;
        this.customer = customer;
        this.products = products;
        this.isPaid = isPaid;
    }

    // Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean isPaid() {
        return isPaid;
    }
}