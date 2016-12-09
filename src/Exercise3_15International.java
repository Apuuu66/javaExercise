import java.util.Scanner;

public class Exercise3_15International {
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

    // Create a Scanner
    Scanner input = new Scanner(System.in);

    // Prompt the user to answer questions
    System.out.print("Is your birth month in Set1?\n");
    System.out.print(set1);
    System.out.print("\nEnter 0 for No and 1 for Yes: ");
    int answer = input.nextInt();

    if (answer == 1)
      date += 1;

    // Prompt the user to answer questions
    System.out.print("\nIs your birth month in Set2?\n");
    System.out.print(set2);
    System.out.print("\nEnter 0 for No and 1 for Yes: ");
    answer = input.nextInt();

    if (answer == 1)
      date += 2;

    // Prompt the user to answer questions
    System.out.print("Is your birth month in Set3?\n");
    System.out.print(set3);
    System.out.print("\nEnter 0 for No and 1 for Yes: ");
    answer = input.nextInt();

    if (answer == 1)
      date += 4;

    // Prompt the user to answer questions
    System.out.print("\nIs your birth month in Set4?\n");
    System.out.print(set4);
    System.out.print("\nEnter 0 for No and 1 for Yes: ");
    answer = input.nextInt();

    if (answer == 1)
      date += 8;

    System.out.println("\nYour birth month is " + date + "!");
  }
}
