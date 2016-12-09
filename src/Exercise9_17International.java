import java.io.File;
import java.util.Scanner;

public class Exercise9_17International {
  public static void main(String[] args) throws Exception {
    // Check command-line arguments
    if (args.length < 1) {
      System.out.println(
        "Usage: java Exercise9_17International filename");
      System.exit(0);
    }
    
    Scanner input = new Scanner(new File(args[0]));
    
    int count = 0;
    while (input.hasNext()) {
      input.next();
      count++;
    }
    
    System.out.println("The number of words is " + count);
  }
}
