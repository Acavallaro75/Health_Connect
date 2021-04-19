package health;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static org.junit.jupiter.api.Assertions.*;

public class PatientViewTests {

  PatientView patientView;
  Exception exception;
  String sql;
  Connection connection;
  Statement statement;

  @BeforeEach
  public void setUp() throws Exception {
    Class.forName("org.sqlite.JDBC");
    connection = DriverManager.getConnection("jdbc:sqlite:Health_Connect_DB");
    patientView = new PatientView("Andrew");
  }

  @AfterEach
  public void tearDown() throws SQLException {
    patientView = null;
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
    patientView.setUsername("RANDOM USERNAME");
    assertEquals("RANDOM USERNAME", patientView.getUsername());
  }

  @Test
  public void testSetUsername() {

    // Testing an empty string for username which is invalid //
    exception = assertThrows(Exception.class, () -> patientView.setUsername(""));
    assertEquals("Invalid Username", exception.getMessage());

    // Testing a non-empty string for username which is valid //
    assertDoesNotThrow(() -> patientView.setUsername("Liana"));
  }

  @Test
  public void testGetRequestID() throws Exception {

    // Checking if the passing of parameters is working correctly for request ID //
    patientView.setRequestID(54321);
    assertEquals(54321, patientView.getRequestID());
  }

  @Test
  public void testSetRequestID() {

    // Testing a number less than 1 which is invalid //
    exception = assertThrows(Exception.class, () -> patientView.setRequestID(-5));
    assertEquals("Invalid Request ID", exception.getMessage());

    // Testing a number greater than 100000 which is invalid //
    exception = assertThrows(Exception.class, () -> patientView.setRequestID(150000));
    assertEquals("Invalid Request ID", exception.getMessage());

    // Testing a number between 1 and 100000 which is valid //
    assertDoesNotThrow(() -> patientView.setRequestID(500));
  }

  @Test
  public void testGetUserType() throws Exception {

    // Checking if the passing of parameters is working correctly for user type //
    patientView.setUserType("Patient");
    assertEquals("Patient", patientView.getUserType());
  }

  @Test
  public void testSetUserType() {

    // Testing input for anything other than "Doctor" //
    exception = assertThrows(Exception.class, () -> patientView.setUserType("Doctor"));
    assertEquals("Invalid User Type", exception.getMessage());

    // Testing input for "Doctor" which is the only valid input //
    assertDoesNotThrow(() -> patientView.setUserType("Patient"));
  }

  @Test
  public void testNewRequests() throws SQLException {

    // Adding a new request to the database to pass the test //
    sql =
        "INSERT INTO Request (RID, PUsername, Date, Status) VALUES ('100', 'Andrew', '04/19/2021', 'New')";
    statement = connection.createStatement();
    statement.execute(sql);
    patientView.newButtonActionPerformed(); // Sets test to true //
    assertTrue(patientView.test);

    // Adding multiple new requests to the database //
    sql =
        "INSERT INTO Request (RID, PUsername, Date, Status) VALUES ('101', 'Andrew', '04/20/2021', 'New')";
    statement = connection.createStatement();
    statement.execute(sql);
    patientView.newButtonActionPerformed(); // Sets test to true //
    assertTrue(patientView.test);

    // Removing the created request from the database to pass the test //
    sql = "DELETE FROM request WHERE pusername = 'Andrew'";
    statement = connection.createStatement();
    statement.execute(sql);
    patientView.newButtonActionPerformed(); // Sets test to false //
    assertFalse(patientView.test);
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

    patientView.InProgressButtonActionPerformed(); // Sets test to true //
    assertTrue(patientView.test);

    // Adding another in progress request to the database to pass the test //
    sql =
        "INSERT INTO Request (RID, PUsername, Date, Status) VALUES ('101', 'Andrew', '04/20/2021', 'In Progress')";
    statement = connection.createStatement();
    statement.execute(sql);

    // Adding a new message from the same patient from above //
    sql =
        "INSERT INTO message (rid, dusername, TimeStamp, message) VALUES ('101', 'Liana', '04/20/2021', 'Test Message 2')";
    statement.execute(sql);

    patientView.InProgressButtonActionPerformed(); // Sets test to true if results are found //
    assertTrue(patientView.test);

    // Deleting the messages and in progress requests //
    sql = "DELETE FROM message WHERE dusername = 'Liana'";
    statement = connection.createStatement();
    statement.execute(sql);
    sql = "DELETE FROM request WHERE pusername = 'Andrew'";
    statement = connection.createStatement();
    statement.execute(sql);

    patientView.InProgressButtonActionPerformed(); // Sets test to false if database is empty //
    assertFalse(patientView.test);
  }

  @Test
  public void testSelectedRequest() {

    // Not choosing a request at all //
    patientView.jList1.setSelectedIndex(2);
    exception = assertThrows(Exception.class, () -> patientView.openRequestActionPerformed());
    assertEquals("No Selection Made", exception.getMessage());
  }

  @Test
  public void testSelected() throws Exception {

    // Adding a new request to the database to pass the test //
    sql =
        "INSERT INTO Request (RID, PUsername, Date, Status) VALUES ('100', 'Andrew', '04/19/2021', 'New')";
    statement = connection.createStatement();
    statement.execute(sql);

    // Populating the new requests field //
    patientView.newButtonActionPerformed();

    // Choose new request number 1 //
    patientView.jList1.setSelectedIndex(1);
    patientView.openRequestActionPerformed();
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

    patientView.closedButtonActionPerformed(); // Sets test to true //
    assertTrue(patientView.test);

    // Adding another closed request to the database //
    sql =
        "INSERT INTO Request (RID, PUsername, Date, Status) VALUES ('101', 'Andrew', '04/20/2021', 'Closed')";
    statement = connection.createStatement();
    statement.execute(sql);

    // Adding a new message from the same patient from above //
    sql =
        "INSERT INTO message (rid, dusername, TimeStamp, message) VALUES ('101', 'Liana', '04/20/2021', 'Test Message 2')";
    statement.execute(sql);

    patientView.closedButtonActionPerformed(); // Sets test to true //
    assertTrue(patientView.test);

    sql = "DELETE FROM message WHERE dusername = 'Liana'";
    statement = connection.createStatement();
    statement.execute(sql);
    sql = "DELETE FROM request WHERE pusername = 'Andrew'";
    statement = connection.createStatement();
    statement.execute(sql);

    patientView.closedButtonActionPerformed(); // Sets test to false if database is empty //
    assertFalse(patientView.test);
  }

  @Test
  public void testLaunch() {

    // Testing if the program launches correctly //
    assertDoesNotThrow(() -> PatientView.main(null));
  }
}
