  import java.awt.*;
  import java.awt.event.*;
import javax.swing.*;

  public class Exercise35_13 extends JApplet {
    private final static int NUMBER_OF_NATIONS = 7;
    private String[] nations = new String[] {"Denmark",
      "Germany", "China", "India", "Norway", "UK", "US"};
    private ImageIcon[] icons = new ImageIcon[NUMBER_OF_NATIONS];
    private ImageIcon[] bigIcons = new ImageIcon[NUMBER_OF_NATIONS];

    // Create a combo box model
    private DefaultComboBoxModel model = new DefaultComboBoxModel();

    // Create a combo box with the specified model
    private JComboBox jcboCountries = new JComboBox(model);

    // Create a list cell renderer
    private MyListCellRenderer renderer = new MyListCellRenderer();

    // Create a label for displaying iamge
    private JLabel jlblImage = new JLabel("", JLabel.CENTER);

    /** Construct the applet */
    public Exercise35_13() {
      // Load small and large image icons
      for (int i = 0; i < NUMBER_OF_NATIONS; i++) {
        icons[i] = new ImageIcon(getClass().getResource(
          "image/flagIcon" + i + ".gif"));
        model.addElement(new Object[]{icons[i], nations[i]});

        bigIcons[i] = new ImageIcon(getClass().getResource(
          "image/flag" + i + ".gif"));
      }

      // Set list cell renderer for the combo box
      jcboCountries.setRenderer(renderer);
      jlblImage.setIcon(bigIcons[0]);
      add(jcboCountries, java.awt.BorderLayout.NORTH);
      add(jlblImage, java.awt.BorderLayout.CENTER);

      // Register listener
      jcboCountries.addActionListener(new ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          jlblImage.setIcon(bigIcons[jcboCountries.getSelectedIndex()]);
        }
      });


    // Listener for keyboard event
    jcboCountries.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DELETE)
          model.removeElementAt(jcboCountries.getSelectedIndex());
         // jcboCountries.remove(jcboCountries.getSelectedIndex());
      }
    });
  }

  public static void main(String[] args) {
    Exercise35_13 applet = new Exercise35_13();
    JFrame frame = new JFrame();
    frame.setTitle("Exercise35_13");
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
