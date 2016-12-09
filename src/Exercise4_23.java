public class Exercise4_23 {
  final static int N = 50000;

  public static void main (String[] args) {
    System.out.println("The result of the backward computation " + backward());
    System.out.println("The result of the forward computation " + forward());

    double difference = backward() - forward();
    System.out.println("difference is " + difference);
  }

  public static double backward() {
    double sum = 0.0;
    for (int i = N; i >= 1; i--)
      sum += 1.0 / (double)(i);
    return sum;
  }

  static double forward() {
    double sum = 0.0;
    for (int i = 1; i <= N; i++)
      sum += 1.0 / (double)(i);
    return sum;
  }
}

