public class Exercise5_15International {
  public static void main(String[] args) {
    System.out.println(isPerfect(6));
    System.out.println(isPerfect(28));
    System.out.println(isPerfect(16));
  }
  
  public static boolean isPerfect(int number) {
    int sum = 0;
    int divisor = number - 1;
    while (divisor >= 1) {
      if (number % divisor == 0) {
        sum += divisor;
      }

      divisor--;
    }

    return number == sum;   
  }
}