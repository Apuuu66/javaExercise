public class Exercise5_13 {
  public static void main(String[] args) {
    System.out.printf("%4s%20s\n", "i", "m(i)");
    for (int i = 1; i <= 20; i++)
      System.out.printf("%4d%20.4f\n", i, m(i));
  }

  public static double m(int n) {
    double sum = 0;

    for (int i = 1; i <= n; i++)
      sum += i * 1.0 / (i + 1);

    return sum;
  }
}
