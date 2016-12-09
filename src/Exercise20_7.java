import javax.swing.JOptionPane;

public class Exercise20_7 {
  static int count = 0;

  /** Main method */
  public static void main(String args[]) {
    // Read the index
    String intString = JOptionPane.showInputDialog(
      "Enter an index for the Fibonacci number:");

    // Convert string into integer
    int index = Integer.parseInt(intString);

    // Find and display the Fibonacci number
    JOptionPane.showMessageDialog(null,
      "Fibonacci number at index " + index + " is " + fib(index));

    System.out.println("Number of times fib is invoked? " + count);
  }

  /** The method for finding the Fibonacci number */
  public static long fib(long index) {
    count++;

    if (index == 0) // Base case
      return 0;
    else if (index == 1) // Base case
      return 1;
    else  // Reduction and recursive calls
      return fib(index - 1) + fib(index - 2);
  }
}
