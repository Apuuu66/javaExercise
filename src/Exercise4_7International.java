public class Exercise4_7International {
  public static void main(String[] args) {
    double tuition = 40000;

    for (int i = 1; i <= 10; i++) {
      tuition = tuition * 1.03;
    }

    System.out.println("Tuition in ten years is " + tuition);
  }
}