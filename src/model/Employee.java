package model;

public class Employee {
    private final int id;
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final double salary;
    
    

    // Constructor đầy đủ
    public Employee(int id, String name, String email, String phoneNumber,  double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary; 
    }

    // Getter và Setter cho id
    public int getId() {
        return id;
    }

    // Getter và Setter cho name
    public String getName() {
        return name;
    }

    // Getter và Setter cho salary
    public double getSalary() {
        return salary;
    }

    // Getter và Setter cho phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Getter và Setter cho email
    public String getEmail() {
        return email;
    }

}

