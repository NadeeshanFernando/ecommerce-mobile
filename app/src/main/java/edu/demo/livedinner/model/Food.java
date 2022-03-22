package edu.demo.livedinner.model;



public class Food {

    private int id;

    private String name;

    private double price;

    private String type;

    private String description;

    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Food(int id, String name, double price, String type, String description, String status) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
        this.status = status;
    }

    public Food(String name, double price, String type, String description, String status) {
        super();
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
        this.status = status;
    }

    public Food() {
        super();
        // TODO Auto-generated constructor stub
    }


    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
