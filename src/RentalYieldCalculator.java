public class RentalYieldCalculator {
    private static final double MONTHS_IN_YEAR = 12;
    private double propertyPrice;
    private double monthlyRent;

    public RentalYieldCalculator(double totalPropertyPrice, double monthlyRent) {
        setPropertyPrice(totalPropertyPrice);
        setMonthlyRent(monthlyRent);
    }

    public double calculate() {
        double rentalYield = ((monthlyRent * MONTHS_IN_YEAR) / propertyPrice) * 100;
        return Math.round(rentalYield * 100.0) / 100.0;
    }

    private void setPropertyPrice(double propertyPrice) {
        if (propertyPrice <= 0) {
            throw new IllegalArgumentException("Property price must be greater than 0");
        }
        this.propertyPrice = propertyPrice;
    }

    private void setMonthlyRent(double monthlyRent) {
        if (monthlyRent <= 0) {
            throw new IllegalArgumentException("Monthly rent must be greater than 0");
        }

        if (monthlyRent > propertyPrice) {
            throw new IllegalArgumentException("Monthly rent must be less than property price");
        }

        this.monthlyRent = monthlyRent;
    }
}
