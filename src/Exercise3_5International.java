public class Exercise3_5International {
  public static void main(String[] args) {
    java.util.Scanner input = new java.util.Scanner(System.in);

    // Enter an integer
    System.out.print("Enter an integer: ");
    int number = input.nextInt();

    System.out.println("Is " + number + " divisible by 5 and 7? " +
      ((number % 5 == 0) && (number % 7 == 0)));

    System.out.println("Is " + number + " divisible by 5 or 7? " +
      ((number % 5 == 0) || (number % 7 == 0)));

    System.out.println("Is " + number +
      " divisible by 5 or 7, but not both? " +
      ((number % 5 == 0) ^ (number % 7 == 0)));
  }
}
