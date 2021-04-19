package health;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ProfileTest {

  Profile profile;

  @BeforeEach
  public void setUp() {
    profile = new Profile("Andrew");
  }

  @AfterEach
  public void tearDown() {
    profile = null;
  }

  @Test
  public void testMakeRequest() {

    // Testing that program launches the new window correctly //
    assertDoesNotThrow(() -> profile.makeRequestButtonActionPerformed());
  }

  @Test
  public void testViewRequests() {

    // Testing that program launches the new window correctly //
    assertDoesNotThrow(() -> profile.viewRequestButtonActionPerformed());
  }

  @Test
  public void testLogout() {

    // Testing that program launches the new window correctly //
    assertDoesNotThrow(() -> profile.logoutActionPerformed(null));

    // Testing that program launches the new window correctly //
    assertDoesNotThrow(() -> profile.logoutActionPerformed(null));
  }

  @Test
  public void testLaunch() {

    // Testing if the program launches correctly //
    assertDoesNotThrow(() -> Profile.main(null));
  }
}
