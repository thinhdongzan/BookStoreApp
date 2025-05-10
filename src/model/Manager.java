package model;

public class Manager extends Employee {
    private String username;
    private String password;


    // Constructor đầy đủ
   public Manager(int id, String name, String email, String phoneNumber, double salary, String username, String password) {
        super(id, name, email, phoneNumber, salary);
        this.username = username;
        this.password = password;
    }

    // Getter và Setter cho username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter và Setter cho password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
