public class Exercise20_11 {
  public static void main(String[] args) {
    System.out.println(sumDigits(12));
  }

  public static int sumDigits(long n) {
    int result = 0;

    if (n != 0) {
      result = sumDigits(n / 10) + (int)(n % 10);
    }

    return result;
  }
}
