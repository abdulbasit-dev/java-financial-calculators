import java.text.NumberFormat;

public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private int principal;
    private float annualInterestRate;
    private byte period;

    public MortgageCalculator(int principal, float annualInterestRate, byte period) {
        setPrincipal(principal);
        setAnnualInterestRate(annualInterestRate);
        setPeriod(period);
    }


    private void setPrincipal(int principal) {
        this.principal = principal;
    }

    private void setAnnualInterestRate(float annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    private void setPeriod(byte period) {
        this.period = period;
    }


    public void displayMortgage() {
        double mortgage = calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("________");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    private double calculateMortgage() {
        double monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = period * MONTHS_IN_YEAR;

        return principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }

    public void displayPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("________________");
        for (short month = 1; month <= period * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    private double calculateBalance(short numberOfPaymentsMade) {
        double monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = period * MONTHS_IN_YEAR;

        return principal
                * (Math.pow(1 + monthlyInterestRate, numberOfPayments)
                - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }

}
