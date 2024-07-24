
/**
 * This is Super class under name Gadget which has 4 fields storing information about model, price, weigh and size
 * Written by Sandro Zakaidze aka Sandro Iberieli 
 * All That Eye Saw and Witnessed
 */
public class Gadget {
    // Fields to Store information
    private String model;
    private double price;
    private int weight;
    private String size;

    // Constructor of Gadget Class
    public Gadget(String model, double price, int weight, String size) {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    // Accessor Method Get Method returns model
    public String getModel() {
        return model;
    }

    // Accessor Method Get Price returns price
    public double getPrice() {
        return price;
    }

    // Accessor method Get Weight returns weight
    public int getWeight() {
        return weight;
    }

    // Accessor method Get Size returns size
    public String getSize() {
        return size;
    }

    // Get Display method
    public String display() {
        return "Model: " + model + "\nPrice: £" + price + "\nWeight: " + weight + " grams\nSize: " + size;
    }
}
