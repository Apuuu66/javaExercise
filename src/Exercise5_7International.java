public class Exercise5_7International {
  public static void main(String[] args) {
    System.out.println(getNumberOfDaysInMonth(2, 2000));
    System.out.println(getNumberOfDaysInMonth(2, 2001));
    System.out.println(getNumberOfDaysInMonth(1, 2000));
  }
  
  static int getNumberOfDaysInMonth(int month, int year) {
    if (month == 1 || month == 3 || month == 5 || month == 7 ||
      month == 8 || month == 10 || month == 12)
      return 31;

    if (month == 4 || month == 6 || month == 9 || month == 11)
      return 30;

    if (month == 2) return isLeapYear(year) ? 29 : 28;

    return 0; // If month is incorrect
  }

  /** Determine if it is a leap year */
  static boolean isLeapYear(int year) {
    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
  }
}
