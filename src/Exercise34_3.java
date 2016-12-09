import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exercise34_3 extends JApplet {
  private int currentType = 0;
  private MyIcon[] c = new MyIcon[4];
  private DisplayCanvas canvas = new DisplayCanvas();
  private KeyListener keyListener;

  public Exercise34_3() {
    JPanel p = new JPanel();
    p.setBackground(Color.cyan);
    p.setLayout(new FlowLayout(FlowLayout.LEFT));

    for (int i = 0; i < 4; i++)
      p.add(c[i] = new MyIcon(i));

    setLayout(new BorderLayout());
    add(p, BorderLayout.NORTH);
    add(canvas, BorderLayout.CENTER);
  }

  //inner class
  public class MyIcon extends JPanel {
    private int type = 0;

    public MyIcon(int t) {
      this.type = t;
      addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
          if ((currentType == 3) && (type != 3))
            canvas.removeKeyListener(keyListener);

          if ((currentType != 3) && (type == 3)) {
            canvas.addKeyListener(keyListener);
            canvas.requestFocus();
            System.out.println("Key listener added");
          }

          if (currentType != type) {
            c[currentType].setBackground(Color.cyan);
            c[type].setBackground(Color.red);
            currentType = type;
          }
        }
      });
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);

      int width = getSize().width;
      int height = getSize().height;

      switch (type) {
        case 0: g.drawLine(10, height-10, width-10, 10); break;
        case 1: g.drawRect(10, 10, width-20, height-20); break;
        case 2: g.drawOval(10, 10, width-20, height-20); break;
        case 3: g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
                g.drawString("A", 10, 30);
      }
    }

    public Dimension getPreferredSize() {
      return new Dimension(40, 40);
    }
  }

  public class DisplayCanvas extends JPanel {
    private Point start = new Point(20, 20); //line start point
    private Graphics g;

    public DisplayCanvas() {
      keyListener = new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
          char keyChar = e.getKeyChar();
          g = getGraphics();
          g.clearRect(0, 0, getSize().width, getSize().height);
          g.drawString(String.valueOf(keyChar), start.x, start.y);
                      System.out.println("Key pressed");

        }
      };

      addMouseMotionListener(new MouseMotionAdapter() {
        public void mouseDragged(MouseEvent e) {
          g = getGraphics();
          g.clearRect(0, 0, getSize().width, getSize().height);
          switch (currentType) {
            case 0: g.drawLine(start.x, start.y, e.getX(), e.getY()); break;
            case 1: g.drawRect(start.x, start.y, e.getX()-start.x, e.getY()-start.y); break;
            case 2: g.drawOval(start.x, start.y, e.getX()-start.x, e.getY()-start.y); break;
          }
        }
      });

      addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
          start.move(e.getX(), e.getY());
        }
      });
    }
  }

  public static void main(String[] args) {
    Exercise34_3 applet = new Exercise34_3();
    JFrame frame = new JFrame();
    frame.setTitle("Exercise34_3");
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
}
