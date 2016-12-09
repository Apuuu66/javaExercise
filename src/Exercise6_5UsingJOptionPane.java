import javax.swing.*;

public class Exercise6_5UsingJOptionPane {
  public static void main(String[] args) {
    int[] numbers = new int[10];
    int size = 0;

    for (int i = 0; i < numbers.length; i++) {
      // Read and store numbers in an array if it is new
      String s = JOptionPane.showInputDialog(null, "Enter an integer");
      int value = Integer.parseInt(s);

      boolean isInArray = false;

      for (int j = 0; j < size; j++)
        if (numbers[j] == value) {
          isInArray = true;
          break;
        }

      if (!isInArray) {
        numbers[size] = value;
        size++;
      }
    }

    for (int i = 0; i < size; i++)
      System.out.print(numbers[i] + " ");
  }
}
