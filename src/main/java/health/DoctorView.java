package health;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import static java.awt.Font.BOLD;
import static java.awt.Font.ITALIC;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public final class DoctorView extends JFrame {
  Connection connection;
  ResultSet resultSet = null;
  PreparedStatement preparedStatement = null;
  int requestID;
  String username;
  String userType;
  public boolean test;
  DefaultListModel<String> defaultListModel = new DefaultListModel<>();

  public DoctorView(String doctor) throws Exception {
    initComponents();
    Class.forName("org.sqlite.JDBC");
    connection = DriverManager.getConnection("jdbc:sqlite:Health_Connect_DB");
    JOptionPane.showMessageDialog(null, "Connected");

    setUsername(doctor);
    setUserType("Doctor");
    welcome.setText("Welcome Back, " + username + "!");
    requestsList.setVisible(false);
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) throws Exception {
    if (username.length() >= 1) {
      this.username = username;
    } else {
      throw new Exception("Invalid Username");
    }
  }

  public int getRequestID() {
    return this.requestID;
  }

  public void setRequestID(int requestID) throws Exception {
    if (requestID >= 1 && requestID < 100000) {
      this.requestID = requestID;
    } else {
      throw new Exception("Invalid Request ID");
    }
  }

  public String getUserType() {
    return this.userType;
  }

  public void setUserType(String userType) throws Exception {
    if (userType.equalsIgnoreCase("Doctor")) {
      this.userType = userType;
    } else {
      throw new Exception("Invalid User Type");
    }
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  private void initComponents() {
    JLabel jLabel5 = new JLabel();
    JSeparator jSeparator1 = new JSeparator();
    JScrollPane jScrollPane1 = new JScrollPane();
    requestsList = new JList<>();
    viewedRequests = new JLabel();
    welcome = new JLabel();
    JLabel jLabel6 = new JLabel();
    JButton newRequestButton = new JButton();
    JButton inProgressButton = new JButton();
    JButton closeRequestButton = new JButton();
    JButton openSelectedButton = new JButton();
    JButton logout = new JButton();

    jLabel5.setFont(new Font("Papyrus", BOLD, 14));
    jLabel5.setForeground(new Color(51, 51, 255));
    jLabel5.setText("HealthConnect");

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    jScrollPane1.setViewportView(requestsList);

    viewedRequests.setFont(new Font("Eras Demi ITC", ITALIC, 18));
    viewedRequests.setText("Requests");

    welcome.setFont(new Font("Eras Demi ITC", ITALIC, 24));
    welcome.setText("Welcome Back");

    jLabel6.setFont(new Font("Papyrus", BOLD, 14));
    jLabel6.setForeground(new Color(51, 51, 255));
    jLabel6.setText("HealthConnect");

    newRequestButton.setText("New");
    newRequestButton.addActionListener(
        evt -> {
          try {
            newRequestButtonActionPerformed();
          } catch (Exception e) {
            e.printStackTrace();
          }
        });

    inProgressButton.setText("In Progress");
    inProgressButton.addActionListener(
        evt -> {
          try {
            inProgressButtonActionPerformed();
          } catch (Exception e) {
            e.printStackTrace();
          }
        });

    closeRequestButton.setText("Closed");
    closeRequestButton.addActionListener(
        evt -> {
          try {
            closeRequestButtonActionPerformed();
          } catch (Exception e) {
            e.printStackTrace();
          }
        });

    openSelectedButton.setText("Open Selected Request");
    openSelectedButton.addActionListener(
        evt -> {
          try {
            openSelectedButtonActionPerformed();
          } catch (Exception e) {
            e.printStackTrace();
          }
        });

    logout.setText("Logout");
    logout.addActionListener(
        evt -> {
          try {
            logoutActionPerformed();
          } catch (Exception e) {
            e.printStackTrace();
          }
        });

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addComponent(jSeparator1)
                                    .addContainerGap())
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        layout
                                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(
                                                viewedRequests,
                                                GroupLayout.PREFERRED_SIZE,
                                                201,
                                                GroupLayout.PREFERRED_SIZE)
                                            .addGroup(
                                                layout
                                                    .createSequentialGroup()
                                                    .addComponent(
                                                        jScrollPane1,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        577,
                                                        GroupLayout.PREFERRED_SIZE)
                                                    .addGap(39, 39, 39)
                                                    .addGroup(
                                                        layout
                                                            .createParallelGroup(
                                                                GroupLayout.Alignment.LEADING,
                                                                false)
                                                            .addComponent(
                                                                closeRequestButton,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                            .addComponent(
                                                                inProgressButton,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                94,
                                                                Short.MAX_VALUE)
                                                            .addComponent(
                                                                newRequestButton,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE))))
                                    .addGap(0, 34, Short.MAX_VALUE))
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addComponent(
                                        welcome,
                                        GroupLayout.PREFERRED_SIZE,
                                        593,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(
                                        LayoutStyle.ComponentPlacement.RELATED,
                                        GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                    .addComponent(
                                        jLabel6,
                                        GroupLayout.PREFERRED_SIZE,
                                        124,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addGap(1, 1, 1))))
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(201, 201, 201)
                    .addComponent(
                        openSelectedButton,
                        GroupLayout.PREFERRED_SIZE,
                        219,
                        GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(289, 658, Short.MAX_VALUE)
                    .addComponent(logout)
                    .addGap(31, 31, 31)));
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
                                    .addContainerGap()
                                    .addComponent(welcome))
                            .addComponent(jLabel6))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(logout)
                    .addGap(18, 18, 18)
                    .addComponent(
                        jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(
                        LayoutStyle.ComponentPlacement.RELATED,
                        GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addComponent(
                        viewedRequests, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(
                        layout
                            .createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(
                                layout
                                    .createSequentialGroup()
                                    .addComponent(
                                        newRequestButton,
                                        GroupLayout.PREFERRED_SIZE,
                                        38,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addGap(79, 79, 79)
                                    .addComponent(
                                        inProgressButton,
                                        GroupLayout.PREFERRED_SIZE,
                                        39,
                                        GroupLayout.PREFERRED_SIZE)
                                    .addGap(74, 74, 74)
                                    .addComponent(
                                        closeRequestButton,
                                        GroupLayout.PREFERRED_SIZE,
                                        39,
                                        GroupLayout.PREFERRED_SIZE))
                            .addComponent(
                                jScrollPane1,
                                GroupLayout.PREFERRED_SIZE,
                                296,
                                GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(
                        openSelectedButton,
                        GroupLayout.PREFERRED_SIZE,
                        53,
                        GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()));
    pack();
  }

  public void newRequestButtonActionPerformed() throws SQLException {
    viewedRequests.setText("New Requests");
    requestsList.setVisible(true);
    String element;
    String sql = "SELECT * FROM REQUEST WHERE Status = ?";
    defaultListModel.removeAllElements();
    element = "RID        Date                                        Patient Username";
    defaultListModel.addElement(element);
    preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, "New");
    resultSet = preparedStatement.executeQuery();
    if (resultSet.next()) {
      JOptionPane.showMessageDialog(null, "Username and password is correct");
      element =
          resultSet.getString("RID")
              + "        "
              + resultSet.getString("Date")
              + "           "
              + resultSet.getString("PUsername");
      defaultListModel.addElement(element);
      test = true;
      while (resultSet.next()) {
        element =
            resultSet.getString("RID")
                + "        "
                + resultSet.getString("Date")
                + "           "
                + resultSet.getString("PUsername");
        defaultListModel.addElement(element);
      }
      requestsList.setModel(defaultListModel);
    } else {
      JOptionPane.showMessageDialog(null, "No new requests created.");
      test = false;
    }
    resultSet.close();
    preparedStatement.close();
  }

  public void inProgressButtonActionPerformed() throws SQLException {
    viewedRequests.setText("In Progress Requests");
    requestsList.setVisible(true);
    String element;
    String sql =
        "SELECT DISTINCT Request.RID, Date, PUsername FROM Request, Message WHERE Request.RID = Message.RID AND Request.Status = ? AND Message.DUsername = ?";
    defaultListModel.removeAllElements();
    element = "RID        Date                                        Patient Username";
    defaultListModel.addElement(element);

    preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, "In Progress");
    preparedStatement.setString(2, username);
    resultSet = preparedStatement.executeQuery();
    if (resultSet.next()) {
      test = true;
      JOptionPane.showMessageDialog(null, "Username and Password is correct");
      element =
          resultSet.getString("rid")
              + "        "
              + resultSet.getString("Date")
              + "           "
              + resultSet.getString("PUsername");
      defaultListModel.addElement(element);
      while (resultSet.next()) {
        element =
            resultSet.getString("rid")
                + "        "
                + resultSet.getString("Date")
                + "           "
                + resultSet.getString("PUsername");
        defaultListModel.addElement(element);
      }
      requestsList.setModel(defaultListModel);
    } else {
      test = false;
      JOptionPane.showMessageDialog(null, "No requests are in progress");
    }
    resultSet.close();
    preparedStatement.close();
  }

  public void openSelectedButtonActionPerformed() throws Exception {
    if (requestsList.getSelectedIndex() == -1) {
      JOptionPane.showMessageDialog(null, "Please select a request");
      throw new Exception("No Selection Made");
    } else {
      String temp_requestID = requestsList.getSelectedValue().toString();
      temp_requestID = temp_requestID.substring(0, 3);
      requestID = Integer.parseInt(temp_requestID);
      setRequestID(requestID);

      RequestConversation requestConversation =
          new RequestConversation(requestID, username, userType);
      dispose();
      requestConversation.setVisible(true);
    }
    resultSet.close();
    preparedStatement.close();
  }

  public void closeRequestButtonActionPerformed() throws SQLException {
    viewedRequests.setText("Closed Requests");
    requestsList.setVisible(true);
    String element;
    String sql =
        "SELECT DISTINCT Request.RID, Date, PUsername FROM Request, Message WHERE Request.RID = Message.RID AND Request.Status = ? AND Message.DUsername = ?";
    defaultListModel.removeAllElements();
    element = "RID        Date                                        Patient Username";
    defaultListModel.addElement(element);
    preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, "Closed");
    preparedStatement.setString(2, username);
    resultSet = preparedStatement.executeQuery();
    if (resultSet.next()) {
      test = true;
      JOptionPane.showMessageDialog(null, "Username and password is correct");
      element =
          resultSet.getString("RID")
              + "        "
              + resultSet.getString("Date")
              + "           "
              + resultSet.getString("PUsername");
      defaultListModel.addElement(element);
      while (resultSet.next()) {
        element =
            resultSet.getString("RID")
                + "        "
                + resultSet.getString("Date")
                + "           "
                + resultSet.getString("PUsername");
        defaultListModel.addElement(element);
      }
      requestsList.setModel(defaultListModel);
    } else {
      test = false;
      JOptionPane.showMessageDialog(null, "No requests have been closed.");
    }
    resultSet.close();
    preparedStatement.close();
  }

  public void logoutActionPerformed() throws SQLException {
    if (resultSet != null && preparedStatement != null) {
      resultSet.close();
      preparedStatement.close();
    }
    int pane =
        JOptionPane.showConfirmDialog(
            null, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
    if (pane == 0) {
      dispose();
      NewJFrame jFrame = new NewJFrame();
      jFrame.setVisible(true);
    }
  }

  public static void main(String[] args)
      throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException,
          IllegalAccessException {
    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
      if ("Nimbus".equals(info.getName())) {
        UIManager.setLookAndFeel(info.getClassName());
        break;
      }
    }
  }

  // Variables declaration //
  public JList requestsList;
  private JLabel viewedRequests;
  private JLabel welcome;
  // End of variables declaration //
}
