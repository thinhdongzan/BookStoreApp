package model;

public class Employee {
    private String name;
    private int id;
    private String position;
    private float salary;

    // Constructor
    public Employee(String name, int id, String position, float salary) {
        this.name = name;
        this.id = id;
        this.position = position;
        this.salary = salary;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    private void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    private void setSalary(float salary) {
        this.salary = salary;
    }

    // Method to display employee information
    public void displayInfo() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Position: " + position);
        System.out.println("Salary: " + salary);
    }

    // Method to update employee information
    public void updateInfo(String name, String position, float salary) {
        setName(name);
        setPosition(position);
        setSalary(salary);
    }
}
