public class Exercise3_13International {
  public static void main(String[] args) {
    java.util.Scanner input = new java.util.Scanner(System.in);
    System.out.print("Enter a year: ");
    int year = input.nextInt();

    if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
      System.out.println("Year " + year + " has 366 days");
    }
    else {
      System.out.println("Year " + year + " has 365 days");
    }
  }
}
