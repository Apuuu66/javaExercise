public class Exercise9_15International {
  public static void main(String[] args) {
    // Check command-line arguments
    if (args.length < 1) {
      System.out.println(
        "Usage: java Exercise9_15International args0 args1 ...");
      System.exit(0);
    }

    int[] numbers = new int[args.length]; 
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = Integer.parseInt(args[i]);  
    }

    java.util.Arrays.sort(numbers);
    for (int i = 0; i < numbers.length; i++) {
      System.out.print(numbers[i] + " ");  
    }    
  }
}