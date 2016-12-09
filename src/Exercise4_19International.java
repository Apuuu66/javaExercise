public class Exercise4_19International {
  public static void main(String[] args) {
    final int NUMBER_OF_LINES = 10;
    int count = 1;
    for (int i = 0; i < NUMBER_OF_LINES; i++) {
      // Pad leading blanks
      for (int j = i; j < NUMBER_OF_LINES - 1; j++)
        System.out.print("    ");

      for (int j = 0; j < 2 * i - 1; j++)
        System.out.printf("%4d", count++);

      System.out.println();
    }
  }
}
