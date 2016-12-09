public class Exercise2_5 {
  public static void main(String args[]) {
    // Read subtotal
    java.util.Scanner input = new java.util.Scanner(System.in);
    System.out.print("Enter subtotal: ");
    double subtotal = input.nextDouble();

    // Read subtotal
    System.out.print("Enter gratuity rate: ");
    double rate = input.nextDouble();

    double gratuity = subtotal * rate / 100;
    double total = subtotal + gratuity;

    System.out.println("Gratuity is " + gratuity);
    System.out.println("Total is " + total);
  }
}
