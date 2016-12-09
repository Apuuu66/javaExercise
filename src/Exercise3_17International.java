import javax.swing.*;

public class Exercise3_17International {
  public static void main(String[] args) {
    String set1 =
      " 1  3  5  7\n" +
      " 9 11\n";

    String set2 =
      " 2  3  6  7\n" +
      "10 11\n";

    String set3 =
      " 4  5  6  7\n" +
      "12\n";

    String set4 =
      " 8  9 10 11\n" +
      "12\n";

    int date = 0;

    // Prompt the user to answer questions
    int answer = JOptionPane.showConfirmDialog(null,
      "Is your birthdate in these numbers?\n" + set1);

    if (answer == JOptionPane.YES_OPTION)
      date += 1;

    // Prompt the user to answer questions
    answer = JOptionPane.showConfirmDialog(null,
      "Is your birthdate in these numbers?\n" + set2);

    if (answer == JOptionPane.YES_OPTION)
      date += 2;

    // Prompt the user to answer questions
    answer = JOptionPane.showConfirmDialog(null,
      "Is your birthdate in these numbers?\n" + set3);

    if (answer == JOptionPane.YES_OPTION)
      date += 4;

    // Prompt the user to answer questions
    answer = JOptionPane.showConfirmDialog(null,
      "Is your birthdate in these numbers?\n" + set4);

    if (answer == JOptionPane.YES_OPTION)
      date += 8;

    JOptionPane.showMessageDialog(null, 
      "\nYour birth month is " + date + "!");
  }
}