import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise13_11 extends JApplet implements ActionListener {
  private JTextField jtfFigureName = new JTextField(10);
  private FigurePanel figurePanel = new FigurePanel();

  public Exercise13_11() {
    JPanel panel = new JPanel();
    panel.add(new JLabel("Enter a figure name:"));
    panel.add(jtfFigureName);

    add(panel, BorderLayout.NORTH);
    add(figurePanel, BorderLayout.CENTER);

    jtfFigureName.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    try {
      String name = jtfFigureName.getText();
      displayFigure(name);
    }
    catch (UnknownFigureException ex) {
      ex.printStackTrace();
    }
  }

  public void displayFigure(String name) throws UnknownFigureException {
    if (name.equals("line")) {
      figurePanel.setType(FigurePanel.LINE);
    }
    else if (name.equals("rectangle")) {
      figurePanel.setType(FigurePanel.RECTANGLE);
    }
    else if (name.equals("round rectangle")) {
      figurePanel.setType(FigurePanel.ROUND_RECTANGLE);
    }
    else if (name.equals("oval")) {
      figurePanel.setType(FigurePanel.OVAL);
    }
    else {
      throw new UnknownFigureException();
    }
  }

  // This main method enables the applet to run as an application
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Exercise18_10");

    // Create an instance of the applet
    Exercise13_11 applet = new Exercise13_11();

    // Add the applet instance to the frame
    frame.add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}

class UnknownFigureException extends Exception {
  UnknownFigureException() {
    super("Illegal figure");
  }

  UnknownFigureException(String message) {
    super(message);
  }
}
