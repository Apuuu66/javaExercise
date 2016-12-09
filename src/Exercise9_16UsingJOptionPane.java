import java.util.*;

import javax.swing.JOptionPane;

public class Exercise9_16UsingJOptionPane {
  /**Main method*/
  public static void main(String[] args) {
    // Receive the amount entered from the dialog box
    String amountString = JOptionPane.showInputDialog(null,
      "Enter an amount in double, for example 11.56:",
      "Exercise8_13 Input", JOptionPane.QUESTION_MESSAGE);

    String[] elements = amountString.split("[.|\n|\r|\t]");
    int dollars = 0;
    if (elements[0].length() > 0)
      dollars = Integer.parseInt(elements[0]);

    int remainingAmount = 0;
    int cents = 0;

    if (elements.length > 1)
      remainingAmount = cents = Integer.parseInt(elements[1]);

    remainingAmount = remainingAmount % 100;

    // Find the number of quarters in the remaining amount
    int numOfQuarters = remainingAmount / 25;
    remainingAmount = remainingAmount % 25;

    // Find the number of dimes in the remaining amount
    int numOfDimes = remainingAmount / 10;
    remainingAmount = remainingAmount % 10;

    // Find the number of nickels in the remaining amount
    int numOfNickels = remainingAmount / 5;
    remainingAmount = remainingAmount % 5;

    // Find the number of pennies in the remaining amount
    int numOfPennies = remainingAmount;

    // Display results
    System.out.println("Your amount " + amountString + " consists of ");
    System.out.println(dollars + "\t dollars");
    System.out.println(numOfQuarters + "\t quarters");
    System.out.println(numOfDimes + "\t dimes");
    System.out.println(numOfNickels + "\t nickels");
    System.out.println(numOfPennies + "\t pennies");
  }
}
