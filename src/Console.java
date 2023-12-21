import java.text.NumberFormat;
import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt) {
        return scanner.nextDouble();
    }

    public static double readNumber(String prompt, int min, int max) {
        double value;

        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;

            String minFormatted = NumberFormat.getInstance().format(min);
            String maxFormatted = NumberFormat.getInstance().format(max);
            System.out.println("Enter a number between " + minFormatted + " and " + maxFormatted);
        }

        return value;
    }
}
