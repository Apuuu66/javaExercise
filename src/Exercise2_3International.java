public class Exercise2_3International {
  public static void main(String[] args) {
    java.util.Scanner input = new java.util.Scanner(System.in);
    System.out.print("Enter price of the product: ");
    double price = input.nextDouble();
    
    double totalPrice = price * 1.06;

    System.out.println("The total price is " + totalPrice);
  }
}
