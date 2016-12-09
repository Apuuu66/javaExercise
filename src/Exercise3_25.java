// Exercise3_1.java
import java.util.Scanner;

public class Exercise3_25 {
  /**Main method*/
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter three edges (double): ");
    double edge1 = input.nextDouble();
    double edge2 = input.nextDouble();
    double edge3 = input.nextDouble();

    boolean isValid = 
      (edge1 + edge2 > edge3) && (edge1 + edge3 > edge2) &&
      (edge2 + edge3 > edge1);

    // Display results
    System.out.println("Can edges " + edge1 + ", " + edge2 + ", and "
      + edge3 + " form a triangle? " + isValid);
  }
}
