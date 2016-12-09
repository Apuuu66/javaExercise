
// Exercise3_1.java
import javax.swing.JOptionPane;

public class Exercise3_1UsingJOptionPane {
  /**Main method*/
  public static void main(String[] args) {
    // Enter the first edge
    String numberString = JOptionPane.showInputDialog(null,
      "Enter the first edge length (double)",
      "Exercise3_1 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to double
    double edge1 = Double.parseDouble(numberString);

    // Enter the second edge
    numberString = JOptionPane.showInputDialog(null,
      "Enter the second edge length (double)",
      "Exercise3_1 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to double
    double edge2 = Double.parseDouble(numberString);

    // Enter the third edge
    numberString = JOptionPane.showInputDialog(null,
      "Enter the third edge length (double)",
      "Exercise3_1 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to double
    double edge3 = Double.parseDouble(numberString);

    // Display results
    System.out.println("Can edges " + edge1 + ", " + edge2 + ", and "
      + edge3 + " form a triangle? " + (
      (edge1 + edge2 > edge3) && (edge1 + edge3 > edge2) &&
      (edge2 + edge3 > edge1)));
  }
}
