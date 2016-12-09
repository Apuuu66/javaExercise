public class Exercise20_21 {
  public static void main(String[] args) {
    System.out.println(decimalToBinary(8));
    System.out.println(decimalToBinary(9));
    System.out.println(decimalToBinary(10));
    System.out.println(decimalToBinary(11));
  }  

  public static String decimalToBinary(int value) {
    if (value == 0)
      return "";
    else
      return decimalToBinary(value / 2) + value % 2;   
  }
}
