import javax.swing.*;

public class Exercise4_9UsingJOptionPane {
  public static void main(String[] args) {
    // Prompt the user to enter the number of students
    String numOfStudentsString = JOptionPane.showInputDialog("Enter the number of students:");
    int numOfStudents = Integer.parseInt(numOfStudentsString);

    String student1 = JOptionPane.showInputDialog("Enter a student name:");
    double score1 = Integer.parseInt(JOptionPane.showInputDialog("Enter a student score:"));

    String student2 = JOptionPane.showInputDialog("Enter a student name:");
    double score2 = Integer.parseInt(JOptionPane.showInputDialog("Enter a student score:"));

    if (score1 < score2) {
      // Swap
      String tempString = student1;
      double tempScore = score1;

      student1 = student2;
      score1 = score2;

      student2 = tempString;
      score2 = tempScore;
    }

    for (int i = 0; i < numOfStudents - 2; i++) {
      String student = JOptionPane.showInputDialog("Enter a student name:");
      double score = Integer.parseInt(JOptionPane.showInputDialog("Enter a student score:"));

      if (score > score1) {
        student2 = student1;
        score2 = score1;

        student1 = student;
        score1 = score;
      }
      else if (score > score2) {
        student2 = student;
        score2 = score;
      }
    }

    System.out.println("Top two students:");
    System.out.println(student1 + "'s score is " + score1);
    System.out.println(student2 + "'s score is " + score2);
  }
}
