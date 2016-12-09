// Exercise31_7.java: Display mortgage payments using NumberFormat
import java.util.*;
import java.text.*;
import javax.swing.JOptionPane;

public class Exercise31_7 {
  // Main method
  public static void main(String[] args) {
    double annualInterestRate;
    int numOfYears;
    double loanAmount;

    // Enter yearly interest rate
    String annualIntrestRateString = JOptionPane.showInputDialog(
      null, "Enter yearly interest rate, for example 8.25:",
      "Exercise31_7 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to double
    annualInterestRate =
      Double.parseDouble(annualIntrestRateString);

    // Obtain monthly interest rate
    double monthlyInterestRate = annualInterestRate/1200;

    // Enter number of years
    String numOfYearsString = JOptionPane.showInputDialog(null,
      "Enter number of years as an integer, \nfor example 5:",
      "Exercise31_7 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to int
    numOfYears = Integer.parseInt(numOfYearsString);

    // Enter loan amount
    String loanString = JOptionPane.showInputDialog(null,
      "Enter loan amount, for example 120000.95:",
      "Exercise31_7 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to double
    loanAmount =  Double.parseDouble(loanString);

    // Calculate payment
    double monthlyPayment = loanAmount*monthlyInterestRate/
    (1 - 1/(Math.pow(1 + monthlyInterestRate, numOfYears*12)));
    double totalPayment = monthlyPayment*numOfYears*12;

    NumberFormat currencyForm =
    NumberFormat.getCurrencyInstance();

    // Display results
    System.out.println("The monthly payment is " +
    currencyForm.format(monthlyPayment));
    System.out.println("The total payment is " +
    currencyForm.format(totalPayment));
  }
}
