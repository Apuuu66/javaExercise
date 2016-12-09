public class Exercise14_5 {
  public static void main(String[] args) {
    Circle14_5 obj1 = new Circle14_5();
    Circle14_5 obj2 = new Circle14_5();

    System.out.println(obj1.equals(obj2));
    System.out.println(obj1.compareTo(obj2));
  }
}

// Circle.java: The circle class that extends GeometricObject
class Circle14_5 extends GeometricObject implements Comparable {
  private double radius;

  /** Return radius */
  public double getRadius() {
    return radius;
  }

  /** Set a new radius */
  public void setRadius(double radius) {
    this.radius = radius;
  }

  /** Implement the getArea method defined in GeometricObject */
  public double getArea() {
    return radius * radius * Math.PI;
  }

  /** Implement the getPerimeter method defined in GeometricObject*/
  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }

  /** Override the toString() method defined in the Object class */
  public String toString() {
    return "[Circle] radius = " + radius;
  }

  public int compareTo(Object obj) {
    if (this.getArea() > ((Circle14_5)obj).getArea())
      return 1;
    else if (this.getArea() < ((Circle14_5)obj).getArea())
      return -1;
    else
      return 0;
  }

  public boolean equals(Object obj) {
    return this.radius == ((Circle14_5)obj).radius;
  }
}
