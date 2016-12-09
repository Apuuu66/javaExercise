public class Exercise6_19International {
  public static void main(String[] args) {
    double[] myList = {5, 6, 7, 8, 1, 2, 3, 4};
    insertionSort(myList);
    
    for (int i = 0; i < myList.length; i++)
      System.out.print(myList[i] + " ");
  }
  
  /** The method for sorting the numbers */
  public static void insertionSort(double[] list) {
    for (int i = 1; i < list.length; i++) {
      /**
       * insert list[i] into a sorted sublist list[0..i-1] 
       * so that list[0..i] is sorted.
       */
      double currentElement = list[i];
      int k;
      for (k = i - 1; k >= 0 && list[k] < currentElement; k--) {
        list[k + 1] = list[k];
      }

      // Insert the current element into list[k + 1]
      list[k + 1] = currentElement;
    }
  }
}