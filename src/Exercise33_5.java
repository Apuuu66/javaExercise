// Exercise33_5.java: Use GridBagLayout for the calculator
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Exercise33_5 extends JApplet implements ActionListener {
  private TextField tf = new TextField(10);

  public void init() {
    Panel p = new Panel();
    p.setLayout(new BorderLayout());

    Panel westPanel = new Panel();
    westPanel.setLayout(new GridLayout(5, 0));
    westPanel.add(new Button("   "));
    westPanel.add(new Button("MC"));
    westPanel.add(new Button("MR"));
    westPanel.add(new Button("MS"));
    westPanel.add(new Button("M+"));

    Panel centerPanel = new Panel();
    centerPanel.setLayout(new BorderLayout());
    Panel p1 = new Panel();
    Panel p2 = new Panel();

    p1.setLayout(new FlowLayout(FlowLayout.RIGHT));
    p1.add(new Button("Back"));
    p1.add(new Button("CE"));
    p1.add(new Button("C"));

    p2.setLayout(new GridLayout(4, 5));
    p2.add(new Button("7"));
    p2.add(new Button("8"));
    p2.add(new Button("9"));
    p2.add(new Button("/"));
    p2.add(new Button("sqrt"));
    p2.add(new Button("4"));
    p2.add(new Button("5"));
    p2.add(new Button("6"));
    p2.add(new Button("*"));
    p2.add(new Button("%"));
    p2.add(new Button("1"));
    p2.add(new Button("2"));
    p2.add(new Button("3"));
    p2.add(new Button("-"));
    p2.add(new Button("1/x"));
    p2.add(new Button("0"));
    p2.add(new Button("+/-"));
    p2.add(new Button("."));
    p2.add(new Button("+"));
    p2.add(new Button("="));

    centerPanel.add("Center", p2);
    centerPanel.add("North", p1);
    p.add("Center", centerPanel);
    p.add("West", westPanel);

    setLayout(new BorderLayout());
    add("Center", p);
    add("North",tf);
  }

  public void actionPerformed(ActionEvent e) {
  }

  public static void main(String[] args) {
    Exercise33_5 applet = new Exercise33_5();
    JFrame frame = new JFrame();
    frame.setTitle("Exercise33_5");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
