/** Finding the largest n such that n^3 < 12000) */
public class Exercise4_13 {
  public static void main(String[] args) {
    int i = 1;

    while (i * i * i < 12000) {
      i++;
    }

    System.out.println("This number is " + (i - 1));
  }
}
