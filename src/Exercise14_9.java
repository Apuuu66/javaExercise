import java.util.Date;

public class Exercise14_9 {
  static int i;

  public Exercise14_9() {

  }

  public static void main(String[] args) {
    String[] strings = {"CS", "Math", "Biol", "Chem", "Phys", "Buss",
      "Law", "Educ", "Elec Engr", "Mech Engr"};

    Integer[] list = new Integer[10];

    Date[] dates = new Date[10];

    for (int i = 0; i < list.length; i++)
      list[i] = new Integer((int)(Math.random() * 100));

    for (int i = 0; i < list.length; i++)
      dates[i] = new Date();

    System.out.println("Max string is " + max(strings));
    System.out.println("Max integer is " + max(list));
    System.out.println("Max circle is " + max(dates));
  }

  public static Object max(Comparable[] a) {
    Comparable max = a[0];

    for (int i = 1; i < a.length; i++)
      if (max.compareTo(a[i]) < 0)
        max = (Comparable)a[i];

    return max;
  }
}
