import java.math.*;

public class Exercise14_13 {
  public static void main(String[] args) {
		final BigInteger MAXLONG = new BigInteger(Long.MAX_VALUE + "");

    // Find the first number such that number^2 is greater than
		// Long.MAX_VALUE
		BigInteger bigNum = BigInteger.ONE;
		for (;
		     bigNum.multiply(bigNum).compareTo(MAXLONG) < 0;
				 bigNum = bigNum.add(BigInteger.ONE));

    System.out.println(bigNum);
  }
}
