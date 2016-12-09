// Exercise6_4.java: Analyze scores
import javax.swing.JOptionPane;

public class Exercise6_4UsingJOptionPane {
  // Main method
  public static void main(String[] args) {
    double[] scores = new double[100];
    double sum = 0;
    int count = 0;

    do {
      String scoreString =
        JOptionPane.showInputDialog(null, "Enter a new score");
      scores[count] = Double.parseDouble(scoreString);
      sum += scores[count];
    } while (scores[count++] >= 0);

    double average = (sum - scores[count]) / (count - 1);

    int numOfAbove = 0;
    int numOfBelow = 0;
    for (int i = 0; i < count - 1; i++)
      if (scores[i] >= average)
        numOfAbove++;
      else
        numOfBelow++;

    System.out.println("Average is " + average);
    System.out.println("Number of scores above or equal to the average "
      + numOfAbove);
    System.out.println("Number of scores below the average "
      + numOfBelow);
  }
}
