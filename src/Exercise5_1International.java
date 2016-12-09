
public class Exercise5_1International {
  public static void main(String[] args) {
    reverse(13459);
  }

  public static void reverse(int number) {
    while (number != 0) {
      System.out.print(number % 10);
      number = number / 10;
    }
  }
}
