import java.util.Scanner;

public class Exercise2_1Internationalb {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter an amount in HK dollars: ");
    double hkDollars = input.nextDouble();

    System.out.print("HKD " + hkDollars + " is " + 
      hkDollars / 7.7807 + " HK dollars");
  }
}