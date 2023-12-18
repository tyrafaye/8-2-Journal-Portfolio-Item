import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
  protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
      addressTest;
  protected String tooLongContactId, tooLongFirstName, tooLongLastName,
      tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;

  @BeforeEach
  void setup() {
    contactId = "10589Y5587P";
    firstNameTest = "Tyra";
    lastNameTest = "Faye";
    phoneNumberTest = "8317105665";
    addressTest = "1 Tyra PG City CA 93950";
    tooLongContactId = "112233445566778899";
    tooLongFirstName = "Tyra Faye Austria";
    tooLongLastName = "-austria Austria";
    tooLongPhoneNumber = "83171056656";
    tooShortPhoneNumber = "1234567";
    tooLongAddress = "1 Tyra Arkwright CT, PG City, CA 93950";
  }

  @Test
  void testNewContact() {
    ContactService service = new ContactService();
    service.newContact();
    assertAll(
        "service",
        () -> assertNotNull(service.getContactList().get(0).getContactId()),
        () -> assertEquals("INITIAL", service.getContactList().get(0).getFirstName()),
        () -> assertEquals("INITIAL", service.getContactList().get(0).getLastName()),
        () -> assertEquals("1235559999", service.getContactList().get(0).getPhoneNumber()),
        () -> assertEquals("INITIAL", service.getContactList().get(0).getAddress()));

    service.newContact(firstNameTest);
    assertAll(
        "service",
        () -> assertNotNull(service.getContactList().get(1).getContactId()),
        () -> assertEquals(firstNameTest, service.getContactList().get(1).getFirstName()),
        () -> assertEquals("INITIAL", service.getContactList().get(1).getLastName()),
        () -> assertEquals("1235559999", service.getContactList().get(1).getPhoneNumber()),
        () -> assertEquals("INITIAL", service.getContactList().get(1).getAddress()));

    service.newContact(firstNameTest, lastNameTest);
    assertAll(
        "service",
        () -> assertNotNull(service.getContactList().get(2).getContactId()),
        () -> assertEquals(firstNameTest, service.getContactList().get(2).getFirstName()),
        () -> assertEquals(lastNameTest, service.getContactList().get(2).getLastName()),
        () -> assertEquals("1235559999", service.getContactList().get(2).getPhoneNumber()),
        () -> assertEquals("INITIAL", service.getContactList().get(2).getAddress()));

    service.newContact(firstNameTest, lastNameTest, phoneNumberTest);
    assertAll(
        "service",
        () -> assertNotNull(service.getContactList().get(3).getContactId()),
        () -> assertEquals(firstNameTest, service.getContactList().get(3).getFirstName()),
        () -> assertEquals(lastNameTest, service.getContactList().get(3).getLastName()),
        () -> assertEquals(phoneNumberTest, service.getContactList().get(3).getPhoneNumber()),
        () -> assertEquals("INITIAL", service.getContactList().get(3).getAddress()));

    service.newContact(firstNameTest, lastNameTest, phoneNumberTest, addressTest);
    assertAll(
        "service",
        () -> assertNotNull(service.getContactList().get(4).getContactId()),
        () -> assertEquals(firstNameTest, service.getContactList().get(4).getFirstName()),
        () -> assertEquals(lastNameTest, service.getContactList().get(4).getLastName()),
        () -> assertEquals(phoneNumberTest, service.getContactList().get(4).getPhoneNumber()),
        () -> assertEquals(addressTest, service.getContactList().get(4).getAddress()));
  }

  @Test
  void testDeleteContact() {
    ContactService service = new ContactService();
    service.newContact();
    assertThrows(Exception.class, () -> service.deleteContact(contactId));
    assertAll(() -> service.deleteContact(service.getContactList().get(0).getContactId()));
  }

  @Test
  void testUpdateFirstName() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updateFirstName(service.getContactList().get(0).getContactId(), firstNameTest);
    assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
    assertThrows(IllegalArgumentException.class,
                 () -> service.updateFirstName(service.getContactList().get(0).getContactId(), tooLongFirstName));
    assertThrows(IllegalArgumentException.class,
                 () -> service.updateFirstName(service.getContactList().get(0).getContactId(), null));
    assertThrows(Exception.class,
                 () -> service.updateFirstName(contactId, firstNameTest));
  }

  @Test
  void testUpdateLastName() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updateLastName(service.getContactList().get(0).getContactId(), lastNameTest);
    assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
    assertThrows(IllegalArgumentException.class,
                 () -> service.updateLastName(service.getContactList().get(0).getContactId(), tooLongLastName));
    assertThrows(IllegalArgumentException.class,
                 () -> service.updateLastName(service.getContactList().get(0).getContactId(), null));
    assertThrows(Exception.class,
                 () -> service.updateLastName(contactId, lastNameTest));
  }

  @Test
  void testUpdatePhoneNumber() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updatePhoneNumber(service.get
