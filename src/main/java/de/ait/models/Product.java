package de.ait.models;


public class Product {
    protected String id;
    protected double price;
    protected String title;

    public Product(String id, String title, double price) {
        this.id = id;
        if(title != null) {
            this.title = title;
        } else {
            System.err.println("Введите название книги");
        }
        if (price > 0) {
            this.price = price;
        } else {
            System.err.println("Введите корректную цену");
        }

    }

    public Product() {

    }


    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }
}
