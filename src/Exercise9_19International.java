import java.util.*;
import java.io.*;

public class Exercise9_19International {
  public static void main(String[] args) throws Exception {
    // Check command-line arguments
    if (args.length < 1) {
      System.out.println(
        "Usage: java Exercise9_19International filename");
      System.exit(0);
    }

    // Read the characters in the file to a string
    StringBuilder builder = new StringBuilder();
  
    Scanner input = new Scanner(new File(args[0]));
    while (input.hasNext()) {
      builder.append(input.nextLine());
    }
    
    // Invoke the countLetters method to count each letter
    int[] counts = countLetters(builder.toString().toLowerCase());

    // Display results
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] != 0)
        System.out.println((char)('a' + i) + " appears  " +
          counts[i] + ((counts[i] == 1) ? " time" : " times"));
    }
  }

  /** Count each letter in the string */
  public static int[] countLetters(String s) {
    int[] counts = new int[26];

    for (int i = 0; i < s.length(); i++) {
      if (Character.isLetter(s.charAt(i)))
        counts[s.charAt(i) - 'a']++;
    }

    return counts;
  }
}