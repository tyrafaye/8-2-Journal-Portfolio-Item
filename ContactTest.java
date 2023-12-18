import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
  protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
      addressTest;
  protected String tooLongContactId, tooLongFirstName, tooLongLastName,
      tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;

  @BeforeEach
  void setup() {
    contactId = "1029F847A6";
    firstNameTest = "John";
    lastNameTest = "Smith";
    phoneNumberTest = "5553331234";
    addressTest = "1 Audrey Jersey City NJ 07305";
    tooLongContactId = "112233445566778899";
    tooLongFirstName = "John Jacob Jingle";
    tooLongLastName = "-heimer Schmidt";
    tooLongPhoneNumber = "55512341234";
    tooShortPhoneNumber = "1234567";
    tooLongAddress = "1 Audrey Zapp Drive, Jersey City, NJ 07305";
  }

  @Test
  void testDefaultConstructor() {
    Contact contact = new Contact();
    assertAll("constructor",
              () -> assertNotNull(contact.getContactId()),
              () -> assertNotNull(contact.getFirstName()),
              () -> assertNotNull(contact.getLastName()),
              () -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void testContactIdConstructor() {
    Contact contact = new Contact(contactId);
    assertAll("constructor one",
              () -> assertEquals(contactId, contact.getContactId()),
              () -> assertNotNull(contact.getFirstName()),
              () -> assertNotNull(contact.getLastName()),
              () -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void testContactIdAndFirstNameConstructor() {
    Contact contact = new Contact(contactId, firstNameTest);
    assertAll("constructor two",
              () -> assertEquals(contactId, contact.getContactId()),
              () -> assertEquals(firstNameTest, contact.getFirstName()),
              () -> assertNotNull(contact.getLastName()),
              () -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void testContactIdAndFullNameConstructor() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
    assertAll("constructor three",
              () -> assertEquals(contactId, contact.getContactId()),
              () -> assertEquals(firstNameTest, contact.getFirstName()),
              () -> assertEquals(lastNameTest, contact.getLastName()),
              () -> assertNotNull(contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void testContactIdFullNamePhoneNumberConstructor() {
    Contact contact =
        new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
    assertAll("constructor four",
              () -> assertEquals(contactId, contact.getContactId()),
              () -> assertEquals(firstNameTest, contact.getFirstName()),
              () -> assertEquals(lastNameTest, contact.getLastName()),
              () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () -> assertNotNull(contact.getAddress()));
  }

  @Test
  void testAllFieldsConstructor() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest,
                                  phoneNumberTest, addressTest);
    assertAll("constructor all",
              () -> assertEquals(contactId, contact.getContactId()),
              () -> assertEquals(firstNameTest, contact.getFirstName()),
              () -> assertEquals(lastNameTest, contact.getLastName()),
              () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () -> assertEquals(addressTest, contact.getAddress()));
  }

  @Test
  void testUpdateFirstName() {
    Contact contact = new Contact();
    contact.updateFirstName(firstNameTest);
    assertAll(
        "first name",
        () -> assertEquals(firstNameTest, contact.getFirstName()),
        () -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateFirstName(null)),
        () -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateFirstName(tooLongFirstName)));
  }

  @Test
  void testUpdateLastName() {
    Contact contact = new Contact();
    contact.updateLastName(lastNameTest);
    assertAll(
        "last name",
        () -> assertEquals(lastNameTest, contact.getLastName()),
        () -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateLastName(null)),
        () -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateLastName(tooLongFirstName)));
  }

  @Test
  void testUpdatePhoneNumber() {
    Contact contact = new Contact();
    contact.updatePhoneNumber(phoneNumberTest);
    assertAll("phone number",
              () -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updatePhoneNumber(null)),
              () -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updatePhoneNumber(tooLongPhoneNumber)),
              () -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updatePhoneNumber(tooShortPhoneNumber)),
              () -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updatePhoneNumber(contactId)));
  }

  @Test
  void testUpdateAddress() {
    Contact contact = new Contact();
    contact.updateAddress(addressTest);
    assertAll("phone number",
              ()
