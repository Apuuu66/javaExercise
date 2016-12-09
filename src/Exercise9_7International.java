public class Exercise9_7International {
  public static void main(String[] args) {
    // Prompt the user to enter a string
    java.util.Scanner input = new java.util.Scanner(System.in);
    System.out.print("Enter an octal string: ");
    String s = input.nextLine();

    System.out.println("The decimal value is " + parseOctal(s));
  }

  public static int parseOctal(String octalString) {
    int value = Integer.parseInt(octalString.charAt(0) + "");
    for (int i = 1; i < octalString.length(); i++) {
      value = value * 8 + octalString.charAt(i) - '0';
    }

    return value;
  }
}
