// Exercise5_1.java:
public class Exercise5_1 {
  public static void main(String[] args) {
    for (int i = 1; i <= 100; i++)
      if (i % 10 == 0)
        System.out.println(getPentagonalNumber(i));
      else
        System.out.printf("%10d", getPentagonalNumber(i));        
  }

  public static int getPentagonalNumber(int n) {
    return n * (3 * n - 1) / 2;
  }
}