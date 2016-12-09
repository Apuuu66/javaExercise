import javax.swing.*;

public class Exercise4_8UsingJOptionPane {
    public static void main(String[] args) {
        // Prompt the user to enter the number of students
        String numOfStudentsString = JOptionPane.showInputDialog("Enter the number of students:");
        int numOfStudents = Integer.parseInt(numOfStudentsString);

        String student1 = JOptionPane.showInputDialog("Enter a student name:");
        double score1 = Integer.parseInt(JOptionPane.showInputDialog("Enter a student score:"));

        for (int i = 0; i < numOfStudents - 1; i++) {
           String student = JOptionPane.showInputDialog("Enter a student name:");
           double score = Integer.parseInt(JOptionPane.showInputDialog("Enter a student score:"));

           if (score > score1) {
               student1 = student;
               score1 = score;
           }
        }

        System.out.println("Top student:");
        System.out.println(student1 + "'s score is " + score1);
    }
}
