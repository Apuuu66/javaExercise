import java.util.*;
import javax.swing.JOptionPane;

public class Exercise9_18UsingJOptionPane {
    /**Main method*/
    public static void main(String[] args) {
        // Receive the amount entered from the dialog box
        String s = JOptionPane.showInputDialog(
        "Enter numbers separated by spaces:");

        Scanner input = new Scanner(s);

        double sum = 0;
        while (input.hasNext())
            sum += input.nextDouble();

        System.out.println("Sum is " + sum);
    }
}
