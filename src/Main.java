import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        System.out.println("MORTGAGE CALCULATOR");
        System.out.println("___________________");
        System.out.println("Please enter the following information: ");

        int principal = (int) readNumber("Principal ($1k - $1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte period = (byte) readNumber("Period (Years): ", 1, 30);

        displayMortgage(principal, annualInterestRate, period);
        displayPaymentSchedule(principal, annualInterestRate, period);
    }

    public static double readNumber(String prompt, int min, int max){
        Scanner scanner = new Scanner(System.in);
        double value;

        while(true){
            System.out.print(prompt);
            value = scanner.nextInt();
            if(value >= min && value <= max)
                break;

            String minFormatted = NumberFormat.getInstance().format(min);
            String maxFormatted = NumberFormat.getInstance().format(max);
            System.out.println("Enter a number between " + minFormatted + " and " + maxFormatted);
        }

        return value;
    }

    public static double calculateMortgage(int principal, float annualInterestRate , byte period){
        double monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int  numberOfPayments = period * MONTHS_IN_YEAR;

        return principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }

    public static double calculateBalance(int principal, float annualInterestRate , byte period, short numberOfPaymentsMade){
        double monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int  numberOfPayments = period * MONTHS_IN_YEAR;

        return principal
                * (Math.pow(1 + monthlyInterestRate, numberOfPayments) - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
    }

    public static void displayMortgage(int principal, float annualInterestRate, byte period ) {
        double mortgage = calculateMortgage(principal,annualInterestRate, period);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("________");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    public static void displayPaymentSchedule(int principal, float annualInterestRate, byte period ) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("________________");
        for(short month = 1; month <= period * MONTHS_IN_YEAR; month++){
            double balance = calculateBalance(principal, annualInterestRate, period, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}