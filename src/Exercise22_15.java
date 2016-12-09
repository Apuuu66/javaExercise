import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.*;

public class Exercise22_15 extends JApplet {
  private JTextField[][] cells = new JTextField[9][9];
  private JButton jbtSolve = new JButton("Solve");
  private JButton jbtClear = new JButton("Clear");
  private JButton jbtNext = new JButton("Next");

  private static ArrayList<int[][]> list = new ArrayList<int[][]>();
  private int currentSolutionIndex = 0;
  
  public Exercise22_15() {
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
    p2.add(jbtNext);
    jbtNext.setVisible(false);
    add(p2, BorderLayout.SOUTH);

    jbtSolve.addActionListener(new SolveActionListenerClass());
    jbtNext.addActionListener(new NextActionListenerClass());
    jbtClear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jbtNext.setVisible(false);

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
      list.clear();
      currentSolutionIndex = 0;
      
      int[][] grid = new int[9][9];
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          if (cells[i][j].getText().trim().length() == 0) {
            grid[i][j] = 0;
            cells[i][j].setBackground(Color.WHITE);
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
      else {
        int count = Sudoku.search(grid);
        
        if (count == 0) {
          JOptionPane.showMessageDialog(null, "No solution");
        }
        else {
          // Display the first solution
          int[][] solutionGrid = list.get(0);
          for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
              cells[i][j].setText(solutionGrid[i][j] + "");
            }
          }
        }
      }
      
      if (list.size() > 1) {
        jbtNext.setVisible(true);
        JOptionPane.showMessageDialog(null, 
          "The puzzle has " + list.size() + " solutions");
      }
    }
  }

  class NextActionListenerClass implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      currentSolutionIndex = ++currentSolutionIndex % list.size() ;
      System.out.println("Total number of solutions: " + list.size());
      
          int[][] solutionGrid = list.get(currentSolutionIndex);
          for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
              cells[i][j].setText(solutionGrid[i][j] + "");
            }
          }
        }
      }

  
  public static void main(String[] args) {
    JFrame frame = new JFrame("Exercise22_15");
    JApplet applet = new Exercise22_15();
    frame.add(applet);
    frame.setSize(300, 320);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
  
  public static class Sudoku {
    /** Obtain a list of free cells from the puzzle */
    public static int[][] getFreeCellList(int[][] grid) {
      // 81 is the maximum number of free cells
      int[][] tempList = new int[81][2];
      int numberOfFreeCells = 0;

      for (int i = 0; i < 9; i++)
        for (int j = 0; j < 9; j++)
          if (grid[i][j] == 0) {
            tempList[numberOfFreeCells][0] = i;
            tempList[numberOfFreeCells][1] = j;
            numberOfFreeCells++;
          }

      // Trim freeCellList
      int[][] freeCellList = new int[numberOfFreeCells][2];
      for (int i = 0; i < numberOfFreeCells; i++) {
        freeCellList[i][0] = tempList[i][0];
        freeCellList[i][1] = tempList[i][1];
      }

      return freeCellList;
    }

    /** Search for up to 3 solutions. 
     * This method returns the number of solutions found.
     * Possible return values are 0, 1, 2, and 3.  */
    
    public static int search(int[][] grid) {
      int[][] freeCellList = getFreeCellList(grid); // Free cells
      int k = 0; // Start from the first free cell
      int count = 0; // Multiple solutions: Count for 3 solutions

      boolean done = false;
      while (!done) {
        int i = freeCellList[k][0];
        int j = freeCellList[k][1];
        if (grid[i][j] == 0)
          grid[i][j] = 1; // Start with 1

        if (isValid(i, j, grid)) {
          if (k + 1 == freeCellList.length) { // No more free cells
            // A solution is found
            count++;
            
            int[][] solutionGrid = new int[9][9];
            for (int i1 = 0; i1 < 9; i1++)
              for (int j1 = 0; j1 < 9; j1++)
                solutionGrid[i1][j1] = grid[i1][j1];
            
            list.add(solutionGrid);
            
            // Now search for the next possible solution
            if (grid[i][j] < 9) {
              grid[i][j] = grid[i][j] + 1; // Check the next possible value
            } 
            else { // grid[i][j] is 9, backtrack
              while (grid[i][j] == 9) {
                grid[i][j] = 0; // Reset to free cell
                if (k == 0) {
                  done = true; // No possible value any more, done!
                  return count; 
                }
                k--; // Backtrack
                i = freeCellList[k][0];
                j = freeCellList[k][1];
              }

              grid[i][j] = grid[i][j] + 1; // Check the next possible value
            }
          } 
          else { // Move to the next free cell
            k++;
          }
        }
        else if (grid[i][j] < 9) {
          grid[i][j] = grid[i][j] + 1; // Check the next possible value
        } 
        else { // grid[i][j] is 9, backtrack
          while (grid[i][j] == 9) {
            grid[i][j] = 0; // Reset to free cell
            if (k == 0) {
              return count; // No possible value
            }
            k--; // Backtrack
            i = freeCellList[k][0];
            j = freeCellList[k][1];
          }

          grid[i][j] = grid[i][j] + 1; // Check the next possible value
        }
      }

      return count; // A solution is found
    }

    /** Check whether grid[i][j] is valid in the grid */
    public static boolean isValid(int i, int j, int[][] grid) {
      // Check whether grid[i][j] is valid at the i's row
      for (int column = 0; column < 9; column++)
        if (column != j && grid[i][column] == grid[i][j])
          return false;

      // Check whether grid[i][j] is valid at the j's column
      for (int row = 0; row < 9; row++)
        if (row != i && grid[row][j] == grid[i][j])
          return false;

      // Check whether grid[i][j] is valid in the 3 by 3 box
      for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
        for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
          if (row != i && col != j && grid[row][col] == grid[i][j])
            return false;

      return true; // The current value at grid[i][j] is valid
    }

    /** Check whether the fixed cells are valid in the grid */
    public static boolean isValid(int[][] grid) {
      for (int i = 0; i < 9; i++)
        for (int j = 0; j < 9; j++)
          if (grid[i][j] < 0 || grid[i][j] > 9 ||
             (grid[i][j] != 0 && !isValid(i, j, grid))) {
            System.out.println("grid[i][j] = " + grid[i][j]);
            System.out.println("i = " + i + " j " + j);
            return false;
          }

      return true; // The fixed cells are valid
    }
  }
}