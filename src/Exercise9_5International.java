public class Exercise9_5International {
  public static void main(String[] args) {
    // Prompt the user to enter a string
    java.util.Scanner input = new java.util.Scanner(System.in);
    System.out.print("Enter a string: ");
    String s = input.nextLine();

    System.out.println("The number of digits in " + s + " is " + 
      count(s));
  }

  public static int count(String s) {
    int count = 0;

    for (int i = 0; i < s.length(); i++) {
      if (Character.isDigit(s.charAt(i))) {
        count++;
      }
    }

    return count;
  }
}