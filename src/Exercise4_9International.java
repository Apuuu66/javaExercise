import java.util.Scanner;

public class Exercise4_9International {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter the number of students
    System.out.print("Enter the number of students: ");
    int numOfStudents = input.nextInt();

    System.out.print("Enter a student score: ");
    double score1 = input.nextDouble();

    System.out.print("Enter a student score: ");
    double score2 = input.nextDouble();

    if (score1 < score2) {
      double tempScore = score1;
      score1 = score2;
      score2 = tempScore;
    }

    System.out.print("Enter a student score: ");
    double score3 = input.nextDouble();
    
    if (score3 < score1) {
      if (score3 < score2) {
        double tempScore = score2;
        score2 = score3;
        score3 = tempScore;
      }
    } 
    else {
      double tempScore = score3;
      score3 = score2;
      score2 = score1;
      score1 = tempScore;     
    }
    
    for (int i = 0; i < numOfStudents - 3; i++) {
      System.out.print("Enter a student score: ");
      double score = input.nextDouble();

      if (score > score1) {
        score3 = score2;
        score2 = score1;
        score1 = score;
      }
      else if (score > score2) {
        score3 = score2;
        score2 = score;
      }
      else if (score > score3) {
        score3 = score;
      }
    }

    System.out.println("Top three student scores: "  +
      score1 + " " + score2 + " " + score3);
  }
}
