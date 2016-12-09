import java.util.Scanner;

public class Exercise5_11International {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int decimal = input.nextInt();
        
    System.out.println(decimal + "'s binary representation is " +
        toBinary(decimal));
  }

  public static String toBinary(int decimal) {   
    String binaryString = "";
    int value = decimal;
    while (value != 0) {
      binaryString = value % 2 + binaryString;
      value = value / 2;
    }
        
    return binaryString;    
  }
}
