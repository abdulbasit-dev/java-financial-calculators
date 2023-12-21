public class Main {
    public static void main(String[] args) {
        System.out.println("MORTGAGE CALCULATOR");
        System.out.println("___________________");
        System.out.println("Please enter the following information: ");

        int principal = (int) Console.readNumber("Principal ($1k - $1M): ", 1000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte period = (byte) Console.readNumber("Period (Years): ", 1, 30);

        var mortgageCalculator  = new MortgageCalculator(principal, annualInterestRate, period);
        mortgageCalculator.displayMortgage();
        mortgageCalculator.displayPaymentSchedule();
    }


}