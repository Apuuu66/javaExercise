import javax.swing.*;
import javax.swing.tree.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Exercise36_9 extends JPanel implements MouseListener {
  private JTree tree;
  private DefaultMutableTreeNode root;
  private JPopupMenu jPop;
  private JMenuItem jmiDelete;
  private JMenuItem jmiRename;
  private JTextField jtfRoot;
  private JButton jbtSetRoot;

  public Exercise36_9() {
    root = new DefaultMutableTreeNode("root", true);
    tree = new JTree(root);
    tree.setRootVisible(false);
    tree.addMouseListener(this);

    jPop = new JPopupMenu();

    jmiDelete = new JMenuItem("Delete");

    jmiDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode node =
          (DefaultMutableTreeNode)((JTree)jPop.getInvoker()).
          getLastSelectedPathComponent();

        int response = JOptionPane.showConfirmDialog(tree,
          "Delete selected file?",
          "Delete File", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.OK_OPTION) {
          ((File)node.getUserObject()).delete();
          node.removeFromParent();
          tree.updateUI();
        }
      }
    });

    jmiRename = new JMenuItem("Rename");

    jmiRename.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode node =
          (DefaultMutableTreeNode)((JTree)jPop.getInvoker()).
          getLastSelectedPathComponent();

        // Gets the file of the selected node and gets the path
        File file = ((File)node.getUserObject());
        String path = file.getPath();
        String oldName = file.getName();
        String newName = JOptionPane.showInputDialog(tree,
          "Enter new file name",
          "Change File Name", JOptionPane.PLAIN_MESSAGE);

        if (newName != null) {
          String newFile = path.replace(oldName, newName);
          // Attempt to rename the file on the filesystem
          boolean renamed = file.renameTo(new File(newFile));
          if (renamed) {
            // Update the JTree with the new file name
            file = new File(newFile);
            node.setUserObject(file);
          }
          else {
            JOptionPane.showMessageDialog(tree,
              "File was not renamed successfully",
              "Rename file failed", JOptionPane.WARNING_MESSAGE);
          }
        }
        else {
          JOptionPane.showMessageDialog(tree,
            "File rename canceled",
            "Rename file canceled", JOptionPane.WARNING_MESSAGE);
        }
      }
    });

    jPop.add(jmiDelete);
    jPop.add(jmiRename);

    jtfRoot = new JTextField();
    jbtSetRoot = new JButton("Set Root Dir");

    jbtSetRoot.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String treeRoot = jtfRoot.getText().trim();

        if (treeRoot != null) {
          // Removes old root and sets a new one
          root.removeAllChildren();
          createExercise34_9(root, new File(treeRoot));
          tree.updateUI();
        }
      }
    });

    JPanel jp1 = new JPanel();
    jp1.setLayout(new BorderLayout());
    jp1.add(jtfRoot, BorderLayout.CENTER);
    jp1.add(jbtSetRoot, BorderLayout.EAST);

    setLayout(new BorderLayout());
    add(new JScrollPane((JTree)tree), BorderLayout.CENTER);
    add(jp1, BorderLayout.NORTH);
  }

  public void createExercise34_9(DefaultMutableTreeNode node,
    File file) {
    if (!file.isDirectory()) {
      if (!file.isHidden()) {
        DefaultMutableTreeNode child = new DefaultMutableTreeNode(
          file);
        node.add(child);
      }
    }
    else {
      if (!file.isHidden()) {
        DefaultMutableTreeNode child = new DefaultMutableTreeNode(
          file);
        node.add(child);
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
          createExercise34_9(child, fileList[i]);
        }
      }
    }
  }

  public void mouseReleased(MouseEvent e) {
    if (e.getButton() == MouseEvent.BUTTON3) {
      TreePath closestTreePath = tree.getClosestPathForLocation(e.
        getX(), e.getY());
      if (closestTreePath != null) {
        tree.setSelectionPath(closestTreePath);
        jPop.show(tree, e.getX(), e.getY());
      }
    }
  }

  public void mousePressed(MouseEvent e) {
    if (e.getButton() == MouseEvent.BUTTON3) {
      TreePath closestTreePath = tree.getClosestPathForLocation(e.
        getX(), e.getY());
      if (closestTreePath != null) {
        tree.setSelectionPath(closestTreePath);
        jPop.show(e.getComponent(), e.getX(), e.getY());
      }
    }
  }

  public void mouseClicked(MouseEvent e) {}

  public void mouseEntered(MouseEvent e) {}

  public void mouseExited(MouseEvent e) {}

  public static void main(String[] args) {
    JFrame frame = new JFrame("Exercise36_9: File Explorer");
    Exercise36_9 Exercise36_9 = new Exercise36_9();
    frame.add(Exercise36_9, BorderLayout.CENTER);
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }
}
