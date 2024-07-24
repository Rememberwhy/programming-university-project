/**
 * Mobile class that extends Gadget
 */
public class Mobile extends Gadget {
    // Field storing information for remaining credit
    private int callingCreditRemaining;

    // Constructor of Mobile class
    public Mobile(String model, double price, int weight, String size, int callingCreditRemaining) {
        super(model, price, weight, size);
        this.callingCreditRemaining = callingCreditRemaining;
    }

    // Get method to return remaining amount of credit
    public int getCredit() {
        return callingCreditRemaining;
    }

    // Method to insert credit
    public void insertCredit(int amount) {
        if (amount > 0) {
            callingCreditRemaining += amount; // This adds inserted amount to remaining amount
        } else {
            System.out.println("Please add a positive amount of credit!"); // This is printed if user inserts less than zero
        }
    }

    // Method to make phone call
    public void makePhoneCall(String phoneNumber, int durationOfCall) {
        if (callingCreditRemaining >= durationOfCall) {
            System.out.println("Provided number: " + phoneNumber + "\nProvided duration of call: " + durationOfCall); // Prints out number which user provided and duration of call
            callingCreditRemaining -= durationOfCall; // If sufficient amount of credit is in the system call is performed and remaining credit amount is decreased by duration of call performed
        } else {
            System.out.println("There is insufficient credit in the system, Please add the required amount to perform a phone call"); // Prints out information that credit in the system is not enough
            int requiredAmount = durationOfCall - callingCreditRemaining; // Local variable to calculate required amount for call to be performed
            System.out.println("Required amount of credits to be added: " + requiredAmount); // Required amount of credit is displayed to user
        }
    }

    // Enhanced display method for Mobile class
    @Override
    public String display() {
        return super.display() + "\nRemaining Credit: " + callingCreditRemaining + " minutes";
    }
}

