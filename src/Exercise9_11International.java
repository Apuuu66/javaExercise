public class Exercise9_11International {
  public static void main(String args[]) {
    // Prompt the user to enter a string
    java.util.Scanner input = new java.util.Scanner(System.in);
    System.out.print("Enter a string: ");
    String s = input.nextLine();
    System.out.println("Shuffled string is " + shuffle(s));
  }
  
  public static String shuffle(String s) {
    StringBuilder result = new StringBuilder();
    
    for (int i = 0; i < s.length(); i++) {
      int index = (int)(Math.random() * s.length());
      result.append(s.charAt(index));
    }
    
    return result.toString();
  }
}

