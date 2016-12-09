public class Test { 
  public static void main(String[] args) {
  	int[][] a = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};

  	for (int row = 0; row < a.length; row++) {
  		for (int column = 0; column < a[row].length; column++)
  			System.out.print(a[row][column] + " ");
  		System.out.println();
  	}
  }
  
  public static int sum(int[][] matrix) {
  	return 0;
  }
}
