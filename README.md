# Rental Yield Calculator

## Overview

This Java program is a Rental Yield Calculator designed to help users assess the potential return on investment for a property. Users can calculate the rental yield based on the property's price and the monthly rent.

## How to Use

1. Clone the repository to your local machine and switch to the Rental Yield Calculator branch.

```bash
git clone -b rental-yield-calculator https://github.com/abdulbasit-dev/java-mortgage-calculator.git
```

2. Navigate to the project directory.

```bash
cd java-mortgage-calculator/src
```

3. Compile and run the program.

```bash
javac Main.java
java Main
```

4. Follow the on-screen prompts to enter the required information:

   - Property Price
   - Monthly Rent

5. The program will then calculate and display the rental yield percentage.

## File Structure

```plaintext
.
├── .gitignore
├── README.md
├── src
│   ├── Console.java
│   ├── Main.java
│   ├── RentalYieldCalculator.java
│   └── RentalYieldReport.java
└── Types.iml
```

- `.gitignore`: File specifying intentionally untracked files that Git should ignore.
- `README.md`: This file providing information about the project.
- `src/`
  - `Console.java`: Utility class handling user input and validation.
  - `Main.java`: Main program file where the Rental Yield Calculator is initiated.
  - `RentalYieldCalculator.java`: Class responsible for calculating the rental yield based on user input.
  - `RentalYieldReport.java`: Class generating and displaying the rental yield report.


## Contribution

Feel free to contribute to the project by submitting issues or creating pull requests. Your feedback and suggestions are always welcome!

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
