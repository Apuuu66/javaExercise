public class Exercise2_5International {
  public static void main(String[] args) {
    java.util.Scanner input = new java.util.Scanner(System.in);
    System.out.print("Enter the number of pennies: ");
    int numberOfPennies = input.nextInt();
    
    System.out.print("Enter the number of nickels: ");
    int numberOfNickels = input.nextInt();

    System.out.print("Enter the number of dimes: ");
    int numberOfDimes = input.nextInt();

    System.out.print("Enter the number of quarters: ");
    int numberOfQuarters = input.nextInt();
    
    System.out.print("Enter the number of dollars: ");
    int numberOfDollars = input.nextInt();

    int total = numberOfPennies + numberOfNickels * 5 +
      numberOfDimes * 10 + numberOfQuarters * 25 + 
      numberOfDollars * 100;
    
    System.out.println("The total amount is " + total);
  }
}
