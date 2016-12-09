public class Exercise8_1 {
  public static void main(String[] args) {
    Rectangle myRectangle = new Rectangle(4, 40);
    System.out.println("The area of a rectangle with width " +
      myRectangle.width + " and height " +
      myRectangle.height + " is " +
      myRectangle.getArea());
    System.out.println("The perimeter of a rectangle is " +
      myRectangle.getPerimeter());

    Rectangle yourRectangle = new Rectangle(3.5, 35.9);
    System.out.println("The area of a rectangle with width " +
      yourRectangle.width + " and height " +
      yourRectangle.height + " is " +
      yourRectangle.getArea());
    System.out.println("The perimeter of a rectangle is " +
      yourRectangle.getPerimeter());
  }
}

class Rectangle {
  // Data members
  double width = 1, height = 1;
  
  // Constructor
  public Rectangle() {
  }

  // Constructor
  public Rectangle(double newWidth, double newHeight) {
    width = newWidth;
    height = newHeight;
  }

  public double getArea() {
    return width * height;
  }

  public double getPerimeter() {
    return 2 * (width + height);
  }
}