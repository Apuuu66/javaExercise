public class Exercise6_3International {
  public static void main(String[] args) {
    final int NUMBER_OF_INPUT = 11;
    java.util.Scanner input = new java.util.Scanner(System.in);

    double[] numbers = new double[NUMBER_OF_INPUT];
    double sum = 0;

    for (int i = 0; i < numbers.length; i++) {
      System.out.print("Enter a number: ");
      numbers[i] = input.nextDouble();
      sum += numbers[i];
    }

    double average = sum / 10;
    int countLess = 0;

    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] < average)
       countLess++;
    }

    System.out.println("The average is " + average);
    System.out.println("The number of values less than the average is " + countLess);
  }
}
