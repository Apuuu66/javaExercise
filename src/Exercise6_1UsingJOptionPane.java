import javax.swing.*;

public class Exercise6_1UsingJOptionPane {
  public static void main(String[] args) {
    double[] numbers = new double[10];
    double sum = 0;

    for (int i = 0; i < numbers.length; i++) {
      String s = JOptionPane.showInputDialog("Enter a number: ");
      numbers[i] = Double.parseDouble(s);
      sum += numbers[i];
    }

    double average = sum / 10;
    int countGreater = 0;

    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] > average)
       countGreater++;
    }

    System.out.println("The number of values greater than the average is " + countGreater);
  }
}
