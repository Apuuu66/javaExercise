public class Exercise20_15 {
  public static void main(String[] args) {
    System.out.println(count("Welcome", 'e'));
  }

  public static int count(String str, char a) {
    return count(str, a, str.length() - 1);
  }

  public static int count(String str, char a, int high) {
    int result = 0;
    if (high > 0)
      result = count(str, a, high - 1) +
        ((str.charAt(high) == a) ? 1 : 0);

    return result;
  }
}
