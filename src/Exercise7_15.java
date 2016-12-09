public class Exercise7_15 {
  public static void main(String[] args) {
    double[][] set1 = {{1, 1}, {2, 2}, {3, 3}, {4, 4}};
    double[][] set2 = {{0, 1}, {1, 2}, {4, 5}, {5, 6}};
    double[][] set3 = {{0, 1}, {1, 2}, {4, 5}, {4.5, 4}};

    displayPoints(set1);
    System.out.println("same line? " + sameLine(set1));
    
    displayPoints(set2);
    System.out.println("same line? " + sameLine(set2));

    displayPoints(set3);
    System.out.println("same line? " + sameLine(set3));
  }

  public static void displayPoints(double[][] points) {
    for (int i = 0; i < points.length; i++) 
      System.out.print("(" + points[i][0] + ", " + points[i][1] + ") ");
        
    System.out.println();
  }
  
  public static boolean sameLine(double[][] points) {
    if (points == null) return true;
    if (points.length < 2) return true;
    
    double slope = (points[0][0] - points[1][0]) / 
      (points[0][1] - points[1][1]);
    for (int i = 3; i < points.length; i++) {
      double slope1 = (points[i][0] - points[1][0]) / 
        (points[i][1] - points[1][1]);
      
      if (slope != slope1) return false;
    }
    
    return true;
  }
}