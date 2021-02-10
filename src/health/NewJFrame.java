/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package health;

import java.awt.Toolkit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
import java.sql.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.awt.Font.*;

public class NewJFrame extends JFrame {
  Connection connection = null;
  ResultSet resultSet = null;
  PreparedStatement preparedStatement = null;
  int currentRow = 0;
  private String username;

  /** Creates new form NewJFrame */
  public NewJFrame() {
    initComponents();
    try {
      Class.forName("org.sqlite.JDBC");
      connection =
          DriverManager.getConnection(
              "jdbc:sqlite:C:\\Users\\Andrea\\Documents\\NetBeansProjects\\health.sqlite");
      JOptionPane.showMessageDialog(null, "Connected");
      Statement statement = connection.createStatement();
    } catch (ClassNotFoundException | SQLException e) {
      JOptionPane.showMessageDialog(null, e);
    }
    Toolkit toolkit = getToolkit();
    Dimension size = toolkit.getScreenSize();
    setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = this.txt_username.getText();
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  // <editor-fold default state="collapsed" desc="Generated Code">
  private void initComponents() {
    JLabel jLabel1 = new JLabel();
    txt_username = new JTextField();
    JLabel jLabel2 = new JLabel();
    JButton loginAsPatient = new JButton();
    JButton loginAsDoctor = new JButton();
    JLabel jLabel3 = new JLabel();
    txt_password = new JPasswordField();
    JSeparator jSeparator1 = new JSeparator();
    JLabel jLabel4 = new JLabel();

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setFont(new Font("Courier New", PLAIN, 12)); // NOI18N
    jLabel1.setText("Username");

    txt_username.addActionListener(this::txt_usernameActionPerformed);

    jLabel2.setFont(new Font("Courier New", PLAIN, 12)); // NOI18N
    jLabel2.setText("Password");

    loginAsPatient.setText("Login as Patient");
    loginAsPatient.addActionListener(this::LoginAsPatientActionPerformed);

    loginAsDoctor.setText("Login as Doctor");
    loginAsDoctor.addActionListener(this::LoginAsDoctorActionPerformed);

    jLabel3.setFont(new Font("Eras Demi ITC", ITALIC, 24)); // NOI18N
    jLabel3.setText("Login");

    txt_password.addActionListener(this::txt_passwordActionPerformed);

    jLabel4.setFont(new Font("Papyrus", BOLD, 14)); // NOI18N
    jLabel4.setForeground(new Color(51, 51, 255));
    jLabel4.setText("HealthConnect");

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(
                        jLabel3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addComponent(loginAsPatient)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(loginAsDoctor))
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                GroupLayout.Alignment.LEADING,
                                                                false)
                                                            .addComponent(
                                                                jLabel2,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                            .addComponent(
                                                                jLabel1,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE))
                                                    .addPreferredGap(
                                                        LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                GroupLayout.Alignment.LEADING,
                                                                false)
                                                            .addComponent(txt_username)
                                                            .addComponent(
                                                                txt_password,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                151,
                                                                Short.MAX_VALUE))))
                                    .addContainerGap(84, Short.MAX_VALUE))))
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(
                        jLabel4, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGroup(
                        layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(
                                        jSeparator1,
                                        GroupLayout.PREFERRED_SIZE,
                                        10,
                                        GroupLayout.PREFERRED_SIZE))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel3)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        layout
                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                txt_username,
                                GroupLayout.PREFERRED_SIZE,
                                27,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(
                                jLabel1,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(
                        layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(
                                jLabel2,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                txt_password, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                    .addGap(33, 33, 33)
                    .addGroup(
                        layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addComponent(loginAsDoctor)
                                    .addGap(18, 18, Short.MAX_VALUE)
                                    .addComponent(jLabel4))
                            .addComponent(loginAsPatient))));
    pack();
  } // </editor-fold>

  private void LoginAsPatientActionPerformed(ActionEvent evt) {
    // TODO add your handling code here:
    String sql = "SELECT * FROM Patient WHERE username = ? AND password = ?";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, txt_username.getText());
      preparedStatement.setString(2, txt_password.getText());
      username = txt_username.getText();
      setUsername(username);
      JOptionPane.showMessageDialog(null, "Username = " + username);
      resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        JOptionPane.showMessageDialog(null, "Username and Password is correct");
        Profile profile = new Profile(username);
        profile.setVisible(true);
        dispose();
      } else {
        JOptionPane.showMessageDialog(null, "Incorrect username or password.  Please try again.");
      }
    } catch (HeadlessException | SQLException e) {
      JOptionPane.showMessageDialog(null, e);
    } finally {
      try {
        resultSet.close();
        preparedStatement.close();
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
      }
    }
  }

  private void LoginAsDoctorActionPerformed(ActionEvent evt) {
    // TODO add your handling code here:
    String sql = "SELECT * FROM Doctor WHERE username = ? AND password = ?";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, txt_username.getText());
      preparedStatement.setString(2, txt_password.getText());
      username = txt_username.getText();
      setUsername(username);

      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        JOptionPane.showMessageDialog(null, "Username and Password is correct");
        DoctorView d = new DoctorView(username);
        d.setVisible(true);
        dispose();
      } else {
        JOptionPane.showMessageDialog(null, "Incorrect username or password.  Please try again.");
      }
    } catch (HeadlessException | SQLException e) {
      JOptionPane.showMessageDialog(null, e);
    } finally {
      try {
        resultSet.close();
        preparedStatement.close();
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
      }
    }
  }

  private void txt_usernameActionPerformed(ActionEvent evt) {
    // TODO add your handling code here:
  }

  private void txt_passwordActionPerformed(ActionEvent evt) {
    // TODO add your handling code here:
  }

  /** @param args the command line arguments */
  public static void main(String[] args) {
    /* Set the Nimbus look and feel */
    // <editor-fold default state="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
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
      Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    EventQueue.invokeLater(() -> new NewJFrame().setVisible(true));
  }

  private JPasswordField txt_password;
  public JTextField txt_username;
  // End of variables declaration
}
