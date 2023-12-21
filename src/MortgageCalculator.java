public class MortgageCalculator {
    public final static byte MONTHS_IN_YEAR = 12;
    public final static byte PERCENT = 100;

    private final int principal;
    private final float annualInterestRate;
    private final byte period;

    public MortgageCalculator(int principal, float annualInterestRate, byte period) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.period = period;
    }

    public byte getPeriod() {
        return period;
    }

    public double calculateMortgage() {
        double monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = period * MONTHS_IN_YEAR;

        return principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }


    public double calculateBalance(short numberOfPaymentsMade) {
        double monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = period * MONTHS_IN_YEAR;

        return principal
                * (Math.pow(1 + monthlyInterestRate, numberOfPayments)
                - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }
}
