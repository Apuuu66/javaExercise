import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise16_7 extends JFrame  {
  public Exercise16_7() {
    add(new MyPanel());
  }

  public static void main(String[] args) {
    Exercise16_7 frame = new Exercise16_7();
    frame.setSize(200, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  class MyPanel extends JPanel {
    MyPanel() {
      addMouseListener(new MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent mouseEvent) {
          setBackground(Color.BLACK);
        }

        public void mouseReleased(java.awt.event.MouseEvent mouseEvent) {
           setBackground(Color.WHITE);
        }
      });
    }
  }
}