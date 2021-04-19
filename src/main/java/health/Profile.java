package health;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.awt.Font.BOLD;
import static java.awt.Font.ITALIC;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Profile extends JFrame {
  String username;

  public Profile(String patient) {
    initComponents();
    Toolkit toolkit = getToolkit();
    Dimension size = toolkit.getScreenSize();
    setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    username = patient;
    welcome.setText("Welcome Back, " + username + "!");
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  private void initComponents() {
    JLabel jLabel4 = new JLabel();
    welcome = new JLabel();
    JButton makeRequestButton = new JButton();
    JButton viewRequestButton = new JButton();
    JLabel jLabel5 = new JLabel();
    JButton logout = new JButton();

    jLabel4.setFont(new Font("Papyrus", BOLD, 14));
    jLabel4.setForeground(new Color(51, 51, 255));
    jLabel4.setText("HealthConnect");

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    welcome.setFont(new Font("Eras Demi ITC", ITALIC, 18));
    welcome.setText("Welcome Back!");

    makeRequestButton.setText("Make a Request");
    makeRequestButton.addActionListener(
        evt -> {
          try {
            makeRequestButtonActionPerformed();
          } catch (Exception e) {
            e.printStackTrace();
          }
        });

    viewRequestButton.setText("View Your Requests");
    viewRequestButton.addActionListener(this::viewRequestButtonActionPerformed);

    jLabel5.setFont(new Font("Papyrus", BOLD, 14));
    jLabel5.setForeground(new Color(51, 51, 255));
    jLabel5.setText("HealthConnect");

    logout.setText("Logout");
    logout.addActionListener(this::logoutActionPerformed);

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGroup(
                        layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(
                                GroupLayout.Alignment.TRAILING,
                                layout
                                    .createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(
                                        jLabel5,
                                        GroupLayout.PREFERRED_SIZE,
                                        124,
                                        GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addGap(100, 100, 100)
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                GroupLayout.Alignment.TRAILING)
                                                            .addComponent(
                                                                logout,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                203,
                                                                GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(
                                                                viewRequestButton,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                203,
                                                                GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(
                                                                makeRequestButton,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                203,
                                                                GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(
                                                        welcome,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        342,
                                                        GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 12, Short.MAX_VALUE)))
                    .addContainerGap()));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addComponent(
                        welcome, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addGap(23, 23, 23)
                    .addComponent(
                        makeRequestButton,
                        GroupLayout.PREFERRED_SIZE,
                        51,
                        GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        viewRequestButton,
                        GroupLayout.PREFERRED_SIZE,
                        49,
                        GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        logout, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                    .addComponent(jLabel5)));
    pack();
  }

  private void makeRequestButtonActionPerformed() throws SQLException, ClassNotFoundException {
    // TODO add your handling code here:
    dispose();
    NewRequests n = new NewRequests(username);
    n.setVisible(true);
  }

  private void viewRequestButtonActionPerformed(ActionEvent evt) {
    // TODO add your handling code here:
    dispose();
    PatientView patientView = new PatientView(username);
    patientView.setVisible(true);
  }

  private void logoutActionPerformed(ActionEvent evt) {
    // TODO add your handling code here:
    int pane =
        JOptionPane.showConfirmDialog(
            null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
    if (pane == 0) {
      dispose();
      NewJFrame jFrame = new NewJFrame();
      jFrame.setVisible(true);
    }
  }

  public static void main(String[] args) {
    try {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException
        | InstantiationException
        | IllegalAccessException
        | UnsupportedLookAndFeelException ex) {
      Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
    }

    final NewJFrame jFrame = new NewJFrame();

    EventQueue.invokeLater(() -> new Profile(jFrame.getUsername()).setVisible(true));
  }

  // Variable declarations //
  private JLabel welcome;
  // End of variables declaration //
}
