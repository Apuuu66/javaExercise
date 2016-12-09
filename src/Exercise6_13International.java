public class Exercise6_13International {
  public static void main(String[] args) {
    System.out.println(getAverage(1, 2, 3, 10));
  }

  // Generate a random number between 1 and 54 excluding numbers
  public static int getAverage(int ...numbers) {
    if (numbers.length == 0)
      return 0;
    else {
      int sum = 0;
      for (int i = 0; i < numbers.length; i++) 
        sum += numbers[i];

      return sum;
    }
  }
}