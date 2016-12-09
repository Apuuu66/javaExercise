public class Exercise4_11International {
  public static void main(String[] args) {
    int count = 1;
    for (int i = 100; i <= 200; i++)
      if (i % 5 == 0 ^ i % 7 == 0)
        System.out.print((count++ % 10 != 0) ? i + " ": i + "\n");
  }
}
