package health;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static java.awt.Font.BOLD;
import static java.awt.Font.ITALIC;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class NewRequests extends JFrame {
  int requestNumber;
  int count = 100;
  String userID;
  String userType;
  Connection connection = null;
  ResultSet resultSet = null;
  PreparedStatement preparedStatement = null;

  public NewRequests(String new_userID) {
    initComponents();
    userID = new_userID;
    try {
      Class.forName("org.sqlite.JDBC");
      connection = DriverManager.getConnection("jdbc:sqlite:Health_Connect_DB");
      JOptionPane.showMessageDialog(null, "Connected");
      Statement statement = connection.createStatement();
      String sql = "SELECT RID FROM Request";
      resultSet = statement.executeQuery(sql);
      while (resultSet.next()) count++;
    } catch (ClassNotFoundException | SQLException e) {
      JOptionPane.showMessageDialog(null, e);
    } finally {
      try {
        resultSet.close();
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
      }
    }

    RequestID.setText("RequestID: " + count);
    PatientID.setText("PatientID: " + userID);
    jTextArea1.setLineWrap(true);
    jTextArea1.setWrapStyleWord(true);
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  private void initComponents() {

    JLabel jLabel6 = new JLabel();
    JLabel title = new JLabel();
    JScrollPane jScrollPane1 = new JScrollPane();
    jTextArea1 = new JTextArea();
    JButton createButton = new JButton();
    JButton cancelButton = new JButton();
    RequestID = new JLabel();
    PatientID = new JLabel();
    JLabel jLabel7 = new JLabel();

    jLabel6.setFont(new Font("Papyrus", BOLD, 14));
    jLabel6.setForeground(new Color(51, 51, 255));
    jLabel6.setText("HealthConnect");

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    title.setFont(new Font("Eras Demi ITC", ITALIC, 18));
    title.setText("Create a New Request");

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jTextArea1.setText("Insert new request here...");
    jScrollPane1.setViewportView(jTextArea1);

    createButton.setText("Create Request");
    createButton.addActionListener(this::createButtonActionPerformed);

    cancelButton.setText("Cancel");
    cancelButton.addActionListener(this::CancelButtonActionPerformed);

    RequestID.setText("Request ID:");

    PatientID.setText("Patient ID:");

    jLabel7.setFont(new Font("Papyrus", BOLD, 14));
    jLabel7.setForeground(new Color(51, 51, 255));
    jLabel7.setText("HealthConnect");

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(
                        jScrollPane1, GroupLayout.PREFERRED_SIZE, 592, GroupLayout.PREFERRED_SIZE)
                    .addGroup(
                        layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGap(41, 41, 41)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                RequestID,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                            .addComponent(
                                                PatientID,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                    .addContainerGap())
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                    .addGroup(
                                        layout
                                            .createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(
                                                cancelButton,
                                                GroupLayout.PREFERRED_SIZE,
                                                110,
                                                GroupLayout.PREFERRED_SIZE)
                                            .addComponent(createButton))
                                    .addContainerGap(56, Short.MAX_VALUE))))
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(
                        title, GroupLayout.PREFERRED_SIZE, 633, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(
                        LayoutStyle.ComponentPlacement.RELATED,
                        GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addComponent(
                        jLabel7, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(
                        RequestID, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(
                        PatientID, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                    .addGap(130, 130, 130)
                    .addComponent(
                        createButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(cancelButton, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addGap(173, 173, 173))
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGroup(
                        layout
                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(
                                title, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                    .addGap(18, 18, 18)
                    .addComponent(
                        jScrollPane1, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    pack();
  }

  private void createButtonActionPerformed(ActionEvent evt) {
    // TODO add your handling code here:
    int pane =
        JOptionPane.showConfirmDialog(
            null,
            "Are you sure you want to create the request?",
            "Create Request",
            JOptionPane.YES_NO_OPTION);
    if (pane == 0) {
      String sql = "INSERT INTO Message (RID, DUsername, TimeStamp, Message) VALUES (?, ?, ?, ?)";

      try {
        preparedStatement = connection.prepareStatement(sql);
        String temp = Integer.toString(count);
        preparedStatement.setString(1, temp);
        preparedStatement.setString(2, null);
        Date date = new Date();
        String timestamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
        preparedStatement.setString(3, timestamp);
        String finalString =
            "\n" + jTextArea1.getText() + "\n Added by " + "Patient" + " " + userID;
        preparedStatement.setString(4, finalString);
        preparedStatement.execute();
        JOptionPane.showMessageDialog(null, "Message created");
        sql = "INSERT INTO Request (RID, PUsername, Date, Status) VALUES (?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, temp);
        preparedStatement.setString(2, userID);
        preparedStatement.setString(3, timestamp);
        preparedStatement.setString(4, "New");
        preparedStatement.execute();
      } catch (SQLException | HeadlessException e) {
        JOptionPane.showMessageDialog(null, e);
      } finally {
        try {
          resultSet.close();
          preparedStatement.close();
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, e);
        }
      }
      PatientView patientView = new PatientView(userID);
      patientView.setVisible(true);
      dispose();
    }
  }

  private void CancelButtonActionPerformed(ActionEvent evt) {
    // TODO add your handling code here:
    Profile profile = new Profile(userID);
    profile.setVisible(true);
    dispose();
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
      Logger.getLogger(NewRequests.class.getName()).log(Level.SEVERE, null, ex);
    }

    NewJFrame n = new NewJFrame();
    final PatientView v = new PatientView(n.getUsername());
    /* Create and display the form */
    EventQueue.invokeLater(() -> new NewRequests(v.getUsername()).setVisible(true));
  }

  // Variable declarations //
  private JLabel PatientID;
  private JLabel RequestID;
  private JTextArea jTextArea1;
  // End of variables declaration //
}
