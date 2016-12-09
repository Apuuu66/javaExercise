import javax.swing.*;

public class Exercise10_5UsingJOptionPane {
  public static void main(String[] args) {
    StackOfIntegers stack = new StackOfIntegers(2);

    // Prompt the user to enter an integer
    String intString = JOptionPane.showInputDialog(null,
      "Enter an integer:",
      "Exercise9_5 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string to int
    int number = Integer.parseInt(intString);
    System.out.println("The factors for " + number + " is");

    // Find and store all the smallest factors of the integer
    int factor = 2;
    while (factor <= number) {
      if (number % factor == 0) {
        number = number / factor;
        stack.push(factor);
      }
      else {
        factor++;
      }
    }

    // Display factors
    while (!stack.empty()) {
      System.out.print(stack.pop() + " ");
    }
  }
}
