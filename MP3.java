
/**
 * MP3 class that extends Gadget
 */
public class MP3 extends Gadget {
    // Field storing available memory
    private double memory;

    // Constructor of MP3 class
    public MP3(String model, double price, int weight, String size, double memory) {
        super(model, price, weight, size);
        this.memory = memory;
    }

    // Get method to return available memory
    public double getMemory() {
        return memory;
    }

    // Method to download music
    public void downloadMusic(double amount) {
        if (memory >= amount) {
            memory -= amount;
            System.out.println("Starting to download your files, please wait!");
            System.out.println("File successfully downloaded!");
        } else {
            System.out.println("You do not have enough available memory to download the desired file");
            System.out.println("Please increase the amount of memory to download the desired file");
        }
    }

    // Enhanced display method for MP3 class
    @Override
    public String display() {
        return super.display() + "\nAvailable Memory: " + memory + " MB";
    }
}
