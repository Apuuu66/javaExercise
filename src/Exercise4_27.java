public class Exercise4_27 {
  public static void main(String[] args) {
    int count = 1;
    for (int year = 2001; year <= 2100; year++) {
      if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
        System.out.print((count++ % 10 == 0)? year + "\n": year + " ");
    }
  }
}
