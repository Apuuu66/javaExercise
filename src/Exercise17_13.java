import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise17_13 extends JFrame {
  private JScrollPane jScrollPane1 = new JScrollPane();
  private JTextArea jtaTable = new JTextArea();
  private JPanel jPanel1 = new JPanel();
  private JLabel jLabel1 = new JLabel();
  private JTextField jtfLoanAmount = new JTextField();
  private JLabel jLabel2 = new JLabel();
  private JTextField jtfNumOfYears = new JTextField();
  private JButton jbtShowTable = new JButton();
  private Loan loan = new Loan();

  public static void main(String[] args) {
    Exercise17_13 frame = new Exercise17_13();
    frame.setTitle("Exercise17_13");
    frame.setSize(500, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  public Exercise17_13() {
    jLabel1.setText("Loan Amount");
    jtfLoanAmount.setText("10000");
    jtfLoanAmount.setColumns(7);
    jtfLoanAmount.setHorizontalAlignment(SwingConstants.LEFT);
    jLabel2.setText("Number of Years");
    jtfNumOfYears.setText("5");
    jtfNumOfYears.setColumns(2);
    jbtShowTable.setText("Show Table");
    jbtShowTable.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jbtShowTable_actionPerformed(e);
      }
    });
    add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(jtaTable, null);
    add(jPanel1, BorderLayout.NORTH);
    jPanel1.add(jLabel1, null);
    jPanel1.add(jtfLoanAmount, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(jtfNumOfYears, null);
    jPanel1.add(jbtShowTable, null);
  }

  void jbtShowTable_actionPerformed(ActionEvent e) {
    double loanAmount = Double.parseDouble(
      jtfLoanAmount.getText().trim());
    int numOfYears = Integer.parseInt(
      jtfNumOfYears.getText().trim());
    loan.setLoanAmount(loanAmount);
    loan.setNumberOfYears(numOfYears);

    jtaTable.setText("Interest Rate\tMonthly Payment\tTotal Payment\n");

    for (double rate = 5; rate <= 8; rate += 1 / 8.0) {
      loan.setAnnualInterestRate(rate);
      jtaTable.append(rate + "\t" +
        (int)(loan.getMonthlyPayment() * 100) / 100.0 +
        "\t\t" + (int)(loan.getTotalPayment() * 100) / 100.0 + "\n");
    }
  }
}

