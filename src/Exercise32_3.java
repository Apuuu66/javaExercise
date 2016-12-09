import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

public class Exercise32_3 extends JApplet {
  boolean isStandalone = false;
  Hurricane hurricane1 = new Hurricane();
  MessagePanel messagePanel1 = new MessagePanel();
  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  BorderLayout borderLayout1 = new BorderLayout();
  JTextField jTextField1 = new JTextField();

  /** Initialize the applet */
  public void init() {
    this.setSize(new Dimension(300, 140));
    jLabel1.setText("Enter Hurricane Category");
    jPanel1.setLayout(borderLayout1);
    jTextField1.setHorizontalAlignment(SwingConstants.RIGHT);
    jTextField1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jTextField1_actionPerformed(e);
      }
    });
    hurricane1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        hurricane1_actionPerformed(e);
      }
    });
    add(messagePanel1, BorderLayout.CENTER);
    add(jPanel1, BorderLayout.NORTH);
    jPanel1.add(jLabel1, BorderLayout.WEST);
    jPanel1.add(jTextField1, BorderLayout.CENTER);
    messagePanel1.setBackground(Color.white);
    messagePanel1.setCentered(true);
  }

  /**Main method*/
  public static void main(String[] args) {
    Exercise32_3 applet = new Exercise32_3();
    applet.isStandalone = true;
    JFrame frame = new JFrame();
    //EXIT_ON_CLOSE == 3
    frame.setTitle("Exercise32_3");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  //static initializer for setting look & feel
  static {
    try {
      //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    }
    catch(Exception e) {
    }
  }

  void hurricane1_actionPerformed(ActionEvent e) {
    if (hurricane1.getCategory() >= 2)
      messagePanel1.setMessage("Hurricane category " +
        hurricane1.getCategory() + ". Warning!!!");
    else
      messagePanel1.setMessage("Hurricane category " +
        hurricane1.getCategory());
  }

  void jTextField1_actionPerformed(ActionEvent e) {
    hurricane1.setCategory(Integer.parseInt(jTextField1.getText()));
  }
}

class Hurricane {

  public Hurricane() {
  }

  private String name;
  private int category;
  private transient Vector actionListeners;
  public String getName() {
    return name;
  }
  public void setName(String newName) {
    name = newName;
  }

  public void setCategory(int newCategory) {
    category = newCategory;
    fireActionPerformed(new ActionEvent(this,
      ActionEvent.ACTION_PERFORMED, null));
  }
  public int getCategory() {
    return category;
  }
  public synchronized void removeActionListener(ActionListener l) {
    if (actionListeners != null && actionListeners.contains(l)) {
      Vector v = (Vector) actionListeners.clone();
      v.removeElement(l);
      actionListeners = v;
    }
  }
  public synchronized void addActionListener(ActionListener l) {
    Vector v = actionListeners == null ? new Vector(2) : (Vector) actionListeners.clone();
    if (!v.contains(l)) {
      v.addElement(l);
      actionListeners = v;
    }
  }
  protected void fireActionPerformed(ActionEvent e) {
    if (actionListeners != null) {
      Vector listeners = actionListeners;
      int count = listeners.size();
      for (int i = 0; i < count; i++) {
        ((ActionListener) listeners.elementAt(i)).actionPerformed(e);
      }
    }
  }
}
