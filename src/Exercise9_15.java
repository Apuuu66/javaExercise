public class Exercise9_15 {
  public static void main(String[] args) {
    // Check command-line arguments
    if (args.length != 1) {
      System.out.println(
        "Usage: java Exercise9_15 string");
      System.exit(0);
    }

    String s = args[0];
    int total = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
        total++;
    }

    System.out.println("The number of uppercase letters is " +
      total);
  }
}