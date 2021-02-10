/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package health;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Health {

  /** @param args the command line arguments */
  public static void main(String[] args) {
    // TODO code application logic here

    @SuppressWarnings("UnusedAssignment")
    // test connection
    Connection connection = null;
    try {
      Class.forName("org.sqlite.JDBC");
      connection =
          DriverManager.getConnection(
              "jdbc:sqlite:C:\\Users\\Andrea\\Documents\\NetBeansProjects\\health.sqlite");
      JOptionPane.showMessageDialog(null, "Connected");
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM Patient");

      while (resultSet.next()) {
        System.out.println("Username = " + resultSet.getString("Username"));
        System.out.println("Password = " + resultSet.getString("Password"));
      }

      resultSet = statement.executeQuery("SELECT * FROM Doctor");

      while (resultSet.next()) {
        System.out.println("Username = " + resultSet.getString("Username"));
        System.out.println("Password = " + resultSet.getString("Password"));
      }
      // open login page
      NewJFrame jFrame = new NewJFrame();
      jFrame.setVisible(true);
    } catch (ClassNotFoundException | SQLException e) {
      JOptionPane.showMessageDialog(null, e);
    }
  }
}
