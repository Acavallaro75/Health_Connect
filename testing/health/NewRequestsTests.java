package health;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class NewRequestsTests {

  NewRequests newRequests;
  String sql;
  Connection connection;
  Statement statement;

  @BeforeEach
  public void setUp() throws SQLException, ClassNotFoundException {

    Class.forName("org.sqlite.JDBC");
    connection = DriverManager.getConnection("jdbc:sqlite:Health_Connect_DB");
    sql =
        "INSERT INTO request (status, rid, pusername, date) VALUES ('New', '100', 'Andrew', '04/19/2021')";
    statement = connection.createStatement();
    statement.execute(sql);
    newRequests = new NewRequests("100");
  }

  @AfterEach
  public void tearDown() throws SQLException {
    newRequests = null;
    sql = "DELETE FROM request WHERE status = 'New'";
    statement = connection.createStatement();
    statement.execute(sql);
    sql = "DELETE FROM message WHERE dusername IS NULL";
    statement = connection.createStatement();
    statement.execute(sql);
    if (connection != null) {
      connection.close();
    }
    if (statement != null) {
      statement = null;
    }
  }

  @Test
  public void testCreateRequest() {

    Exception exception;

    // No message added to text area //
    exception = assertThrows(Exception.class, () -> newRequests.createButtonActionPerformed());
    assertEquals("No Message Added", exception.getMessage());

    // Blank text area (no message) //
    newRequests.jTextArea1.setText("");
    exception = assertThrows(Exception.class, () -> newRequests.createButtonActionPerformed());
    assertEquals("No Message Added", exception.getMessage());

    // Setting a message in the text area //
    newRequests.jTextArea1.setText("THIS IS AN EXAMPLE MESSAGE");
    assertDoesNotThrow(() -> newRequests.createButtonActionPerformed());
  }

  @Test
  public void testCancel() {

    // If the 'yes' button is selected //
    newRequests.CancelButtonActionPerformed(null);
    assertTrue(newRequests.test);

    // If the 'no' button is selected //
    newRequests.CancelButtonActionPerformed(null);
    assertFalse(newRequests.test);
  }

  @Test
  public void testLaunch() {

    // Testing if the program launches correctly //
    assertDoesNotThrow(() -> NewRequests.main(null));
  }
}
