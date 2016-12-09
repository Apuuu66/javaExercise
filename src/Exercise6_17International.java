public class Exercise6_17International {
  public static void main(String[] args) {
    int[] myList = {1, 2, 3, 4, 5, 6, 7, 8};
    shiftRight(myList);
    
    for (int i = 0; i < myList.length; i++)
      System.out.print(myList[i] + " ");
  }

  public static void shiftRight(int[] list) {
    int temp = list[list.length - 1]; // Retain the last element

    // Shift elements right
    for (int i = list.length - 2; i >= 0; i--) {
      list[i + 1] = list[i];
    }

    // Move the last element to fill in the first position
    list[0] = temp;  
  }
}