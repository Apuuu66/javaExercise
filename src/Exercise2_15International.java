public class Exercise2_15International {
  public static void main(String[] args) {
    double firstYearTuition = 5000;
    double secondYearTuition = firstYearTuition * 1.045;
    double thirdYearTuition = secondYearTuition * 1.045;
    double fourthYearTuition = thirdYearTuition * 1.045;
    double fifthYearTuition = fourthYearTuition * 1.045;

    System.out.println("Second year tuition: " + secondYearTuition);
    System.out.println("third year tuition: " + thirdYearTuition);
    System.out.println("fourth year tuition: " + (int)(fourthYearTuition));
    System.out.println("fifth year tuition: " + (int)(fifthYearTuition * 100) / 100.0);
  }
}
