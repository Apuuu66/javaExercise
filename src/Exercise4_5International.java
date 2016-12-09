public class Exercise4_5International {
  public static void main(String[] args) {
    int correctCount = 0; // Count the number of correct answers
    int count = 0; // Count the number of questions
    java.util.Scanner input = new java.util.Scanner(System.in);
    long startTime = System.currentTimeMillis();

    int numberOfQuestions = 5;

    while (count < numberOfQuestions) {
      // 1. Generate three random integers between 20 and 90
      int number1 = 20 + (int)(Math.random() * 71);
      int number2 = 20 + (int)(Math.random() * 71);
      int number3 = 20 + (int)(Math.random() * 71);

      // 2. Prompt the student to answer “what is number1 + number2 + number3?”
      System.out.print("What is " + number1 + " + " + number2 
        + " + " + number3 + "? ");
      int answer = input.nextInt();

      // 3. Grade the annser and display the result
      String replyString;
      if (number1 + number2 + number3 == answer) {
        replyString = "You are correct!";
        correctCount++;
      }
      else {
        replyString = "Your answer is wrong.\n" + number1 + " + "
          + number2 + " + " + number3 + " should be " + 
          (number1 + number2 + number3);
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
