/** Exercise8_1International.java:
 *  Rewrite Example 7.1, "Checking Palindromes," which checks
 *  whether a string is a palindrome. Create your own reverse method.
 *   Do not use the reverse method in the StringBuffer class.
 */
import javax.swing.JOptionPane;

public class Exercise9_1UsingJOptionPane {
  public static void main(String[] args) {
    // Prompt the user to enter a string
    String s = JOptionPane.showInputDialog(null,
      "Enter subtotal:",
      "Exercise8_1International",
      JOptionPane.QUESTION_MESSAGE);

    if (isPalindrome(s)) {
      System.out.println(s + " is a palindrome");
    }
    else {
      System.out.println(s + " is not a palindrome");
    }
  }

  /** Check if a string is a palindrome */
  public static boolean isPalindrome(String s) {
    String newString = reverse(s);

    return newString.equals(s);
  }

  /** Reverse a string */
  public static String reverse(String s) {
    String newString = new String();

    for (int i = 0; i < s.length(); i++) {
      newString += s.charAt(s.length() - 1 - i);

    }
    return newString;
  }

  /* Alternative better solution
     public static String reverse(String s) {
    char[] chars = new char[s.length()];

    for (int i = 0; i < chars.length; i++) {
      chars[i] = s.charAt(s.length() - 1 - i);
    }

    return new String(chars);
     }
   */
}
