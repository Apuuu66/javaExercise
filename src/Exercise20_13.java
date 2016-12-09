public class Exercise20_13 {
  public static void main(String[] args) {
    int[] list = {1, 2, 3, 4, 5};
    System.out.println(largest(list));
  }

  public static int largest(int[] list) {
    return largest(list, list.length - 1);
  }

  public static int largest(int[] list, int high) {
    if (high == 0) {
      return list[0];
    }
    else {
      return Math.max(largest(list, high - 1), list[high]);
    }
  }
}
