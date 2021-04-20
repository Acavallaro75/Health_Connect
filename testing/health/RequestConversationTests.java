package health;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RequestConversationTests {

  RequestConversation requestConversation;
  Exception exception;
  String sql;
  Connection connection;

  @BeforeEach
  public void setUp() throws Exception {
    Class.forName("org.sqlite.JDBC");
    connection = DriverManager.getConnection("jdbc:sqlite:Health_Connect_DB");
    requestConversation = new RequestConversation(100, "100", "Doctor");
  }

  @AfterEach
  public void tearDown() {
    requestConversation = null;
    exception = null;
    sql = null;
  }

  @Test
  public void testClose() {

    assertDoesNotThrow(() -> requestConversation.closeButtonActionPerformed());
    assertDoesNotThrow(() -> requestConversation.closeButtonActionPerformed());
  }

  @Test
  public void testAddMessage() {

    assertDoesNotThrow(() -> requestConversation.addButtonActionPerformed());
    assertDoesNotThrow(() -> requestConversation.addButtonActionPerformed());
  }

  @Test
  public void testLaunch() {

    assertDoesNotThrow(() -> RequestConversation.main(null));
  }
}
