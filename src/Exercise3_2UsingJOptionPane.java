/**
 * Title:        Exercise Solutions
 * Description:  Solutions to the exercises for Introduciton to Java Programming with JBuilder 4
 * Copyright:    Copyright (c) 2000
 * Company:      Armstrong Atlantic State University
 * @author Y. Daniel Liang
 * @version 1.0
 */
import javax.swing.JOptionPane;

public class Exercise3_2UsingJOptionPane {
  /**Main method*/
  public static void main(String[] args) {
    // Prompt the user to enter an integer
    String intString = JOptionPane.showInputDialog(null,
      "Enter an integer:",
      "Exercise3_2 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to int
    int number = Integer.parseInt(intString);

    // Display results
    System.out.println("Is " + number + " an even number? " +
      (number % 2 == 0));
  }
}

