public class Exercise20_23 {
  public static void main(String[] args) {
    System.out.println(binaryToDecimal("100"));
    System.out.println(binaryToDecimal("1000"));
    System.out.println(binaryToDecimal("1010"));
  }  

  public static int binaryToDecimal(String binaryString) {
    return binaryToDecimal(binaryString, 0, binaryString.length() - 1);
  }
  
  public static int binaryToDecimal(String binaryString, int low, int high) {
    if (high < low)
      return 0;
    else 
      return binaryToDecimal(binaryString, low, high - 1) * 2
        + (binaryString.charAt(high) - '0');
  }
}
