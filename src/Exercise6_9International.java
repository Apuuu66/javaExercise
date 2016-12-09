public class Exercise6_9International {
  public static void main(String[] args) {
    int[] list = {10, 22, 4, 5, 10, -120, 2, 22};

    System.out.println("The max is " + max(list));
  }

  public static int max(int[] list) {
    int max = list[0];

    for (int i = 1; i < list.length; i++)
      if (max < list[i]) max = list[i];

    return max;
  }
}