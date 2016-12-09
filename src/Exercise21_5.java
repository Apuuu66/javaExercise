public class Exercise21_5 {
  public static void main(String[] args) {
    Integer[] numbers = {1, 2, 3};
    System.out.println(max(numbers));
  }

  public static <E extends Comparable<E>> E max(E[] list) {
    E max = list[0];

    for (int i = 1; i < list.length; i++) {
      if (max.compareTo(list[i]) < 0) {
        max = list[i];
      }
    }

    return max;
  }
}
