public class Exercise6_19 {
  public static void main(String[] args) {
    java.util.Scanner input = new java.util.Scanner(System.in);

    // Prompt the user to enter the number of students
    System.out.print("Enter the number of students: ");
    int numberOfStudents = input.nextInt();

    String[] names = new String[numberOfStudents];
    double[] scores = new double[numberOfStudents];

    // Enter student name and score
    for (int i = 0; i < scores.length; i++) {
      System.out.print("Enter a student name: ");
      names[i] = input.next();
      System.out.print("Enter a student score: ");
      scores[i] = input.nextDouble();
    }

    // Sort
    for (int i = scores.length - 1; i >= 1; i--) {
      // Find the maximum in the scores[0..i]
      double currentMax = scores[0];
      int currentMaxIndex = 0;

      for (int j = 1; j <= i; j++) {
        if (currentMax < scores[j]) {
          currentMax = scores[j];
          currentMaxIndex = j;
        }
      }

      // Swap scores[i] with scores[currentMaxIndex] if necessary;
      // Swap names[i] with names[currentMaxIndex] if necessary;
      if (currentMaxIndex != i) {
        scores[currentMaxIndex] = scores[i];
        scores[i] = currentMax;
        String temp = names[currentMaxIndex];
        names[currentMaxIndex] = names[i];
        names[i] = temp;
      }
    }

    // Print names and scores
    for (int i = scores.length - 1; i >= 0; i--) {
      System.out.println(names[i] + "\t" + scores[i]);
    }
  }
}
