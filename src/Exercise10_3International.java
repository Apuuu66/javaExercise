public class Exercise10_3International {

}

class MyDouble {
  private double value;
  
  public MyDouble() {
    
  }
  
  public double doubleValue() {
    return value;
  }
  
  public int intValue() {
    return (int)value;
  }
  
  public static double parseDouble(String s, int radix) {
    return 1;
  }

  public boolean equals(double r) {
    return true;
  }
  
  public boolean equals(MyDouble r) {
    return true;
  }  
}
