
public class Exercise6_5International {
  public static void main(String[] args) {
    final int NUMBER_OF_INPUT = 11;
    int[] numbers = new int[NUMBER_OF_INPUT];
    int size = 0;

    java.util.Scanner input = new java.util.Scanner(System.in);

    for (int i = 0; i < numbers.length; i++) {
      // display the number if it is already in the array
      System.out.print("Enter an integer: ");
      int value = input.nextInt();

      boolean isInArray = false;

      for (int j = 0; j < size; j++)
        if (numbers[j] == value) {
          isInArray = true;
          break;
        }

      if (isInArray) {
        System.out.println(value);
      }
      else {
        // Store the number in the array
        numbers[size] = value;
        size++;        
      }
    }
  }
}
