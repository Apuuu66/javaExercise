// Exercise2_13.java: Create a method for computing future value
import javax.swing.JOptionPane;

public class Exercise2_13UsingJOptionPane {
  public static void main(String[] args) {
    // Enter the investment amount
    String investmentAmountString = JOptionPane.showInputDialog(
      "Enter the investment amount, for example 120000.95:");

    // Convert string to double
    double investmentAmount =  Double.parseDouble(investmentAmountString);

    // Enter yearly interest rate
    String annualIntrestRateString = JOptionPane.showInputDialog(
      "Enter yearly interest rate, for example 8.25:");

    // Convert string to double
    double annualInterestRate =
      Double.parseDouble(annualIntrestRateString);

    // Obtain monthly interest rate
    double monthlyInterestRate = annualInterestRate/1200;

    // Enter number of years
    String numOfYearsString = JOptionPane.showInputDialog(
      "Enter number of years as an integer, \nfor example 5:");

    // Convert string to int
    int numOfYears = Integer.parseInt(numOfYearsString);

    double futureValue =
      investmentAmount * Math.pow(1 + monthlyInterestRate,
      numOfYears * 12);

    System.out.print("Future value is " +
      (int)(futureValue * 100) / 100.0);
  }
}

