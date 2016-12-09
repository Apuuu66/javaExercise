import javax.swing.*;

public class Exercise34_5 extends javax.swing.JApplet {
  /** Creates new form Exercise34_5 */
  public Exercise34_5() {
      initComponents();
  }

  private void initComponents() {
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jmiErrorMessage = new javax.swing.JMenuItem();
    jmiInformationMessage = new javax.swing.JMenuItem();
    jmiQuestionMessage = new javax.swing.JMenuItem();
    jmiWarningMessage = new javax.swing.JMenuItem();
    jmiPlainMessage = new javax.swing.JMenuItem();
    jmiCustomIcon = new javax.swing.JMenuItem();
    jMenu2 = new javax.swing.JMenu();
    jmiYesNo = new javax.swing.JMenuItem();
    jmiYesNoCancel = new javax.swing.JMenuItem();
    jmiOkCancel = new javax.swing.JMenuItem();
    jMenu3 = new javax.swing.JMenu();
    jmiTfInput = new javax.swing.JMenuItem();
    jmiCboInput = new javax.swing.JMenuItem();
    jmiLstInput = new javax.swing.JMenuItem();
    jMenu4 = new javax.swing.JMenu();
    jmiCustomOption = new javax.swing.JMenuItem();
    jlblStatus = new javax.swing.JLabel();
    jMenu1.setText("Message Dialog");
    jmiErrorMessage.setText("Error Message");
    jmiErrorMessage.addActionListener(
      new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jmiErrorMessageActionPerformed(evt);
      }
    });

    jMenu1.add(jmiErrorMessage);
    jmiInformationMessage.setText("Information Message");
    jmiInformationMessage.addActionListener(
      new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jmiInformationMessageActionPerformed(evt);
      }
    });
    jMenu1.add(jmiInformationMessage);
    jmiQuestionMessage.setText("Question Message");
    jmiQuestionMessage.addActionListener(
      new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jmiQuestionMessageActionPerformed(evt);
      }
    });
    jMenu1.add(jmiQuestionMessage);
    jmiWarningMessage.setText("Warning Message");
    jmiWarningMessage.addActionListener(
      new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jmiWarningMessageActionPerformed(evt);
      }
    });
    jMenu1.add(jmiWarningMessage);
    jmiPlainMessage.setText("Plain Message");
    jmiPlainMessage.addActionListener(
      new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jmiPlainMessageActionPerformed(evt);
      }
    });
    jMenu1.add(jmiPlainMessage);
    jmiCustomIcon.setText("Custom Icon");
    jmiCustomIcon.addActionListener(
      new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jmiCustomIconActionPerformed(evt);
      }
    });
    jMenu1.add(jmiCustomIcon);
    jMenuBar1.add(jMenu1);
    jMenu2.setText("Confirmation Dialog");
    jmiYesNo.setText("YES_NO_OPTION");
    jmiYesNo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jmiYesNoActionPerformed(evt);
      }
    });
    jMenu2.add(jmiYesNo);
    jmiYesNoCancel.setText("YES_NO_CANCEL_OPTION");
    jmiYesNoCancel.addActionListener(
      new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jmiYesNoCancelActionPerformed(evt);
      }
    });
    jMenu2.add(jmiYesNoCancel);
    jmiOkCancel.setText("OK_CANCEL_OPTION");
    jmiOkCancel.addActionListener(
      new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jmiOkCancelActionPerformed(evt);
      }
    });

    jMenu2.add(jmiOkCancel);
    jMenuBar1.add(jMenu2);
    jMenu3.setText("Input Dialog");
    jmiTfInput.setText("TextField Input");
    jmiTfInput.addActionListener(
      new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jmiTfInputActionPerformed(evt);
      }
    });
    jMenu3.add(jmiTfInput);
    jmiCboInput.setText("ComboBox Input");
    jmiCboInput.addActionListener(
      new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jmiCboInputActionPerformed(evt);
      }
    });
    jMenu3.add(jmiCboInput);
    jmiLstInput.setText("List Input");
    jmiLstInput.addActionListener(
      new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jmiLstInputActionPerformed(evt);
      }
    });
    jMenu3.add(jmiLstInput);
    jMenuBar1.add(jMenu3);
    jMenu4.setText("Option Dialog");
    jmiCustomOption.setText("Custom Option");
    jmiCustomOption.addActionListener(
      new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jmiCustomOptionActionPerformed(evt);
      }
    });
    jMenu4.add(jmiCustomOption);
    jMenuBar1.add(jMenu4);
    add(jlblStatus, java.awt.BorderLayout.SOUTH);
    setJMenuBar(jMenuBar1);
  }

  private void jmiOkCancelActionPerformed(
    java.awt.event.ActionEvent evt) {
    int selectedOption =
      JOptionPane.showConfirmDialog(this, "Confirm?",
        "YES_NO_OPTION", JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE);
    jlblStatus.setText("Option " + selectedOption + " selected");
  }

  private void jmiYesNoCancelActionPerformed(
    java.awt.event.ActionEvent evt) {
    int selectedOption =
      JOptionPane.showConfirmDialog(this, "Confirm?",
        "YES_NO_OPTION", JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE);
    jlblStatus.setText("Option " + selectedOption + " selected");
  }

  private void jmiYesNoActionPerformed(
    java.awt.event.ActionEvent evt) {
    int selectedOption =
      JOptionPane.showConfirmDialog(this, "Confirm?",
        "YES_NO_OPTION", JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE);
    jlblStatus.setText("Option " + selectedOption + " selected");
  }

  private void jmiCustomOptionActionPerformed(
    java.awt.event.ActionEvent evt) {
    int value =
      JOptionPane.showOptionDialog(this, "Select a button",
        "Option Dialog", JOptionPane.DEFAULT_OPTION,
        JOptionPane.PLAIN_MESSAGE, null,
        new Object[]{"Button 0", "Button 1", "Button 2"},
        "Button 1");
    jlblStatus.setText("Value is " + value);
  }

  private void jmiLstInputActionPerformed(
    java.awt.event.ActionEvent evt) {
    Object input =
      JOptionPane.showInputDialog(this, "Select a state",
        "Choose a State", JOptionPane.QUESTION_MESSAGE, null,
        new String[]{"Item 1", "Item 2", "Item 3", "Item 4",
          "Item 5", "Item 6", "Item 7", "Mississippi", "Missouri",
          "Nebraska", "Nevada", "New Hampshire", "Item 13", "Item 14",
          "Item 15", "Item 16", "Item 17", "Item 18", "Item 19",
          "Item 20"},
        "Item 5");
    jlblStatus.setText("Input is " + input);
  }

  private void jmiCboInputActionPerformed(
    java.awt.event.ActionEvent evt) {
    Object input =
      JOptionPane.showInputDialog(this, "Select a school",
        "Choose a School", JOptionPane.QUESTION_MESSAGE, null,
        new String[]{"Arts and Science", "Engineering", "Education"},
        "Engineering");
    jlblStatus.setText("Input is " + input);
  }

  private void jmiTfInputActionPerformed(
    java.awt.event.ActionEvent evt) {
    String input =
      JOptionPane.showInputDialog(this, "Enter your name");
    jlblStatus.setText("Input is " + input);
  }

  private void jmiCustomIconActionPerformed(
    java.awt.event.ActionEvent evt) {
    JOptionPane.showMessageDialog(this, "This is a printer",
      "Custom icon", JOptionPane.INFORMATION_MESSAGE,
      new ImageIcon(getClass().getResource("image/printIcon.gif")));
  }

  private void jmiPlainMessageActionPerformed(
    java.awt.event.ActionEvent evt) {
    JOptionPane.showMessageDialog(null, new StillClock(),
      "Current Time", JOptionPane.PLAIN_MESSAGE);
  }

  private void jmiWarningMessageActionPerformed(
    java.awt.event.ActionEvent evt) {
    JOptionPane.showMessageDialog(this, "This is a warning",
      "Warning", JOptionPane.WARNING_MESSAGE);
  }

  private void jmiQuestionMessageActionPerformed(
    java.awt.event.ActionEvent evt) {
    JOptionPane.showMessageDialog(this, "This is a question",
      "Question", JOptionPane.QUESTION_MESSAGE);
  }

  private void jmiInformationMessageActionPerformed(
    java.awt.event.ActionEvent evt) {
    JOptionPane.showMessageDialog(this, "This is an information",
      "Information", JOptionPane.INFORMATION_MESSAGE);
  }

  private void jmiErrorMessageActionPerformed(
    java.awt.event.ActionEvent evt) {
    JOptionPane.showMessageDialog(this, "This is an error",
      "Error", JOptionPane.ERROR_MESSAGE);
  }

  // Variables declaration - do not modify
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenuItem jmiErrorMessage;
  private javax.swing.JMenuItem jmiInformationMessage;
  private javax.swing.JMenuItem jmiQuestionMessage;
  private javax.swing.JMenuItem jmiWarningMessage;
  private javax.swing.JMenuItem jmiPlainMessage;
  private javax.swing.JMenuItem jmiCustomIcon;
  private javax.swing.JMenu jMenu2;
  private javax.swing.JMenuItem jmiYesNo;
  private javax.swing.JMenuItem jmiYesNoCancel;
  private javax.swing.JMenuItem jmiOkCancel;
  private javax.swing.JMenu jMenu3;
  private javax.swing.JMenuItem jmiTfInput;
  private javax.swing.JMenuItem jmiCboInput;
  private javax.swing.JMenuItem jmiLstInput;
  private javax.swing.JMenu jMenu4;
  private javax.swing.JMenuItem jmiCustomOption;
  private javax.swing.JLabel jlblStatus;
  // End of variables declaration

  public static void main(String[] args) {
    Exercise34_5 applet = new Exercise34_5();
    JFrame frame = new JFrame();
    frame.setTitle("Exercise34_5");
    frame.add(applet, java.awt.BorderLayout.CENTER);
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
