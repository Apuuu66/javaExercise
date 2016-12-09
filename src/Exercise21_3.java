public class Exercise21_3 {

public static <E extends Comparable<E>> void selectionSort(E[] list) {
    for (int i = list.length - 1; i >= 1; i--) {
      // Find the maximum in the list[0..i]
      E currentMax = list[0];
      int currentMaxIndex = 0;

      for (int j = 1; j <= i; j++) {
        if (currentMax.compareTo(list[j]) < 0) {
          currentMax = list[j];
          currentMaxIndex = j;
        }
      }

      // Swap list[i] with list[currentMaxIndex] if necessary;
      if (currentMaxIndex != i) {
        list[currentMaxIndex] = list[i];
        list[i] = currentMax;
      }
    }
  }

}
