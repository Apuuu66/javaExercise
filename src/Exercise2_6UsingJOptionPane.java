// Exercise2_6.java: Summarize all digits in an integer < 1000
import javax.swing.JOptionPane;

public class Exercise2_6UsingJOptionPane {
  // Main method
  public static void main(String[] args) {
    // Read a number
    String numberString = JOptionPane.showInputDialog(null,
      "Enter an integer between 0 and 1000:",
      "Exercise2_6", JOptionPane.QUESTION_MESSAGE);

    int number = Integer.parseInt(numberString);

    // Find all digits in number
    int lastDigit = number % 10;
    int remainingNumber = number / 10;
    int secondLastDigit = remainingNumber % 10;
    remainingNumber = remainingNumber / 10;
    int thirdLastDigit = remainingNumber % 10;

    // Obtain the sum of all digits
    int sum = lastDigit + secondLastDigit + thirdLastDigit;

    // Display results
    System.out.println("The sum of all digits in " + number
      + " is " + sum);
  }
}

