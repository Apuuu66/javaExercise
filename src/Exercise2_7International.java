public class Exercise2_7International {
  public static void main(String[] args) {
    // Assign a lowercase letter
    char lowercase = 'g';

    int offset = (int)'a' - (int)'A';
    char uppercase = (char)((int)lowercase - offset);

    System.out.print("The uppercase letter is " + uppercase);
  }
}
