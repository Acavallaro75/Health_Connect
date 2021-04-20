package health;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Health {
  public static void main(String[] args) throws Exception {

    Connection connection;
    Class.forName("org.sqlite.JDBC");
    connection = DriverManager.getConnection("jdbc:sqlite:Health_Connect_DB");
    JOptionPane.showMessageDialog(null, "Connected");
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM PATIENT");

    if (resultSet.next()) {
      System.out.println("Username = " + resultSet.getString("Username"));
      System.out.println("Password = " + resultSet.getString("Password"));
      while (resultSet.next()) {
        System.out.println("Username = " + resultSet.getString("Username"));
        System.out.println("Password = " + resultSet.getString("Password"));
      }
    } else {
      JOptionPane.showMessageDialog(null, "No Patients Exist");
      throw new Exception("No Patients Exist");
    }

    resultSet = statement.executeQuery("SELECT * FROM Doctor");

    if (resultSet.next()) {
      System.out.println("Username = " + resultSet.getString("Username"));
      System.out.println("Password = " + resultSet.getString("Password"));
      while (resultSet.next()) {
        System.out.println("Username = " + resultSet.getString("Username"));
        System.out.println("Password = " + resultSet.getString("Password"));
      }
    } else {
      JOptionPane.showMessageDialog(null, "No Doctors Exist");
      throw new Exception("No Doctors Exist");
    }

    connection.close();
    statement.close();
    resultSet.close();

    // open login page
    NewJFrame jFrame = new NewJFrame();
    jFrame.setVisible(true);
  }
}
