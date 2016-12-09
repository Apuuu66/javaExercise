public class Exercise4_3 {
  public static void main(String[] args) {
    System.out.println("kilograms\tpounds");
    System.out.println("-------------------------");
    
    // Use while loop 
    int kilograms = 1;
    while (kilograms <= 199) {
      System.out.printf("%-4d\t\t%6.1f\n", kilograms, kilograms * 2.2);
      kilograms += 2;
    }
    
/** Alternatively use for loop    
    for (int kilograms = 1; kilograms <= 199; kilograms += 2) {
      System.out.println(kilograms + "\t\t" + kilograms * 2.2);
    }
*/
  }
}
