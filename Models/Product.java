package Models;

public class Product {
    private String productName;
    private String description;
    private String manufacturer;
    private int quantity;
    private double price;

    public Product(String productName, String description, String manufacturer, int quantity, double price) {
        this.productName = productName;
        this.description = description;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.price = price;
    }

    // TODO add editing fields

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}