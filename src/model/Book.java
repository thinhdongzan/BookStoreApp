package model;

public class Book extends Product {
    private String author;
    private String publisher;
    private String ISBN;

    // Constructor
    public Book(String name, int id, int quantity, float purchasePrice, float sellingPrice, String author,
            String publisher, String ISBN) {
        super(name, id, quantity, purchasePrice, sellingPrice);
        this.author = author;
        this.publisher = publisher;
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
        System.out.println("ISBN: " + ISBN);
    }

}
