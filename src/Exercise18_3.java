import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Exercise18_3 extends JApplet {
  // Declare and create text fields for interest rate
  // year, loan amount, monthly payment, and total payment
  private JTextField jtfInterestRate = new JTextField(10);
  private JTextField jtfYear = new JTextField(10);
  private JTextField jtfLoan = new JTextField(10);
  private JTextField jtfMonthlyPay = new JTextField(10);
  private JTextField jtfTotalPay = new JTextField(10);

  // Declare and create a Compute Mortgage button
  private JButton jbtCompute = new JButton("Compute Payment");

  // Initialize user interface
  public Exercise18_3() {
    // Set properties on the text fields
    jtfMonthlyPay.setEditable(false);
    jtfTotalPay.setEditable(false);

    jtfInterestRate.setHorizontalAlignment(JTextField.RIGHT);
    jtfYear.setHorizontalAlignment(JTextField.RIGHT);
    jtfLoan.setHorizontalAlignment(JTextField.RIGHT);
    jtfMonthlyPay.setHorizontalAlignment(JTextField.RIGHT);
    jtfTotalPay.setHorizontalAlignment(JTextField.RIGHT);
    
    // Panel p1 to hold labels and text fields
    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(5, 2));
    p1.add(new Label("Interest Rate (e.g., 5.5 for 5.5%)"));
    p1.add(jtfInterestRate);
    p1.add(new Label("Years "));
    p1.add(jtfYear);
    p1.add(new Label("Loan Amount"));
    p1.add(jtfLoan);
    p1.add(new Label("Monthly Payment"));
    p1.add(jtfMonthlyPay);
    p1.add(new Label("Total Payment"));
    p1.add(jtfTotalPay);
    p1.setBorder(new
      TitledBorder("Enter interest rate, year and loan amount"));

    // Panel p2 to hold the button
    JPanel p2 = new JPanel();
    p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
    p2.add(jbtCompute);

    // Add the components to the applet
    add(p1, BorderLayout.CENTER);
    add(p2, BorderLayout.SOUTH);

    // Register listener
    jbtCompute.addActionListener(new ActionListener() {
      // Handler for the "Compute" button
      public void actionPerformed(ActionEvent e) {
        // Get values from text fields
        double interest =
          (Double.valueOf(jtfInterestRate.getText())).doubleValue();
        int year =
          (Integer.valueOf(jtfYear.getText())).intValue();
        double loanAmount =
          (Double.valueOf(jtfLoan.getText())).doubleValue();

        // Create a Loan object
        Loan loan = new Loan(interest, year, loanAmount);

        // Display monthly payment and total payment
        jtfMonthlyPay.setText(String.format("%.2f", loan.getMonthlyPayment()));
        jtfTotalPay.setText(String.format("%.2f", loan.getTotalPayment()));
      }    	    	
    });
  }
  
  // Main method
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Exercise18_3");

    // Create an instance of MortgageApplet
    Exercise18_3 applet = new Exercise18_3();

    // Add the applet instance to the frame
    frame.add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(350, 250);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
