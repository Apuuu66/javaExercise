/** Break down an amount into smaller units
 *  Display the non-zero denominations only, and display singular
 *  words for single units like 1 dollars, 1 penny, and display plural
 *  words for more than one unit like 2 dollars, 3 pennies.
 */
import javax.swing.JOptionPane;

public class Exercise3_7UsingJOptionPane {
  // Main method
  public static void main(String[] args) {
    double amount; // Amount entered from the keyboard

    // Receive the amount entered from the keyboard
    String amountString = JOptionPane.showInputDialog(null,
      "Enter an amount in double, for example 11.56",
      "Exercise3_7 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to double
    amount = Double.parseDouble(amountString);

    int remainingAmount = (int)(amount * 100);

    // Find the number of one dollars
    int numOfOneDollars = remainingAmount / 100;
    remainingAmount = remainingAmount % 100;

    // Find the number of quaters in the remaining amount
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
    if (amount < 0) {
       System.out.println("Your amount is negative");
       System.exit(0);
    }
    else if (amount < 0) {
       System.out.println("Your amount is zero");
       System.exit(0);
    }

    System.out.println("Your amount " + amount + " consists of ");

    if (numOfOneDollars > 1)
      System.out.println(numOfOneDollars + "\t dollars");
    else if (numOfOneDollars == 1)
      System.out.println(numOfOneDollars + "\t dollar");

    if (numOfQuarters > 1)
      System.out.println(numOfQuarters + "\t quarters");
    else if (numOfQuarters == 1)
      System.out.println(numOfQuarters + "\t quarter");

    if (numOfDimes > 1)
      System.out.println(numOfDimes + "\t dimes");
    else if (numOfDimes == 1)
      System.out.println(numOfDimes + "\t dime");

    if (numOfNickels > 1)
      System.out.println(numOfNickels + "\t nickels");
    else if (numOfNickels == 1)
      System.out.println(numOfNickels + "\t nickel");

    if (numOfPennies > 1)
      System.out.println(numOfPennies + "\t pennies");
    else if (numOfPennies == 1)
      System.out.println(numOfPennies + "\t pennie");

    System.exit(0);
  }
}
