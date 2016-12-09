public class Exercise14_7 {
  public static void main(String[] args) {
    Octagon a1 = new Octagon(5);
    System.out.println("Area is " + a1.getArea());
    System.out.println("Perimeter is " + a1.getPerimeter());

    Object a2 = a1.clone();
    System.out.println("Compare the methods " + a1.compareTo(a2));
  }
}

class Octagon extends GeometricObject
  implements Comparable, Cloneable {
  private double side;

  /** Construct a Octagon with the specified side */
  public Octagon (double side) {
    // Implement it
    this.side = side;
  }

  /** Implement the abstract method getArea in
     GeometricObject */
  public double getArea() {
     // Implement it
    return (2 + 4 / Math.sqrt(2)) * side * side;
  }

  /** Implement the abstract method getPerimeter in
     GeometricObject */
  public double getPerimeter() {
    // Implement it
    return 8 * side;
  }

  /** Implement the compareTo method in
     the Comparable interface to  */
  public int compareTo(Object obj) {
    // Implement it (compare two Octagons based on their areas)
    double thisArea = this.getArea();
    double otherArea = ((Octagon)obj).getArea();

    if (thisArea > otherArea)
      return 1;
    else if (thisArea == otherArea)
      return 0;
    else
      return -1;
  }

  /** Implement the clone method in
     the Object class */
  public Object clone() {
    // Implement it
    try {
      return super.clone();
    }
    catch (CloneNotSupportedException ex) {
      return null;
    }
  }
}
