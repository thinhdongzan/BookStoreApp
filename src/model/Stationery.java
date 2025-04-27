package model;

public class Stationery extends Product {
    private String brand;
    private String type;

    // Constructor
    public Stationery(String name, int id, int quantity, float purchasePrice, float sellingPrice, String brand,
            String type) {
        super(name, id, quantity, purchasePrice, sellingPrice);
        this.brand = brand;
        this.type = type;
    }

    // Getters and Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Brand: " + brand);
        System.out.println("Type: " + type);
    }
}
