import javax.swing.*;

public class Exercise2_3UsingJOptionPane {
  public static void main(String[] args) {
    // Enter foot
    String footString = JOptionPane.showInputDialog(null,
      "Enter foot in integer:",
      "Exercise 2_3 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to int
    int foot =  Integer.parseInt(footString);

    double meter = foot * 0.305;

    System.out.println("It is " + meter + " meters");
  }
}
