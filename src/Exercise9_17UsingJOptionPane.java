import javax.swing.JOptionPane;

public class Exercise9_17UsingJOptionPane {
  /**Main method*/
  public static void main(String[] args) {
    // Receive the amount entered from the dialog box
    String s = JOptionPane.showInputDialog(
      "Enter a string:");

    String[] tokens = s.split("[.|,|:|\"|\'|?| ]");

    for (String token: tokens) {
      System.out.println(token);
    }
  }
}
