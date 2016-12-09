public class Exercise9_17RegularExpression {
  /**Main method*/
  public static void main(String[] args) {
    // Prompt the user to enter a string
    java.util.Scanner input = new java.util.Scanner(System.in);
    System.out.print("Enter a string: ");
    String s = input.nextLine();

    String[] tokens = s.split("[.|,|:|\"|\'|?]");

    for (String token : tokens) {
      System.out.println(token);
    }
  }
}
