import javax.swing.*;

public class Exercise6_31International {
  public static void main(String[] args) {
    // Enter two integers
    int number1 = Integer.parseInt(
      JOptionPane.showInputDialog("Enter an integer"));

    int number2 = Integer.parseInt(
      JOptionPane.showInputDialog("Enter an integer"));

    JOptionPane.showMessageDialog(null, "The LCM for " +
                                  number1 + " and " + number2 + " is " +
                                  lcm(number1, number2));
  }

  public static int lcm(int number1, int number2) {
    int[][] table1 = getPrimeFactors(number1);
    int[][] table2 = getPrimeFactors(number2);
    int result = 1;

    int i = 0;
    int j = 0;
    while (i < table1.length && j < table2.length) {
      if (table1[i][0] < table2[j][0]) {
        result *= pow(table1[i][0], table1[i][1]);
        i++;
      }
      else if (table1[i][0] == table2[j][0]) {
        result *= pow(table1[i][0],
                      Math.max(table1[i][1], table2[j][1]));
        i++;
        j++;
      }
      else {
        result *= pow(table2[j][0], table2[j][1]);
        j++;
      }
    }

    while (i < table1.length) {
      result *= pow(table1[i][0], table1[i][1]);
      i++;
    }

    while (j < table2.length) {
      result *= pow(table2[j][0], table2[j][1]);
      j++;
    }

    return result;
  }

  public static int pow(int a, int b) {
    int result = 1;
    for (int i = 1; i <= b; i++)
      result *= a;
    return result;
  }
  public static int[][] getPrimeFactors(int number) {
    int[][] table = new int[100][2];
    int i = 0;
    int factor = 2;
    while (factor <= number) {
      if (number % factor == 0) {
        table[i][0] = factor;
        while (number % factor == 0) {
          number = number / factor;
          table[i][1]++;
        }
        i++;
      }
      else {
        factor++;
      }
    }

    if (i == 0)
      return null;
    else {
      int[][] result = new int[i][2];
      for (int k = 0; k < result.length; k++)
        for (int j = 0; j < result[0].length; j++)
          result[k][j] = table[k][j];
      return result;
    }
  }
}
