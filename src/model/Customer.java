package model;

public class Customer {
    private String name;
    private String email;
    private String phoneNumber;

    // Constructor
    public Customer(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Method to display customer information
    public void displayInfo() {
        System.out.println("Customer Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
    }

    
}
