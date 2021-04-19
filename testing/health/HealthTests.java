package health;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HealthTests {

  Exception exception;
  String sql;
  Connection connection;
  Statement statement;

  @BeforeEach
  public void setUp() throws ClassNotFoundException, SQLException {
    Class.forName("org.sqlite.JDBC");
    connection = DriverManager.getConnection("jdbc:sqlite:Health_Connect_DB");
  }

  @AfterEach
  public void tearDown() throws SQLException {
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
  public void testLaunch() throws Exception {

    // Testing if the application will launch with patients and doctors //
    Health.main(null);
  }

  @Test
  public void testWithoutPatients() throws SQLException {

    // Removing all patients from the database //
    sql = "DELETE FROM patient WHERE username = 'Andrew'";
    statement = connection.createStatement();
    statement.execute(sql);
    sql = "DELETE FROM patient WHERE username = 'Stephen'";
    statement = connection.createStatement();
    statement.execute(sql);

    // Should throw an exception because no patients exist //
    exception = assertThrows(Exception.class, () -> Health.main(null));
    assertEquals("No Patients Exist", exception.getMessage());

    // Adding the patients back into the database //
    sql = "INSERT INTO patient (username, password) VALUES ('Andrew', '12345')";
    statement = connection.createStatement();
    statement.execute(sql);
    sql = "INSERT INTO patient (username, password) VALUES ('Stephen', '67890')";
    statement = connection.createStatement();
    statement.execute(sql);
  }

  @Test
  public void testWithoutDoctors() throws SQLException {

    // Removing all doctors from the database //
    sql = "DELETE FROM doctor WHERE username = 'Liana'";
    statement = connection.createStatement();
    statement.execute(sql);
    sql = "DELETE FROM doctor WHERE username = 'Gianni'";
    statement = connection.createStatement();
    statement.execute(sql);

    // Should throw an exception because no doctors exist //
    exception = assertThrows(Exception.class, () -> Health.main(null));
    assertEquals("No Doctors Exist", exception.getMessage());

    // Adding the doctors back into the database //
    sql = "INSERT INTO doctor (username, password) VALUES ('Liana', '12345')";
    statement = connection.createStatement();
    statement.execute(sql);
    sql = "INSERT INTO doctor (username, password) VALUES ('Gianni', '67890')";
    statement = connection.createStatement();
    statement.execute(sql);
  }
}
