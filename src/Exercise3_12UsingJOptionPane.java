import javax.swing.*;

public class Exercise3_12UsingJOptionPane {
    public static void main(String[] args) {
        // Prompt the user to enter an integer
        int number = Integer.parseInt(JOptionPane.showInputDialog("Enter an integer:"));

        if (number % 5 == 0 && number % 6 == 0)
            System.out.println(number + " is divisible by both 5 and 6");
        else if (number % 5 == 0 ^ number % 6 == 0)
            System.out.println(number + " is divisible by both 5 and 6, but not both");
        else
            System.out.println(number + " is not divisible by either 5 or 6");
    }
}
