import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Exercise25_11 extends JApplet {
  private JTextField jcCard1 = new JTextField();
  private JTextField jcCard2 = new JTextField();
  private JTextField jcCard3 = new JTextField();
  private JTextField jcCard4 = new JTextField();

  private JTextField jtfSolution = new JTextField();

  public Exercise25_11() {
    JButton jbtFindSolution = new JButton("Find a Solution");

    // Creates Grouping Panels
    JPanel topPanel = new JPanel();
    JPanel cardPanel = new JPanel(new GridLayout(1, 4, 5, 5));

    // Sets interface variables
    jtfSolution.setEditable(false);
    jtfSolution.setHorizontalAlignment(SwingConstants.LEFT);
    jtfSolution.setColumns(9);
    jtfSolution.setFont(new Font("Times", Font.PLAIN, 20));

    // Adds all interface items to panels
    topPanel.add(jtfSolution);
    topPanel.add(jbtFindSolution);
    cardPanel.add(jcCard1);
    cardPanel.add(jcCard2);
    cardPanel.add(jcCard3);
    cardPanel.add(jcCard4);
    jcCard1.setHorizontalAlignment(JTextField.CENTER);
    jcCard2.setHorizontalAlignment(JTextField.CENTER);
    jcCard3.setHorizontalAlignment(JTextField.CENTER);
    jcCard4.setHorizontalAlignment(JTextField.CENTER);
    
    Font font = new Font("Times", Font.PLAIN, 45);
    jcCard1.setFont(font);
    jcCard2.setFont(font);
    jcCard3.setFont(font);
    jcCard4.setFont(font);

    // Adds panels to applet
    add(topPanel, BorderLayout.NORTH);
    add(cardPanel, BorderLayout.CENTER);

    jbtFindSolution.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jtfSolution.setText(findSolution());
      }
    });
  }

  /** main method */
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    Exercise25_11 applet = new Exercise25_11();

    frame.add(applet);
    frame.setLocationRelativeTo(null);
    frame.setTitle("Exercise25_11");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(350, 120);
    frame.setVisible(true);
  }

  /* Finds a solution for the cards shown */
  public String findSolution() {
    int a = Integer.parseInt(jcCard1.getText().trim());
    int b = Integer.parseInt(jcCard2.getText().trim());
    int c = Integer.parseInt(jcCard3.getText().trim());
    int d = Integer.parseInt(jcCard4.getText().trim());
    String noSolution = "No solution";
    String solution;
    String[] operators = {"+", "-", "*", "/"};

    int[][] allCombinations = { { a, b, c, d }, { d, a, b, c },
        { c, d, a, b }, { b, c, d, a }, { a, b, d, c }, { c, a, b, d },
        { d, c, a, b }, { b, d, c, a }, { a, d, c, b }, { b, a, d, c },
        { c, b, a, d }, { d, c, b, a }, { a, c, b, d }, { d, a, c, b },
        { b, d, a, c }, { c, b, d, a }, { b, a, c, d }, { d, b, a, c },
        { c, d, b, a }, { a, c, d, b }, { a, d, b, c }, { c, a, d, b },
        { b, c, a, d }, { d, b, c, a } };

    for (String firstOp : operators)
      for (String secondOp : operators)
        for (String thirdOp : operators)
          for (int[] cardNums : allCombinations)
            for (int i = 0; i < 3; i++)
              for (int j = 0; j < 5; j++) {
                if (i == 0) {
                  if (j == 0) {
                    solution = cardNums[0] + firstOp
                        + cardNums[1] + secondOp
                        + cardNums[2] + thirdOp
                        + cardNums[3];
                    if (EvaluateExpression
                        .evaluateExpression(solution) == 24)
                      return solution;
    
                  } else if (j == 1) {
                    solution = "(" + cardNums[0] + firstOp
                        + cardNums[1] + ")" + secondOp
                        + cardNums[2] + thirdOp
                        + cardNums[3];
                    if (EvaluateExpression
                        .evaluateExpression(solution) == 24)
                      return solution;

                  } else if (j == 2) {
                    solution = cardNums[0] + firstOp + "("
                        + cardNums[1] + secondOp
                        + cardNums[2] + ")" + thirdOp
                        + cardNums[3];
                    if (EvaluateExpression
                        .evaluateExpression(solution) == 24)
                      return solution;

                  } else if (j == 3) {
                    solution = cardNums[0] + firstOp
                        + cardNums[1] + secondOp + "("
                        + cardNums[2] + thirdOp
                        + cardNums[3] + ")";
                    if (EvaluateExpression
                        .evaluateExpression(solution) == 24)
                      return solution;

                  } else if (j == 4) {
                    solution = "(" + cardNums[0] + firstOp
                        + cardNums[1] + ")" + secondOp
                        + "(" + cardNums[2] + thirdOp
                        + cardNums[3] + ")";
                    if (EvaluateExpression
                        .evaluateExpression(solution) == 24)
                      return solution;

                  }
                } else if (i == 1) {
                  if (j == 0) {
                    solution = "(" + cardNums[0] + firstOp
                        + cardNums[1] + secondOp
                        + cardNums[2] + ")" + thirdOp
                        + cardNums[3];
                    if (EvaluateExpression
                        .evaluateExpression(solution) == 24)
                      return solution;

                  } else if (j == 1) {
                    solution = "((" + cardNums[0] + firstOp
                        + cardNums[1] + ")" + secondOp
                        + cardNums[2] + ")" + thirdOp
                        + cardNums[3];
                    if (EvaluateExpression
                        .evaluateExpression(solution) == 24)
                      return solution;

                  } else if (j == 2) {
                    solution = "(" + cardNums[0] + firstOp
                        + "(" + cardNums[1] + secondOp
                        + cardNums[2] + "))" + thirdOp
                        + cardNums[3];
                    if (EvaluateExpression
                        .evaluateExpression(solution) == 24)
                      return solution;
                  }
                } else if (i == 2) {
                  if (j == 0) {
                    solution = cardNums[0] + firstOp + "("
                        + cardNums[1] + secondOp
                        + cardNums[2] + thirdOp
                        + cardNums[3] + ")";
                    if (EvaluateExpression
                        .evaluateExpression(solution) == 24)
                      return solution;

                  } else if (j == 1) {
                    solution = cardNums[0] + firstOp + "(("
                        + cardNums[1] + secondOp
                        + cardNums[2] + ")" + thirdOp
                        + cardNums[3] + ")";
                    if (EvaluateExpression
                        .evaluateExpression(solution) == 24)
                      return solution;

                  } else if (j == 2) {
                    solution = cardNums[0] + firstOp + "("
                        + cardNums[1] + secondOp + "("
                        + cardNums[2] + thirdOp
                        + cardNums[3] + "))";
                    if (EvaluateExpression
                        .evaluateExpression(solution) == 24)
                      return solution;

                  }
                }
              }
    return noSolution;
  }

  /* Card class */
  public class JCard extends JLabel {
    int faceValue;

    public JCard() {
    }

    public JCard(javax.swing.Icon icon, int faceValue) {
      this.setIcon(icon);
      this.faceValue = faceValue;
    }
  }

  /* Class to evaluate card Expression */
  public static class EvaluateExpression {
    /** Evaluate an expression */
    public static double evaluateExpression(String expression) {
      // Create operandStack to store operands
      Stack<Double> operandStack = new Stack<Double>();

      // Create operatorStack to store operators
      Stack<Character> operatorStack = new Stack<Character>();

      // Extract operands and operators
      java.util.StringTokenizer tokens = new java.util.StringTokenizer(
          expression, "()+-/*", true);

      // Phase 1: Scan tokens
      while (tokens.hasMoreTokens()) {
        String token = tokens.nextToken().trim(); // Extract a token
        if (token.length() == 0) // Blank space
          continue; // Back to the while loop to extract the next
        // token
        else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
          // Process all +, -, *, / in the top of the operator stack
          while (!operatorStack.isEmpty()
              && (operatorStack.peek().equals('+')
                  || operatorStack.peek().equals('-')
                  || operatorStack.peek().equals('*') || operatorStack
                  .peek().equals('/'))) {
            processAnOperator(operandStack, operatorStack);
          }

          // Push the + or - operator into the operator stack
          operatorStack.push(new Character(token.charAt(0)));
        } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
          // Process all *, / in the top of the operator stack
          while (!operatorStack.isEmpty()
              && (operatorStack.peek().equals('*') || operatorStack
                  .peek().equals('/'))) {
            processAnOperator(operandStack, operatorStack);
          }

          // Push the * or / operator into the operator stack
          operatorStack.push(new Character(token.charAt(0)));
        } else if (token.trim().charAt(0) == '(') {
          operatorStack.push(new Character('(')); // Push '(' to stack
        } else if (token.trim().charAt(0) == ')') {
          // Process all the operators in the stack until seeing '('
          while (!operatorStack.peek().equals('(')) {
            processAnOperator(operandStack, operatorStack);
          }

          operatorStack.pop(); // Pop the '(' symbol from the stack
        } else { // An operand scanned
          // Push an operand to the stack
          operandStack.push(new Double(token));
        }
      }

      // Phase 2: process all the remaining operators in the stack
      while (!operatorStack.isEmpty()) {
        processAnOperator(operandStack, operatorStack);
      }

      // Return the result
      return ((Double) (operandStack.pop())).doubleValue();
    }

    /**
     * Process one operator: Take an operator from operatorStack and apply it
     * on the operands in the operandStack
     */
    public static void processAnOperator(Stack<Double> operandStack,
        Stack<Character> operatorStack) {
      if (operatorStack.peek().equals('+')) {
        operatorStack.pop();
        double op1 = ((Double) (operandStack.pop())).doubleValue();
        double op2 = ((Double) (operandStack.pop())).doubleValue();
        operandStack.push(new Double(op2 + op1));
      } else if (operatorStack.peek().equals('-')) {
        operatorStack.pop();
        double op1 = ((Double) (operandStack.pop())).doubleValue();
        double op2 = ((Double) (operandStack.pop())).doubleValue();
        operandStack.push(new Double(op2 - op1));
      } else if (operatorStack.peek().equals('*')) {
        operatorStack.pop();
        double op1 = ((Double) (operandStack.pop())).doubleValue();
        double op2 = ((Double) (operandStack.pop())).doubleValue();
        operandStack.push(new Double(op2 * op1));
      } else if (operatorStack.peek().equals('/')) {
        operatorStack.pop();
        double op1 = ((Double) (operandStack.pop())).doubleValue();
        double op2 = ((Double) (operandStack.pop())).doubleValue();
        operandStack.push(new Double(op2 / op1));
      }
    }
  }
}