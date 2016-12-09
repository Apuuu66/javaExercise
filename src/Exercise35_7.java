import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class Exercise35_7 extends JApplet {
  private final static int NUMBER_OF_NATIONS = 7;
  private String[] nations = new String[]
    {"Denmark", "Germany", "China", "India", "Norway", "UK", "US"};
  private ImageIcon[] icons = new ImageIcon[NUMBER_OF_NATIONS];
  private ImageIcon[] bigIcons = new ImageIcon[NUMBER_OF_NATIONS];

  // Create a list model
  private DefaultListModel listModel = new DefaultListModel();

  // Create a list using the list model
  private JList jlstNations = new JList(listModel);

  // Create a list cell renderer
  private ListCellRenderer renderer = new MyListCellRenderer();

  // Create a split pane
  private JSplitPane jSplitPane1 = new JSplitPane();

  // Create a label for displaying iamge
  private JLabel jlblImage = new JLabel("", JLabel.CENTER);

  /** Construct ListCellRenderer */
  public Exercise35_7() {
    // Load small and large image icons
    for (int i = 0; i < NUMBER_OF_NATIONS; i++) {
      bigIcons[i] = new ImageIcon(getClass().getResource(
        "image/flag" + i + ".gif"));
      listModel.addElement(new Object[]{bigIcons[i], nations[i]});
    }

    // Set list cell renderer
    jlstNations.setCellRenderer(renderer);
    jlstNations.setFixedCellHeight(50);
    jlstNations.setPreferredSize(new Dimension(200, 200));
    jSplitPane1.setLeftComponent(new JScrollPane(jlstNations));
    jSplitPane1.setRightComponent(jlblImage);
    jlstNations.setSelectedIndex(0);
    jlblImage.setIcon(bigIcons[0]);
    add(jSplitPane1, BorderLayout.CENTER);

    // Register listener
    jlstNations.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent e) {
        jlblImage.setIcon(bigIcons[jlstNations.getSelectedIndex()]);
      }
    });
  }

  public static void main(String[] args) {
    Exercise35_7 applet = new Exercise35_7();
    JFrame frame = new JFrame();
    frame.setTitle("Exercise35_7");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400, 320);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}

class MyListCellRenderer implements ListCellRenderer {
  private JPanel cellPainter = new JPanel();
  private ImageViewer imageViewer = new ImageViewer();
  private JLabel jlblString = new JLabel(" ", JLabel.LEFT);

  private Border lineBorder =
    BorderFactory.createLineBorder(Color.black, 1);
  private Border emptyBorder =
    BorderFactory.createEmptyBorder(2, 2, 2, 2);

  public MyListCellRenderer() {
    cellPainter.setOpaque(true);
    imageViewer.setPreferredSize(new Dimension(32, 32));
    cellPainter.setLayout(new BorderLayout());
    cellPainter.add(imageViewer, BorderLayout.WEST);
    cellPainter.add(jlblString, BorderLayout.CENTER);
  }

  /** Implement this method in ListCellRenderer */
  public Component getListCellRendererComponent
      (JList list, Object value, int index, boolean isSelected,
       boolean cellHasFocus) {
    Object[] pair = (Object[])value; // Cast value into an array
    imageViewer.setImage(((ImageIcon)pair[0]).getImage());
    jlblString.setText(pair[1].toString());

    if (isSelected) {
      cellPainter.setForeground(list.getSelectionForeground());
      cellPainter.setBackground(list.getSelectionBackground());
    }
    else {
      cellPainter.setForeground(list.getForeground());
      cellPainter.setBackground(list.getBackground());
    }

    cellPainter.setBorder(cellHasFocus ? lineBorder : emptyBorder);

    return cellPainter;
  }
}
