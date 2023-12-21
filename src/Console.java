import java.text.NumberFormat;
import java.util.Scanner;

public class Console {
    private final Scanner scanner;

    public Console() {
        this.scanner = new Scanner(System.in);
    }

    public double readNumber(String prompt, int min, int max) {
        double value;

        while (true) {
            System.out.print(prompt);
            value = scanner.nextInt();
            if (value >= min && value <= max)
                break;

            String minFormatted = NumberFormat.getInstance().format(min);
            String maxFormatted = NumberFormat.getInstance().format(max);
            System.out.println("Enter a number between " + minFormatted + " and " + maxFormatted);
        }

        return value;
    }

    public void closeScanner() {
        scanner.close();
    }

}
