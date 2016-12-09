public class Exercise9_13International {
  public static void main(String[] args) {
    // Check command-line arguments
    if (args.length < 2) {
      System.out.println(
        "Usage: java Exercise9_13International arg0 arg1 ...");
      System.exit(0);
    }

    int gcd = gcd(Integer.parseInt(args[0]), 
      Integer.parseInt(args[1]));
    
    for (int i = 2; i < args.length; i++)
      gcd = gcd(gcd, Integer.parseInt(args[i]));
    
    System.out.println("gcd is " + gcd);    
  }

  /** Return the gcd of two integers */
  public static int gcd(int n1, int n2) {
    int gcd = 1; // Initial gcd is 1
    int k = 2;   // Possible gcd

    while (k <= n1 && k <= n2) {
      if (n1 % k == 0 && n2 % k == 0)
        gcd = k; // Update gcd
      k++;
    }
  
    return gcd; // Return gcd
  }
}
