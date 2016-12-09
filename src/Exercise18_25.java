import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Exercise18_25 extends JApplet {
  private JTextField[][] cells = new JTextField[9][9];
  private JButton jbtSolve = new JButton("Solve");
	private JButton jbtClear = new JButton("Clear");

  public Exercise18_25() {
		JPanel[][] panels = new JPanel[3][3];
    JPanel p1 = new JPanel(new GridLayout(3, 3, 0, 0));
		p1.setBorder(new LineBorder(Color.BLACK, 2));
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
        p1.add(panels[i][j] = new JPanel(new GridLayout(3, 3)));
				panels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
      }
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        panels[i / 3][j / 3].add(cells[i][j] = new JTextField());
        cells[i][j].setHorizontalAlignment(JTextField.CENTER);
      }
    }

		add(p1); // Add p1 to the applet

    JPanel p2 = new JPanel(new FlowLayout());
    p2.add(jbtSolve);
		p2.add(jbtClear);
    add(p2, BorderLayout.SOUTH);

    jbtSolve.addActionListener(new SolveActionListenerClass());
		jbtClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 9; i++)
					for (int j = 0; j < 9; j++) {
						cells[i][j].setText(null);
            cells[i][j].setBackground(Color.WHITE);
          }
			}
			});
  }

  class SolveActionListenerClass implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      int[][] grid = new int[9][9];
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          if (cells[i][j].getText().trim().length() == 0) {
            grid[i][j] = 0;
          }
          else {
            grid[i][j] = Integer.parseInt(cells[i][j].getText());
            cells[i][j].setBackground(Color.LIGHT_GRAY);
          }
        }
      }

      if (!Sudoku.isValid(grid)) {
				JOptionPane.showMessageDialog(null, "Invalid Input");
      }
      else if (Sudoku.search(grid)) {
        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
            cells[i][j].setText(grid[i][j] + "");
          }
        }
      }
      else {
        JOptionPane.showMessageDialog(null, "No solution");
      }
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Exercise18_25");
    JApplet applet = new Exercise18_25();
    frame.add(applet);
    frame.setSize(300, 320);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}