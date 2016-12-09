import javax.swing.JOptionPane;

public class Exercise4_1UsingJOptionPane {
  public static void main(String[] args) {
    int countPositive=0, countNegative = 0;
    int count = 0, total = 0, num;

    do {
      // Read the next data
      String dataString = JOptionPane.showInputDialog(
        "Enter an int value, \nthe program exits if the input is 0");

      num = Integer.parseInt(dataString);

      if (num > 0)
        countPositive++;
      else if (num < 0)
        countNegative++;

      total += num;
      count++;
    }
    while (num != 0);

    // Adjust count
    count--;

    if (count == 0)
      System.out.println("You didn't enter any number");
    else {
      System.out.println("the number of postives is " + countPositive);
      System.out.println("the number of negatives is " + countNegative);
      System.out.println("the total is " + total);
      System.out.println("the average is " + total * 1.0 / count);
    }
  }
}
