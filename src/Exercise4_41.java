public class Exercise4_41 {
  public static void main(String[] args) {
    java.util.Scanner input = new java.util.Scanner(System.in);

    // Prompt the user to enter the first number
    System.out.print("Enter an integer: ");
    int number = input.nextInt();
    int max = number;
    int count = 1;

    // Prompt the user to enter the remaining numbers
    while (number != 0) {
      System.out.print("Enter an integer: ");
      number = input.nextInt(); // Read the next number

      if (number > max) {
        max = number;
        count = 1;
      }
      else if (number == max)
        count++;
    }

    System.out.println("max is " + max + "\n" +
      "the occurrence count is " + count);
  }
}