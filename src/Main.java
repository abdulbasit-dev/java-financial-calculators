import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Mortgage Calculator Project
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.println("MORTGAGE CALCULATOR");
        System.out.println("___________________");
        System.out.println("Please enter the following information: ");

        int principal = getPrincipe(scanner);
        float annualInterestRate = getAnnualInterestRate(scanner);
        byte period = getPeriod(scanner);


        double monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = period * MONTHS_IN_YEAR;

        double mortgage = calculateMortgage(principal,monthlyInterestRate, numberOfPayments);

        displayMortgage(mortgage);
    }

    public static int getPrincipe(Scanner scanner){
        int principal;

        while(true){
            System.out.print("Principal ($1k - $1M): ");
            principal = scanner.nextInt();
            if(principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000");
        }

        return principal;
    }

    public static float getAnnualInterestRate(Scanner scanner){
        float annualInterestRate;

        while(true){
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = scanner.nextFloat();
            if(annualInterestRate >= 1 && annualInterestRate <= 30)
                break;
            System.out.println("Enter a value greater than 0 and less than or equal to 30");
        }

        return annualInterestRate;
    }

    public static byte getPeriod(Scanner scanner){
        byte period;

        while(true){
            System.out.print("Period (Years): ");
            period = scanner.nextByte();
            if(period >= 1 && period <= 30)
                break;
            System.out.println("Enter a value between 1 and 30");
        }

        return period;
    }

    public static double calculateMortgage(int principal, double monthlyInterestRate, int numberOfPayments){
        double mortgage;

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

