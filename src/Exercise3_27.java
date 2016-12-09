import java.util.Scanner;

public class Exercise3_27 {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter a point's x- and y-coordinates: ");
    double x = input.nextDouble();
    double y = input.nextDouble();

    if (x > 200 || x < 0 || y > 100 || y < 0)
      System.out.println("The point is not in the triangle");
    else {
      double slope = (200.0 - 0) / (0 - 100.0);
      double x1 = x + -y * slope;
      if (x1 <= 200)
        System.out.println("The point is in the triangle");
      else
        System.out.println("The point is not in the triangle");
    }
  }
}
