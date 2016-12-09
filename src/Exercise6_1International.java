
public class Exercise6_1International {
  public static void main (String[] args) {
    final int NUMBER_OF_INPUT = 5;
    java.util.Scanner input = new java.util.Scanner(System.in);
    double[] numbers = new double[NUMBER_OF_INPUT];

    for (int i = 0; i < NUMBER_OF_INPUT; i++) {
      // Read a number
      System.out.print("Read a number: ");

      numbers[i] = input.nextDouble();
    }

    // Shuffle the array
    for (int i = 0; i < NUMBER_OF_INPUT; i++) {
      int index = (int)(Math.random() * NUMBER_OF_INPUT);
      double temp = numbers[i];
      numbers[i] = numbers[index];
      numbers[index] = temp;
    }

    // Display the array
    for (int i = 0; i < NUMBER_OF_INPUT; i++) {
      System.out.println(numbers[i]);
    }
  }
}
