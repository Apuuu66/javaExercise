import javax.swing.JOptionPane;

public class Exercise6_2UsingJOptionPane {
  public static void main(String[] args) {
    // Prompt the user to enter the first number
    String numberString = JOptionPane.showInputDialog(null,
      "Enter an integer");
    int max = Integer.parseInt(numberString);
    int count = 1;
    String inputNumbers = max + " ";

    // Prompt the user to enter the remaining five numbers
    for (int i = 1; i <= 5; i++) {
      numberString = JOptionPane.showInputDialog(null,
        "Enter an integer");
      int temp = Integer.parseInt(numberString);
      inputNumbers += temp + " ";

      if (temp > max) {
        max = temp;
        count = 1;
      }
      else if (temp == max)
        count++;
    }

    JOptionPane.showMessageDialog(null,
      "The array is: " + inputNumbers + "\n" +
      "max is " + max + "\n" +
      "the occurrence count is " + count);
  }
}
