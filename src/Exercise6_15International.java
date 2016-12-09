public class Exercise6_15International {
  public static void main(String[] args) {
    int[] myList = {1, 2, 3, 4, 5, 6, 7, 8};
    int[] newArray = doubleCapacity(myList);
  }

  public static int[] doubleCapacity(int[] list) {
    int[] result = new int[list.length * 2];
    System.arraycopy(list, 0, result, 0, list.length);
    return result;
  }
}