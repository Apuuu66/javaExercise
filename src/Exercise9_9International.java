
public class Exercise9_9International {
  public static void main(String[] args) {
    // Prompt the user to enter a string
    java.util.Scanner input = new java.util.Scanner(System.in);
    System.out.print("Enter an integer: ");
    int value = input.nextInt();
    System.out.println("The octal value is " + convertDecimalToOctal(value));
  }

  public static String convertDecimalToOctal(int value) {
    StringBuffer buffer = new StringBuffer();

    while (value != 0) {
      int number = value % 8;
      buffer.insert(0, number);
      value = value / 8;
    }

    return buffer.toString();
  }
}
