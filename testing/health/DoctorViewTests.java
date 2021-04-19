package health;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoctorViewTests {

  DoctorView doctorView;

  @BeforeEach
  public void setUp() {
    doctorView = new DoctorView("Andrew");
  }

  @Test
  public void checkIfWorking() {
    assertEquals("Andrew", doctorView.getUsername());
  }
}
