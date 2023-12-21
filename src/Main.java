import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        System.out.println("MORTGAGE CALCULATOR");
        System.out.println("___________________");
        System.out.println("Please enter the following information: ");

        var console = new Console();
        int principal = (int) console.readNumber("Principal ($1k - $1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) console.readNumber("Annual Interest Rate: ", 1, 30);
        byte period = (byte) console.readNumber("Period (Years): ", 1, 30);
        console.closeScanner();

        var mortgageCalculator  = new MortgageCalculator(principal, annualInterestRate, period);
        mortgageCalculator.displayMortgage();
        mortgageCalculator.displayPaymentSchedule();

    }


}