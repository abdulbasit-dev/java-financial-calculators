import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("MORTGAGE CALCULATOR");
        System.out.println("___________________");
        System.out.println("Please enter the following information: ");

        int principal = (int) readNumber("Principal ($1k - $1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte period = (byte) readNumber("Period (Years): ", 1, 30);

        double mortgage = calculateMortgage(principal,annualInterestRate, period);
        displayMortgage(mortgage);
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
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        double mortgage;

        double monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int  numberOfPayments = period * MONTHS_IN_YEAR;

        mortgage = principal
                * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        return mortgage;
    }

    public static void displayMortgage(double mortgage){
         String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

}

