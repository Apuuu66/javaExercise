public class Exercise13_5 {
  public static void main(String[] args) {
    new Exercise13_5();
  }

  public Exercise13_5() {
    try {
      new Triangle(1, 2, 3);
    }
    catch (IllegalTriangleException ex) {
      ex.printStackTrace();
    }
  }

  public class IllegalTriangleException extends Exception {
    public IllegalTriangleException() {
    }

    public IllegalTriangleException(String s) {
      super(s);
    }
  }

  public class Triangle extends Object {
    double side1, side2, side3;

    /** Constructor */
    public Triangle(double side1, double side2, double side3)
      throws IllegalTriangleException {
      if (side1 + side2 <= side3 || side1 + side3 <= side2 ||
        side2 + side3 <= side1)
        throw new IllegalTriangleException(
          "The sum of any two sides is greater than the other side");
    }

    /** Implement the abstract method findArea in GeometricObject */
    public double findArea() {
      double s = (side1 + side2 + side3) / 2;
      return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    /** Implement the abstract method findCircumference in
     * GeometricObject
     **/
    public double findPerimeter() {
      return side1 + side2 + side3;
    }

    /** Override the toString method */
    public String toString() {
      // Implement it to return the three sides
      return "Triangle: side1 = " + side1 + " side2 = " + side2 +
        " side3 = " + side3;
    }
  }
}

