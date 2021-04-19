package health;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NewJFrameTests {

  NewJFrame newJFrame;
  Exception exception;

  @BeforeEach
  public void setUp() {
    newJFrame = new NewJFrame();
  }

  @AfterEach
  public void tearDown() {
    newJFrame = null;
  }

  @Test
  public void incorrectDoctorLogin() {

    // Username blank //
    newJFrame.txt_username.setText("");
    newJFrame.txt_password.setText("INCORRECT PASSWORD");

    // Testing the login with the above values //
    exception = assertThrows(Exception.class, () -> newJFrame.LoginAsDoctorActionPerformed());
    assertEquals("Username or Password cannot be left blank", exception.getMessage());

    // Password blank //
    newJFrame.txt_username.setText("INCORRECT USERNAME");
    newJFrame.txt_password.setText("");

    // Testing the login with the above values //
    exception = assertThrows(Exception.class, () -> newJFrame.LoginAsDoctorActionPerformed());
    assertEquals("Username or Password cannot be left blank", exception.getMessage());

    // Username and password blank //
    newJFrame.txt_username.setText("");
    newJFrame.txt_password.setText("");

    // Testing the login with the above values //
    exception = assertThrows(Exception.class, () -> newJFrame.LoginAsDoctorActionPerformed());
    assertEquals("Username or Password cannot be left blank", exception.getMessage());

    // Incorrect credentials //
    newJFrame.txt_username.setText("INCORRECT USERNAME");
    newJFrame.txt_password.setText("INCORRECT PASSWORD");

    // Testing the login with the above values //
    exception = assertThrows(Exception.class, () -> newJFrame.LoginAsDoctorActionPerformed());
    assertEquals("Incorrect username or password", exception.getMessage());
  }

  @Test
  public void correctDoctorLogin() {

    // Correct username and password for a doctor //
    newJFrame.txt_username.setText("Liana");
    newJFrame.txt_password.setText("12345");

    // Testing the login with the above values //
    assertDoesNotThrow(() -> newJFrame.LoginAsDoctorActionPerformed());
  }

  @Test
  public void incorrectPatientLogin() {

    // Username blank //
    newJFrame.txt_username.setText("");
    newJFrame.txt_password.setText("INCORRECT PASSWORD");

    // Testing the login with the above values //
    exception = assertThrows(Exception.class, () -> newJFrame.LoginAsPatientActionPerformed());
    assertEquals("Username or Password cannot be left blank", exception.getMessage());

    // Password blank //
    newJFrame.txt_username.setText("INCORRECT USERNAME");
    newJFrame.txt_password.setText("");

    // Testing the login with the above values //
    exception = assertThrows(Exception.class, () -> newJFrame.LoginAsPatientActionPerformed());
    assertEquals("Username or Password cannot be left blank", exception.getMessage());

    // Username and password blank //
    newJFrame.txt_username.setText("");
    newJFrame.txt_password.setText("");

    // Testing the login with the above values //
    exception = assertThrows(Exception.class, () -> newJFrame.LoginAsPatientActionPerformed());
    assertEquals("Username or Password cannot be left blank", exception.getMessage());

    // Incorrect credentials //
    newJFrame.txt_username.setText("INCORRECT USERNAME");
    newJFrame.txt_password.setText("INCORRECT PASSWORD");

    // Testing the login with the above values //
    exception = assertThrows(Exception.class, () -> newJFrame.LoginAsPatientActionPerformed());
    assertEquals("Incorrect username or password", exception.getMessage());
  }

  @Test
  public void correctPatientLogin() {

    // Correct username and password for a patient //
    newJFrame.txt_username.setText("Andrew");
    newJFrame.txt_password.setText("12345");

    // Testing the login with the above values //
    assertDoesNotThrow(() -> newJFrame.LoginAsPatientActionPerformed());
  }

  @Test
  public void testLaunch() {

    // Test if the program launches successfully //
    assertDoesNotThrow(() -> NewJFrame.main(null));
  }

  @Test
  public void testSetAndGetUsername() throws Exception {

    // Setting the username to Andrew //
    newJFrame.setUsername("Andrew");
    assertEquals("Andrew", newJFrame.getUsername());

    // Setting a blank username will cause an exception //
    exception = assertThrows(Exception.class, () -> newJFrame.setUsername(""));
    assertEquals("Username cannot be empty", exception.getMessage());
  }
}
