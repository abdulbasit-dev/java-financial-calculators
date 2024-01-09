public class RentalYieldReport {
    private final RentalYieldCalculator calculator;

    public RentalYieldReport(RentalYieldCalculator calculator) {
        this.calculator = calculator;
    }

    public void displayRentalYield() {
        System.out.println("Rental Yield: " + calculator.calculate() + "%" );
    }
}
