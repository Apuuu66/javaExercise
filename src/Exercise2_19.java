public class Exercise2_19 {
  // Main method
  public static void main(String[] args) {
    long time = System.currentTimeMillis();
    
    long value = 'A' + time % ('Z' - 'A' + 1);
    
    System.out.print((char)value);
  }
}