package model;

public class Toy extends Product {
    private String brand;
    private int suitableAge;

    // Constructor
    public Toy(String name, int id, int quantity, float purchasePrice, float sellingPrice, String brand,
            int suitableAge) {
        super(name, id, quantity, purchasePrice, sellingPrice);
        this.brand = brand;
        this.suitableAge = suitableAge;
    }

    // Getters and Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSuitableAge() {
        return suitableAge;
    }

    public void setSuitableAge(int suitableAge) {
        this.suitableAge = suitableAge;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Brand: " + brand);
        System.out.println("Suitable Age: " + suitableAge + " years");
    }
}
