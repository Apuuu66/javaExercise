import java.util.Scanner;

public class Exercise3_1International {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a radius: ");
    double radius = input.nextDouble();

    if (radius >= 0) {
      double area = radius * radius * 3.14159;
      System.out.println("The area is " + area);
    }
    else {
      System.out.println("Incorrect input");
    }
  }
}
