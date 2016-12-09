public class Exercise14_3 {
  public static void main(String[] args) {
    Square square = new Square(2);
    square.howToColor();
  }
}

interface Colorable {
  public void howToColor();
}

class Square extends GeometricObject implements Colorable {
  private double side;

  public Square(double side) {
    this.side = side;
  }

  public void howToColor() {
    System.out.println("Color all four sides");
  }

  public double getArea() {
    return side * side;
  }

  public double getPerimeter() {
    return 4 * side;
  }
}
