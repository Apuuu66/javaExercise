import javax.swing.*;

public class Exercise5_19UsingJOptionPane {
  /** Main method */
  public static void main(String[] args) {
    // Enter the first edge
    String numberString = JOptionPane.showInputDialog(
      "Enter the first edge length (double)");

    // Convert string to double
    double edge1 = Double.parseDouble(numberString);

    // Enter the second edge
    numberString = JOptionPane.showInputDialog(
      "Enter the second edge length (double)");

    // Convert string to double
    double edge2 = Double.parseDouble(numberString);

    // Enter the third edge
    numberString = JOptionPane.showInputDialog(
      "Enter the third edge length (double)");

    // Convert string to double
    double edge3 = Double.parseDouble(numberString);

    // Display results
    boolean valid = (edge1 + edge2 > edge3) &&
      (edge1 + edge3 > edge2) && (edge2 + edge3 > edge1);

    if (valid) {
      System.out.println("The are of the triangle is " +
        MyTriangle.area(edge1, edge2, edge3));
    }
    else
      System.out.println("Input is invalid");
  }
}
