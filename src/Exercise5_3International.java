public class Exercise5_3International {
  public static void main(String[] args) {
    System.out.println(lowerCaseToUpperCase('b'));
  }

  public static char lowerCaseToUpperCase(char c) {
    if (c >= 'a' && c <= 'z') {
      return (char)(c - ('a' - 'A'));
    }

    return c;
  }
}
