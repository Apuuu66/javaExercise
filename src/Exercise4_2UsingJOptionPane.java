import javax.swing.JOptionPane;

public class Exercise4_2UsingJOptionPane {
  public static void main(String[] args) {
    int correctCount = 0; // Count the number of correct answers
    int count = 0; // Count the number of questions
    long startTime = System.currentTimeMillis();

    while (count < 10) {
      // 1. Generate two random single-digit integers
      int number1 = 1 + (int)(Math.random() * 15);
      int number2 = 1 + (int)(Math.random() * 15);

      // 2. Prompt the student to answer “what is number1 – number2?”
      String answerString = JOptionPane.showInputDialog
        ("What is " + number1 + " + " + number2 + "?");
      int answer = Integer.parseInt(answerString);

      // 3. Grade the annser and display the result
      String replyString;
      if (number1 + number2 == answer) {
        replyString = "You are correct!";
        correctCount++;
      }
      else
        replyString = "Your answer is wrong.\n" + number1 + " + "
          + number2 + " should be " + (number1 + number2);
      JOptionPane.showMessageDialog(null, replyString);

      // Increase the count
      count++;
    }

    long endTime = System.currentTimeMillis();

    JOptionPane.showMessageDialog(null,
      "Correct count is " + correctCount + "\n" +
      "Time spent is " + (endTime - startTime) / 1000 + " seconds");
  }
}
