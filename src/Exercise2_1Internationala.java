import java.util.Scanner;

public class Exercise2_1Internationala {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter an amount in US dollars: ");
    double usDollars = input.nextDouble();

    System.out.print("$" + usDollars + " is " + 
      usDollars * 7.7807 + " HK dollars");
  }
}
