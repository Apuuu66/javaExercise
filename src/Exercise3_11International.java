public class Exercise3_11International {
  public static void main(String[] args) {
    java.util.Scanner input = new java.util.Scanner(System.in);
    System.out.print("Enter x- and y- coordinate for point1: ");
    double x1 = input.nextDouble();
    double y1 = input.nextDouble();

    System.out.print("Enter x- and y- coordinate for point2: ");
    double x2 = input.nextDouble();
    double y2 = input.nextDouble();
    
    double distance = Math.sqrt((x1 - x2) * (x1 - x2) + 
      (y1 - y2) * (y1 - y2));
    
    System.out.println("The distance between the two points is " +
      distance);
  }
}
