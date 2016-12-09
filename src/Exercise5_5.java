public class Exercise5_5 {
  public static void main(String[] args) {
    System.out.println(distance(12, 14.5, 33.5, 23.345));
  }

  public static double distance
     (double x1, double y1, double x2, double y2) {
    return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
  }
}
