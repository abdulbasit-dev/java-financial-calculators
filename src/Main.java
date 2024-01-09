public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Rental Yield Calculator!");
        System.out.println("___________________");
        System.out.println("Please enter the following information: ");

        double propertyPrice = Console.readNumber("Enter Property price: ");
        double monthlyRent = Console.readNumber("Enter Monthly rent: ");

        var rentalYieldCalculator = new RentalYieldCalculator(propertyPrice, monthlyRent);
        var rentalYieldReport = new RentalYieldReport(rentalYieldCalculator);
        rentalYieldReport.displayRentalYield();
    }
}