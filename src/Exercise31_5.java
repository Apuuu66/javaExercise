import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.*;

public class Exercise31_5 extends JApplet {
  boolean isStandalone = false;
  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JTextField jtfLoanAmount = new JTextField();
  JLabel jLabel2 = new JLabel();
  JTextField jtfNumOfYears = new JTextField();
  JLabel jLabel3 = new JLabel();
  JTextField jtfAnnualInterestRate = new JTextField();
  JButton jbtLoanSchedule = new JButton();
  TitledBorder titledBorder1;
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextArea jtaLoanSchedule = new JTextArea();
  JPanel jPanel2 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  GridLayout gridLayout1 = new GridLayout();

  /**Construct the applet*/
  public Exercise31_5() {
  }
  /**Initialize the applet*/
  public void init() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  /**Component initialization*/
  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    this.setSize(new Dimension(705, 399));
    jLabel1.setText("Loan Amount");
    jtfLoanAmount.setText("10000");
    jtfLoanAmount.setColumns(9);
    jLabel2.setText("Number of Years");
    jtfNumOfYears.setText("1");
    jtfNumOfYears.setColumns(2);
    jLabel3.setText("Annual Interest Rate");
    jtfAnnualInterestRate.setText("7");
    jtfAnnualInterestRate.setColumns(5);
    jbtLoanSchedule.setText("Display Loan Schedule");
    jbtLoanSchedule.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jbtLoanSchedule_actionPerformed(e);
      }
    });
    jPanel1.setLayout(gridLayout1);
    jPanel1.setBorder(titledBorder1);
    titledBorder1.setTitle("Enter Loan Amount, Number of Years, and Annual Interest Rate");
    jtaLoanSchedule.setText("jTextArea1");
    jPanel2.setLayout(borderLayout1);
    gridLayout1.setRows(3);
    gridLayout1.setColumns(2);
    add(jScrollPane1, BorderLayout.CENTER);
    add(jPanel2, BorderLayout.NORTH);
    jPanel2.add(jbtLoanSchedule, BorderLayout.EAST);
    jPanel2.add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jLabel1, null);
    jPanel1.add(jtfLoanAmount, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(jtfNumOfYears, null);
    jPanel1.add(jLabel3, null);
    jPanel1.add(jtfAnnualInterestRate, null);
    jScrollPane1.getViewport().add(jtaLoanSchedule, null);
  }

  /**Main method*/
  public static void main(String[] args) {
    Exercise31_5 applet = new Exercise31_5();
    applet.isStandalone = true;
    JFrame frame = new JFrame();
    //EXIT_ON_CLOSE == 3
    frame.setTitle("Loan Schedule");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400, 320);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  void jbtLoanSchedule_actionPerformed(ActionEvent e) {
    // Obtain loan amount, annual interest rate, and number of years
    double loanAmount = Double.parseDouble(
    jtfLoanAmount.getText().trim());
    double annualInterestRate = Double.parseDouble(
    jtfAnnualInterestRate.getText().trim());
    int numOfYears = Integer.parseInt(
    jtfNumOfYears.getText().trim());

    // Obtain monthly interest rate
    double monthlyInterestRate = annualInterestRate/1200;

    // Compute mortgage
    double monthlyPayment = loanAmount*monthlyInterestRate/
      (1-(Math.pow(1/(1+monthlyInterestRate), numOfYears*12)));

    double balance = loanAmount;
    double interest;
    double principal;
    NumberFormat currencyForm =
      NumberFormat.getCurrencyInstance();

    jtaLoanSchedule.setText("Monthly Payment: " +
      currencyForm.format(monthlyPayment) + "\n");
    jtaLoanSchedule.append(
      "Total Payment: " +
       currencyForm.format(monthlyPayment * 12 * numOfYears) + "\n\n");
    jtaLoanSchedule.append(
      "Payment#\tInterest\tPrincipal\tBalance\n");
    int i;
    for (i = 1; i <= numOfYears * 12; i++) {
      interest = monthlyInterestRate * balance;
      principal = monthlyPayment - interest;
      balance -= principal;
      jtaLoanSchedule.append(i + "\t" + currencyForm.format(interest)
        + "\t" + currencyForm.format(principal) + "\t" +
        currencyForm.format(balance) + "\n");
    }
  }
}

