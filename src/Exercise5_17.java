public class Exercise5_17 {
  public static void main(String[] args) {
    printMatrix(3);
  }

  public static void printMatrix(int n) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++)
          System.out.print((int)(Math.random() * 2));

        System.out.println();
      }
  }
}
