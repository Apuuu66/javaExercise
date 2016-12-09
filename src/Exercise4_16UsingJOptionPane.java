import javax.swing.JOptionPane;

public class Exercise4_16UsingJOptionPane {
  // Main method
  public static void main(String args[]) {
    // Prompt the user to enter a positive integer
    String intString = JOptionPane.showInputDialog(
      "Enter a positive integer:");

    // Convert string to int
    int number = Integer.parseInt(intString);

    // Find all the smallest factors of the integer
    System.out.println("The factors for " + number + " is");
    int factor = 2;
    while (factor <= number) {
      if (number % factor == 0) {
        number = number / factor;
        System.out.println(factor);
      }
      else {
        factor++;
      }
    }
  }
}
