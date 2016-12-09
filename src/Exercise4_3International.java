public class Exercise4_3International {
  public static void main(String[] args) {
    int correctCount = 0; // Count the number of correct answers
    int count = 0; // Count the number of questions
    java.util.Scanner input = new java.util.Scanner(System.in);
    long startTime = System.currentTimeMillis();

    System.out.print("How many questions do you want to take? ");
    int numberOfQuestions = input.nextInt();

    while (count < numberOfQuestions) {
      // 1. Generate two random single-digit integers
      int number1 = 2 + (int)(Math.random() * 8);
      int number2 = 2 + (int)(Math.random() * 8);

      // 2. Prompt the student to answer “what is number1 – number2?”
      System.out.print("What is " + number1 + " * " + number2 + "? ");
      int answer = input.nextInt();

      // 3. Grade the annser and display the result
      String replyString;
      if (number1 * number2 == answer) {
        replyString = "You are correct!";
        correctCount++;
      }
      else {
        replyString = "Your answer is wrong.\n" + number1 + " * "
          + number2 + " should be " + (number1 * number2);
      }

      System.out.println(replyString);

      // Increase the count
      count++;
    }

    System.out.println("Correct count is " + correctCount + " out of " +
      numberOfQuestions);
    long endTime = System.currentTimeMillis();
    System.out.println("Time spent is " + (endTime - startTime) / 1000 + " seconds");
  }
}
