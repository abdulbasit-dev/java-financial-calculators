# Mortgage Calculator

## Overview

This Java program is a simple Mortgage Calculator that allows users to calculate their mortgage payments based on the principal amount, annual interest rate, and loan period (in years).

## How to Use

1. Clone the repository to your local machine.

```bash
git clone -b mortgage-calculator https://github.com/abdulbasit-dev/java-financial-calculators.git
```

2. Navigate to the project directory.

```bash
cd java-financial-calculators/src
```

3. Compile and run the program.

```bash
javac Main.java
java Main
```

4. Follow the on-screen prompts to enter the required information:

   - Principal amount ($1k - $1M)
   - Annual interest rate (1% - 30%)
   - Loan period in years (1 - 30)

5. The program will then calculate and display the monthly mortgage payment.

```plaintext
.
├── .gitignore
├── README.md
├── src
│   ├── Console.java
│   ├── Main.java
│   ├── MortgageCalculator.java
│   └── MortgageReport.java
└── Types.iml
```

- `.gitignore`: File specifying intentionally untracked files that Git should ignore.
- `README.md`: This file providing information about the project.
- `src/`
  - `Console.java`: Utility class handling user input and validation.
  - `Main.java`: Main program file where the Mortgage Calculator is initiated.
  - `MortgageCalculator.java`: Class responsible for calculating the mortgage based on user input.
  - `MortgageReport.java`: Class generating and displaying the mortgage and payment schedule.


## Contribution

Feel free to contribute to the project by submitting issues or creating pull requests. Your feedback and suggestions are always welcome!

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.