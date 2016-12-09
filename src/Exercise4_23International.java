public class Exercise4_23International { 
  public static void main(String[] args) { 
    int count = 1;
    int headCount = 0;
    int tailCount = 0;

    while (count <= 100000) {
      // Obtain the random number 0 or 1
      int number = (int)(Math.random() * 2);

      // Check the guess
      if (number == 0)
        headCount++;
      else
        tailCount++;

      count++;
    }

    System.out.println("head count: " + headCount);
    System.out.println("tail count: " + tailCount);
  }
}