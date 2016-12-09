import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

public class Exercise32_1 extends JApplet {
  boolean isStandalone = false;
  MessagePanelWithActionEvent messagePanelWithActionEvent1 =
    new MessagePanelWithActionEvent();

  /** Initialize the applet */
  public void init() {
    this.setSize(new Dimension(400,300));
    messagePanelWithActionEvent1.setCentered(true);
    messagePanelWithActionEvent1.setFont(new Font("TimesRoman",
      Font.BOLD, 20));
    messagePanelWithActionEvent1.addActionListener(
      new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        messagePanelWithActionEvent1_actionPerformed(e);
      }
    });
    messagePanelWithActionEvent1.addActionListener(
      new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        messagePanelWithActionEvent1_actionPerformed(e);
      }
    });
    messagePanelWithActionEvent1.addActionListener(
      new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        messagePanelWithActionEvent1_actionPerformed(e);
      }
    });
    add(messagePanelWithActionEvent1,
      BorderLayout.CENTER);
    messagePanelWithActionEvent1.setMessage(new Date().toString());
  }

  /**Main method*/
  public static void main(String[] args) {
    Exercise32_1 applet =
      new Exercise32_1();
    applet.isStandalone = true;
    JFrame frame = new JFrame();
    //EXIT_ON_CLOSE == 3
    frame.setTitle("Exercise32_1");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  void messagePanelWithActionEvent1_actionPerformed(ActionEvent e) {
    messagePanelWithActionEvent1.setMessage(new Date().toString());
  }
}

class MessagePanelWithActionEvent extends JPanel
  implements MouseListener {
  /**The message to be displayed*/
  private String message = "Welcome to Java";

  /**The x coordinate where the message is displayed*/
  private int xCoordinate = 20;

  /**The y coordinate where the message is displayed*/
  private int yCoordinate = 20;

  /**Indicate whether the message is displayed in the center*/
  private boolean centered;
  private transient Vector actionListeners;

  /**Default constructor*/
  public MessagePanelWithActionEvent() {
    this.addMouseListener(this);
  }

  /**Constructor with a message parameter*/
  public MessagePanelWithActionEvent(String message) {
    this.message = message;
  }

  /**Return message*/
  public String getMessage() {
    return message;
  }

  /**Set a new message*/
  public void setMessage(String message) {
    this.message = message;
    repaint();
  }

  /**Return xCoordinator*/
  public int getXCoordinate() {
    return xCoordinate;
  }

  /**Set a new xCoordinator*/
  public void setXCoordinate(int x) {
    this.xCoordinate = x;
  }

  /**Return yCoordinator*/
  public int getYCoordinate() {
    return yCoordinate;
  }

  /**Set a new yCoordinator*/
  public void setYCoordinate(int y) {
    this.yCoordinate = y;
  }

  /**Return centered*/
  public boolean isCentered() {
    return centered;
  }

  /**Set a new centered*/
  public void setCentered(boolean centered) {
    this.centered = centered;
  }

  /**Paint the message*/
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (centered) {
      // Get font metrics for the current font
      FontMetrics fm = g.getFontMetrics();

      // Find the center location to display
      int w = fm.stringWidth(message);  // Get the string width
      // Get the string height, from top to the baseline
      int h = fm.getAscent();
      xCoordinate = getWidth()/2-w/2;
      yCoordinate = getHeight()/2+h/2;
    }

    g.drawString(message, xCoordinate, yCoordinate);
  }

  /**Override get method for preferredSize*/
  public Dimension getPreferredSize() {
    return new Dimension(200, 100);
  }

  /**Override get method for minimumSize*/
  public Dimension getMinimumSize() {
    return new Dimension(200, 100);
  }

  /**Move the message in the pane to the left*/
  public void moveLeft() {
    if (getXCoordinate() > 10) {
      // Shift the message to the left
      setXCoordinate(getXCoordinate()-10);
      repaint();
    }
  }

  /**Move the message in the panel to the right*/
  public void moveRight() {
    if (getXCoordinate() < getSize().width - 20) {
      // Shift the message to the right
      setXCoordinate(getXCoordinate()+10);
      repaint();
    }
  }

  /**Fire action event when mouse is clicked*/
  public void mouseClicked(MouseEvent e) {
    fireActionPerformed(new ActionEvent(this,
      ActionEvent.ACTION_PERFORMED, null));
  }

  public void mousePressed(MouseEvent e) {
  }

  public void mouseReleased(MouseEvent e) {
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  /**Remove a listener*/
  public synchronized void removeActionListener(ActionListener l) {
    if (actionListeners != null && actionListeners.contains(l)) {
      Vector v = (Vector) actionListeners.clone();
      v.removeElement(l);
      actionListeners = v;
    }
  }

  /**Register a listener*/
  public synchronized void addActionListener(ActionListener l) {
    Vector v = actionListeners == null ?
      new Vector(2) : (Vector)actionListeners.clone();
    if (!v.contains(l)) {
      v.addElement(l);
      actionListeners = v;
    }
  }

  /**Invoke listeners' actionPerformed method*/
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
