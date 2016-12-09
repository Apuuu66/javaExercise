import java.util.Scanner;

public class Exercise5_19International {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter an integer
    System.out.print("Enter the first 9-digit of an ISBN number as integer: ");
    int number = input.nextInt();

    System.out.print(getISBN(number));
  }
  
  public static String getISBN(int number) {
    // Calculate checksum
    int t = number;
    int i = 9;
    int sum = 0;

    while (t != 0) {
      sum += (t % 10) * i;
      i--;
      t = t / 10;
    }

    int checksum = sum % 11;

    System.out.print("The ISBN number is ");

    // Display leading zeros
    int temp = 100000000;
    while (number / temp == 0) {
      System.out.print("0");
      temp = temp / 10;
    }

    String s = number + "";

    if (checksum == 10)
      s = s + "X";
    else
      s = s + checksum;
    
    return s;
  }
}
