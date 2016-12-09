import java.util.Scanner;

public class Exercise7_1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a 4 by 4 matrix row by row: ");
    double[][] m = new double[4][4];
    
    for (int i = 0; i < 4; i++)
      for (int j = 0; j < 4; j++)
        m[i][j] = input.nextDouble();

    System.out.print("Sum of the matrix is " + sumMatrix(m));
  }
  
  public static double sumMatrix(double[][] m) {
    int sum = 0;

    for (int i = 0; i < m.length; i++)
      for (int j = 0; j < m[0].length; j++)
        sum += m[i][j];

    return sum;
  }  
}

