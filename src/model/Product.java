package model;

public class Product {
    private String name;
    private int id;
    private int quantity;
    private float purchasePrice;
    private float sellingPrice;

    // Constructor
    public Product(String name, int id, int quantity, float purchasePrice, float sellingPrice) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void displayInfo() {
        System.out.println("Product Name: " + name);
        System.out.println("Product ID: " + id);
        System.out.println("Quantity: " + quantity);
        System.out.println("Purchase Price: " + purchasePrice);
        System.out.println("Selling Price: " + sellingPrice);
    }

    public float calculateProfit() {
        return sellingPrice - purchasePrice;
    }
}
