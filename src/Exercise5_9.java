public class Exercise5_9 {
  public static void main(String[] args) {
    System.out.println("Feet\t\tMeters\t|\tMeters\tFeet");
    System.out.println("---------------------------------------------");

    double foot = 1; double meter = 20;
    for (int i = 1; i <= 10; foot++, meter+=5, i++) {
      System.out.println(foot + "\t\t" + footToMeter(foot) + "\t|\t" + meter + "\t\t" + meterToFoot(meter));
    }
  }

  /** Converts from feet to meters */
  public static double footToMeter(double foot) {
    return 0.305 * foot;
  }

  /** Converts from meters to feet */
  public static double meterToFoot(double meter) {
    return (1 / 0.305) * meter;
  }
}
