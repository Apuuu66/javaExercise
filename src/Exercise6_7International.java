public class Exercise6_7International {
  public static void main(String[] args) throws Exception {
    java.util.Scanner input = new java.util.Scanner
      (new java.io.File("Exercise6_7.txt"));
    
    final int MAX_SIZE = 100;
    int[] numbers = new int[MAX_SIZE];

    int count = 0;
    while (input.hasNext()) {
      numbers[count++] = input.nextInt();
    }

    input.close();
    
    // Shuffle numbers
    for (int i = 0; i < count; i++) {
      int index = (int)(Math.random() * count);
      int temp = numbers[i];
      numbers[i] = numbers[index];
      numbers[index] = temp;
    }
    
    // Write numbers back to the file
    java.io.PrintWriter output = new java.io.PrintWriter
      ("Exercise6_7.txt");
    for (int i = 0; i < count; i++) {
      output.write(numbers[i] + " ");
    }

    output.close();
  }
}
