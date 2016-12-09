import javax.swing.JOptionPane;

public class Exercise3_3UsingJOptionPane {
  public static void main(String[] args) {
    // Enter an integer
    String intString = JOptionPane.showInputDialog(
      "Enter an integer: ");

    // Convert string to int
    int number = Integer.parseInt(intString);

    System.out.println("Is " + number + " divisible by 5 and 6? " +
      ((number % 5 == 0) && (number % 6 == 0)));

    System.out.println("Is " + number + " divisible by 5 or 6? " +
      ((number % 5 == 0) || (number % 6 == 0)));

    System.out.println("Is " + number +
      " divisible by 5 or 6, but not both? " +
      ((number % 5 == 0) ^ (number % 6 == 0)));
  }
}
