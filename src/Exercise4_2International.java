public class Exercise4_2International {
  public static void main(String[] args) {
    System.out.printf("%10s%10s\n", "inches", "pounds");
    System.out.println("------------------------------");

    int inches = 1;
    for (int i = 1; i <= 100; inches += 2, i++) {
      System.out.printf("%10d%10.2f\n", inches, inches * 2.54);
    }
  }
}
