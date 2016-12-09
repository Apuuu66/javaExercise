import java.awt.*;
import javax.swing.*;

public class Exercise20_37 extends JApplet {
  public static int SIZE = 8;
  private int queens[] = new int[SIZE];
  private JPanel solutionPanel = new JPanel();
  private int count = 0;
  
  public static void main(String[] args) {
    JFrame frame = new JFrame("Exercise20_37");
    Exercise20_37 applet = new Exercise20_37();
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  public Exercise20_37() {
    this.setLayout(new BorderLayout());
    add(new JScrollPane(solutionPanel), BorderLayout.CENTER);
    search(0);
  }

  private void search(int row) {
    for (int column = 0; column < SIZE; column++) {
      queens[row] = column;
      if (isValid(row, column))
        if (row < SIZE - 1)
          search(row + 1);
        else {
          count++;
          solutionPanel.add(new ChessBoardWithLabel("Solution " + count, queens));
        }
    }
  }

  public boolean isValid(int row, int column) {
    for (int i = 1; i <= row; i++)
      if (queens[row - i] == column // Check column
          || queens[row - i] == column - i // diagonal to upper left
          || queens[row - i] == column + i) // diagonal to upper right
        return false;

    return true;
  }

  private class ChessBoardWithLabel extends JPanel {
    private JLabel jlblCount = new JLabel("", JLabel.CENTER);
    private int[] queens;
    private Image queenImage = new ImageIcon("image/queen.jpg").getImage();

    public ChessBoardWithLabel(String count, int[] queens) {
      this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
      this.queens = queens.clone();
      setLayout(new BorderLayout());
      jlblCount.setText(count);
      add(jlblCount, BorderLayout.NORTH);
      add(new ChessBoard(), BorderLayout.CENTER);
    }

    private class ChessBoard extends JPanel {
      ChessBoard() {
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
      }

      protected void paintComponent(Graphics g) {
        //g.clearRect(0, 0, getWidth(), getHeight());
//        g.setColor(Color.WHITE);
//        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);

        // Add the Queen image
        for (int i = 0; i < SIZE; i++) {
          int j = queens[i];
          g.drawImage(queenImage, j * getWidth() / SIZE, i * getHeight()
            / SIZE, getWidth() / SIZE, getHeight() / SIZE, this);
        }

        // Paint the lines
        for (int i = 0; i < SIZE; i++) {
          g.drawLine(0, i * getHeight() / SIZE, getWidth(), i * getHeight()
            / SIZE);
          g.drawLine(i * getWidth() / SIZE, 0, i * getWidth() / SIZE,
            getHeight());
        }
        
      }

      /** Specify preferred size */
      public Dimension getPreferredSize() {
        return new Dimension(200, 200);
      }
    }
  }
}