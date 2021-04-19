package health;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static org.junit.jupiter.api.Assertions.*;

public class DoctorViewTests {

  DoctorView doctorView;
  Exception exception;
  String sql;
  Connection connection;
  Statement statement;

  @BeforeEach
  public void setUp() throws Exception {
    Class.forName("org.sqlite.JDBC");
    connection = DriverManager.getConnection("jdbc:sqlite:Health_Connect_DB");
    doctorView = new DoctorView("Liana");
  }

  @AfterEach
  public void tearDown() throws SQLException {
    doctorView = null;
    exception = null;
    sql = null;
    if (connection != null) {
      connection.close();
    }
    if (statement != null) {
      statement.close();
    }
  }

  @Test
  public void testGetUsername() throws Exception {

    // Checking if the passing of parameters is working correctly for username //
    doctorView.setUsername("RANDOM USERNAME");
    assertEquals("RANDOM USERNAME", doctorView.getUsername());
  }

  @Test
  public void testSetUsername() {

    // Testing an empty string for username which is invalid //
    exception = assertThrows(Exception.class, () -> doctorView.setUsername(""));
    assertEquals("Invalid Username", exception.getMessage());

    // Testing a non-empty string for username which is valid //
    assertDoesNotThrow(() -> doctorView.setUsername("Liana"));
  }

  @Test
  public void testGetRequestID() throws Exception {

    // Checking if the passing of parameters is working correctly for request ID //
    doctorView.setRequestID(54321);
    assertEquals(54321, doctorView.getRequestID());
  }

  @Test
  public void testSetRequestID() {

    // Testing a number less than 1 which is invalid //
    exception = assertThrows(Exception.class, () -> doctorView.setRequestID(-5));
    assertEquals("Invalid Request ID", exception.getMessage());

    // Testing a number greater than 100000 which is invalid //
    exception = assertThrows(Exception.class, () -> doctorView.setRequestID(150000));
    assertEquals("Invalid Request ID", exception.getMessage());

    // Testing a number between 1 and 100000 which is valid //
    assertDoesNotThrow(() -> doctorView.setRequestID(500));
  }

  @Test
  public void testGetUserType() throws Exception {

    // Checking if the passing of parameters is working correctly for user type //
    doctorView.setUserType("Doctor");
    assertEquals("Doctor", doctorView.getUserType());
  }

  @Test
  public void testSetUserType() {

    // Testing input for anything other than "Doctor" //
    exception = assertThrows(Exception.class, () -> doctorView.setUserType("Patient"));
    assertEquals("Invalid User Type", exception.getMessage());

    // Testing input for "Doctor" which is the only valid input //
    assertDoesNotThrow(() -> doctorView.setUserType("Doctor"));
  }

  @Test
  public void testNewRequests() throws SQLException {

    // Adding a new request to the database to pass the test //
    sql =
        "INSERT INTO Request (RID, PUsername, Date, Status) VALUES ('100', 'Andrew', '04/19/2021', 'New')";
    statement = connection.createStatement();
    statement.execute(sql);
    doctorView.newRequestButtonActionPerformed(); // Sets test to true //
    assertTrue(doctorView.test);

    // Adding multiple new requests to the database //
    sql =
        "INSERT INTO Request (RID, PUsername, Date, Status) VALUES ('101', 'Andrew', '04/20/2021', 'New')";
    statement = connection.createStatement();
    statement.execute(sql);
    doctorView.newRequestButtonActionPerformed(); // Sets test to true //
    assertTrue(doctorView.test);

    // Removing the created request from the database to pass the test //
    sql = "DELETE FROM request WHERE pusername = 'Andrew'";
    statement = connection.createStatement();
    statement.execute(sql);
    doctorView.newRequestButtonActionPerformed(); // Sets test to false //
    assertFalse(doctorView.test);
  }

  @Test
  public void testInProgressRequests() throws SQLException {

    // Adding an in progress request to the database to pass the test //
    sql =
        "INSERT INTO Request (RID, PUsername, Date, Status) VALUES ('100', 'Andrew', '04/19/2021', 'In Progress')";
    statement = connection.createStatement();
    statement.execute(sql);

    // Adding a new message from the same patient from above //
    sql =
        "INSERT INTO message (rid, dusername, TimeStamp, message) VALUES ('100', 'Liana', '04/19/2021', 'Test Message')";
    statement.execute(sql);

    doctorView.inProgressButtonActionPerformed(); // Sets test to true //
    assertTrue(doctorView.test);

    // Adding another in progress request to the database to pass the test //
    sql =
        "INSERT INTO Request (RID, PUsername, Date, Status) VALUES ('101', 'Andrew', '04/20/2021', 'In Progress')";
    statement = connection.createStatement();
    statement.execute(sql);

    // Adding a new message from the same patient from above //
    sql =
        "INSERT INTO message (rid, dusername, TimeStamp, message) VALUES ('101', 'Liana', '04/20/2021', 'Test Message 2')";
    statement.execute(sql);

    doctorView.inProgressButtonActionPerformed(); // Sets test to true if results are found //
    assertTrue(doctorView.test);

    // Deleting the messages and in progress requests //
    sql = "DELETE FROM message WHERE dusername = 'Liana'";
    statement = connection.createStatement();
    statement.execute(sql);
    sql = "DELETE FROM request WHERE pusername = 'Andrew'";
    statement = connection.createStatement();
    statement.execute(sql);

    doctorView.inProgressButtonActionPerformed(); // Sets test to false if database is empty //
    assertFalse(doctorView.test);
  }

  @Test
  public void testSelectedRequest() throws Exception {

    // Not choosing a request at all //
    doctorView.requestsList.setSelectedIndex(2);
    exception = assertThrows(Exception.class, () -> doctorView.openSelectedButtonActionPerformed());
    assertEquals("No Selection Made", exception.getMessage());

    // Adding a new request to the database to pass the test //
    sql =
        "INSERT INTO Request (RID, PUsername, Date, Status) VALUES ('100', 'Andrew', '04/19/2021', 'New')";
    statement = connection.createStatement();
    statement.execute(sql);

    // Populating the new requests field //
    doctorView.newRequestButtonActionPerformed();

    // Choose new request number 1 //
    doctorView.requestsList.setSelectedIndex(1);
    doctorView.openSelectedButtonActionPerformed();

    // Removing the new request from the database //
    sql = "DELETE FROM request WHERE pusername = 'Andrew'";
    statement = connection.createStatement();
    statement.execute(sql);

    // Adding an in progress request to the database to pass the test //
    sql =
        "INSERT INTO Request (RID, PUsername, Date, Status) VALUES ('100', 'Andrew', '04/19/2021', 'In Progress')";
    statement = connection.createStatement();
    statement.execute(sql);

    // Adding a new message from the same patient from above //
    sql =
        "INSERT INTO message (rid, dusername, TimeStamp, message) VALUES ('100', 'Liana', '04/19/2021', 'Test Message')";
    statement.execute(sql);

    doctorView.inProgressButtonActionPerformed();

    // Choose in progress request number 1 //
    doctorView.requestsList.setSelectedIndex(1);
    doctorView.openSelectedButtonActionPerformed();

    // Removing the in progress request and message from the database //
    sql = "DELETE FROM message WHERE dusername = 'Liana'";
    statement = connection.createStatement();
    statement.execute(sql);
    sql = "DELETE FROM request WHERE pusername = 'Andrew'";
    statement = connection.createStatement();
    statement.execute(sql);
  }

  @Test
  public void testLogout() throws SQLException {

    // Open result set and prepared statement //
    sql = "SELECT * FROM doctor WHERE username = ?";
    doctorView.preparedStatement = connection.prepareStatement(sql);
    doctorView.preparedStatement.setString(1, "Liana");
    doctorView.resultSet = doctorView.preparedStatement.executeQuery();

    assertDoesNotThrow(() -> doctorView.logoutActionPerformed()); // Choose yes //

    // Close the result set and prepared statement //
    doctorView.resultSet.close();
    doctorView.preparedStatement.close();

    assertDoesNotThrow(() -> doctorView.logoutActionPerformed()); // Choose no //
  }

  @Test
  public void testClosedRequests() throws SQLException {

    // Adding a closed request to the database //
    sql =
        "INSERT INTO Request (RID, PUsername, Date, Status) VALUES ('100', 'Andrew', '04/19/2021', 'Closed')";
    statement = connection.createStatement();
    statement.execute(sql);

    // Adding a new message from the same patient from above //
    sql =
        "INSERT INTO message (rid, dusername, TimeStamp, message) VALUES ('100', 'Liana', '04/19/2021', 'Test Message')";
    statement.execute(sql);

    doctorView.closeRequestButtonActionPerformed(); // Sets test to true //
    assertTrue(doctorView.test);

    // Adding another closed request to the database //
    sql =
        "INSERT INTO Request (RID, PUsername, Date, Status) VALUES ('101', 'Andrew', '04/20/2021', 'Closed')";
    statement = connection.createStatement();
    statement.execute(sql);

    // Adding a new message from the same patient from above //
    sql =
        "INSERT INTO message (rid, dusername, TimeStamp, message) VALUES ('101', 'Liana', '04/20/2021', 'Test Message 2')";
    statement.execute(sql);

    doctorView.closeRequestButtonActionPerformed(); // Sets test to true //
    assertTrue(doctorView.test);

    sql = "DELETE FROM message WHERE dusername = 'Liana'";
    statement = connection.createStatement();
    statement.execute(sql);
    sql = "DELETE FROM request WHERE pusername = 'Andrew'";
    statement = connection.createStatement();
    statement.execute(sql);

    doctorView.closeRequestButtonActionPerformed(); // Sets test to false if database is empty //
    assertFalse(doctorView.test);
  }

  @Test
  public void testLaunch() {

    // Testing if the program launches correctly //
    assertDoesNotThrow(() -> DoctorView.main(null));
  }
}
