package health;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AllTests {

  DoctorViewTests doctorViewTests;
  HealthTests healthTests;
  NewJFrameTests newJFrameTests;
  NewRequestsTests newRequestsTests;
  PatientViewTests patientViewTests;
  ProfileTest profileTest;
  RequestConversationTests requestConversationTests;

  @BeforeEach
  public void setUp() {
    doctorViewTests = new DoctorViewTests();
    healthTests = new HealthTests();
    newJFrameTests = new NewJFrameTests();
    newRequestsTests = new NewRequestsTests();
    patientViewTests = new PatientViewTests();
    profileTest = new ProfileTest();
    requestConversationTests = new RequestConversationTests();
  }

  @AfterEach
  public void tearDown() {
    doctorViewTests = null;
    healthTests = null;
    newJFrameTests = null;
    newRequestsTests = null;
    patientViewTests = null;
    profileTest = null;
    requestConversationTests = null;
  }

  @Test
  public void allTests() throws Exception {

    // Testing set user type //
    doctorViewTests.setUp();
    doctorViewTests.testSetUserType();
    doctorViewTests.tearDown();

    // Testing set username //
    doctorViewTests.setUp();
    doctorViewTests.testSetUsername();
    doctorViewTests.tearDown();

    // Testing set request ID //
    doctorViewTests.setUp();
    doctorViewTests.testSetRequestID();
    doctorViewTests.tearDown();

    // Testing a selected request //
    doctorViewTests.setUp();
    doctorViewTests.testSelectedRequest();
    doctorViewTests.tearDown();

    // Testing closing a request //
    doctorViewTests.setUp();
    doctorViewTests.testClosedRequests();
    doctorViewTests.tearDown();

    // Testing getting a request ID //
    doctorViewTests.setUp();
    doctorViewTests.testGetRequestID();
    doctorViewTests.tearDown();

    // Testing get username //
    doctorViewTests.setUp();
    doctorViewTests.testGetUsername();
    doctorViewTests.tearDown();

    // Testing get user type //
    doctorViewTests.setUp();
    doctorViewTests.testGetUserType();
    doctorViewTests.tearDown();

    // Testing in progress requests //
    doctorViewTests.setUp();
    doctorViewTests.testInProgressRequests();
    doctorViewTests.tearDown();

    // Testing launching app //
    doctorViewTests.setUp();
    doctorViewTests.testLaunch();
    doctorViewTests.tearDown();

    // Testing logging out of the application //
    doctorViewTests.setUp();
    doctorViewTests.testLogout();
    doctorViewTests.tearDown();

    // Testing new requests //
    doctorViewTests.setUp();
    doctorViewTests.testNewRequests();
    doctorViewTests.tearDown();

    // Testing with no doctors in database //
    healthTests.setUp();
    healthTests.testWithoutDoctors();
    healthTests.tearDown();

    // Testing with no patients in database //
    healthTests.setUp();
    healthTests.testWithoutPatients();
    healthTests.tearDown();

    // Testing launching the application //
    healthTests.setUp();
    healthTests.testLaunch();
    healthTests.tearDown();

    // Testing correct doctor login //
    newJFrameTests.setUp();
    newJFrameTests.correctDoctorLogin();
    newJFrameTests.tearDown();

    // Testing correct patient login //
    newJFrameTests.setUp();
    newJFrameTests.correctPatientLogin();
    newJFrameTests.tearDown();

    // Testing incorrect doctor login //
    newJFrameTests.setUp();
    newJFrameTests.incorrectDoctorLogin();
    newJFrameTests.tearDown();

    // Testing incorrect patient login //
    newJFrameTests.setUp();
    newJFrameTests.incorrectPatientLogin();
    newJFrameTests.tearDown();

    // Testing launching the application //
    newJFrameTests.setUp();
    newJFrameTests.testLaunch();
    newJFrameTests.tearDown();

    // Testing setting and getting username //
    newJFrameTests.setUp();
    newJFrameTests.testSetAndGetUsername();
    newJFrameTests.tearDown();

    // Testing launching the application //
    newRequestsTests.setUp();
    newRequestsTests.testLaunch();
    newRequestsTests.tearDown();

    // Testing the cancel button //
    newRequestsTests.setUp();
    newRequestsTests.testCancel();
    newRequestsTests.tearDown();

    // Testing the create request //
    newRequestsTests.setUp();
    newRequestsTests.testCreateRequest();
    newRequestsTests.tearDown();

    // Testing launching the application //
    profileTest.setUp();
    profileTest.testLaunch();
    profileTest.tearDown();

    // Testing the logout button //
    profileTest.setUp();
    profileTest.testLogout();
    profileTest.tearDown();

    // Testing making a request //
    profileTest.setUp();
    profileTest.testMakeRequest();
    profileTest.tearDown();

    // Testing viewing the requests //
    profileTest.setUp();
    profileTest.testViewRequests();
    profileTest.tearDown();

    // Testing the back button //
    patientViewTests.setUp();
    patientViewTests.testBackButton();
    patientViewTests.tearDown();

    // Testing the launch application //
    patientViewTests.setUp();
    patientViewTests.testLaunch();
    patientViewTests.tearDown();

    // Testing closed requests //
    patientViewTests.setUp();
    patientViewTests.testClosedRequests();
    patientViewTests.tearDown();

    // Testing in progress requests //
    patientViewTests.setUp();
    patientViewTests.testInProgressRequests();
    patientViewTests.tearDown();

    // Testing get request ID //
    patientViewTests.setUp();
    patientViewTests.testGetRequestID();
    patientViewTests.tearDown();

    // Testing get username //
    patientViewTests.setUp();
    patientViewTests.testGetUsername();
    patientViewTests.tearDown();

    // Testing get user type //
    patientViewTests.setUp();
    patientViewTests.testGetUserType();
    patientViewTests.tearDown();

    // Testing new requests //
    patientViewTests.setUp();
    patientViewTests.testNewRequests();
    patientViewTests.tearDown();

    // Testing selected requests //
    patientViewTests.setUp();
    patientViewTests.testSelected();
    patientViewTests.tearDown();

    // Testing selected requests //
    patientViewTests.setUp();
    patientViewTests.testSelectedRequest();
    patientViewTests.tearDown();

    // Testing set user type //
    patientViewTests.setUp();
    patientViewTests.testSetUserType();
    patientViewTests.tearDown();

    // Testing set request ID //
    patientViewTests.setUp();
    patientViewTests.testSetRequestID();
    patientViewTests.tearDown();

    // Testing set username //
    patientViewTests.setUp();
    patientViewTests.testSetUsername();
    patientViewTests.tearDown();

    requestConversationTests.setUp();
    requestConversationTests.testClose();
    requestConversationTests.tearDown();

    requestConversationTests.setUp();
    requestConversationTests.testAddMessage();
    requestConversationTests.tearDown();

    requestConversationTests.setUp();
    requestConversationTests.testLaunch();
    requestConversationTests.tearDown();
  }
}
