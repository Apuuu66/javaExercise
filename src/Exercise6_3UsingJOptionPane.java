// Exercise6_3.java: Enter 10 integers and
// display the numbers in reverse order
import javax.swing.JOptionPane;

public class Exercise6_3UsingJOptionPane {
  public static void main (String[] args) {
    int[] num = new int[10];

    for (int i = 0; i < 10; i++) {
      // Read a number
      String dataString = JOptionPane.showInputDialog(null,
        "Read a number:",
        "Exercise6_3", JOptionPane.QUESTION_MESSAGE);

      num[i] = Integer.parseInt(dataString);
    }

    // Display the array
    for (int i = 9; i >= 0; i--) {
      System.out.println(num[i]);
    }
  }
}

