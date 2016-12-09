public class Exercise3_19 {
  public static void main(String[] args) {
    java.util.Scanner input = new java.util.Scanner(System.in);

    // Enter three edges
    System.out.print(
      "Enter three edges (length in double): ");
    double edge1 = input.nextDouble();
    double edge2 = input.nextDouble();
    double edge3 = input.nextDouble();

    // Display results
    boolean valid = (edge1 + edge2 > edge3) &&
      (edge1 + edge3 > edge2) && (edge2 + edge3 > edge1);

    if (valid) {
      System.out.println("The perimeter of the triangle is " +
        (edge1 + edge2 + edge3));
    }
    else
      System.out.println("Input is invalid");
  }
}
