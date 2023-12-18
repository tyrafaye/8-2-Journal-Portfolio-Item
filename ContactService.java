import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {

  private String uniqueId;
  private List<Contact> contactList = new ArrayList<>();

  {
    uniqueId = UUID.randomUUID().toString().substring(0, Math.min(UUID.randomUUID().toString().length(), 10));
  }

  public void createContact() {
    Contact contact = new Contact(generateUniqueId());
    contactList.add(contact);
  }

  public void createContact(String firstName) {
    Contact contact = new Contact(generateUniqueId(), firstName);
    contactList.add(contact);
  }

  public void createContact(String firstName, String lastName) {
    Contact contact = new Contact(generateUniqueId(), firstName, lastName);
    contactList.add(contact);
  }

  public void createContact(String firstName, String lastName, String phoneNumber) {
    Contact contact = new Contact(generateUniqueId(), firstName, lastName, phoneNumber);
    contactList.add(contact);
  }

  public void createContact(String firstName, String lastName, String phoneNumber, String address) {
    Contact contact = new Contact(generateUniqueId(), firstName, lastName, phoneNumber, address);
    contactList.add(contact);
  }

  public void deleteContact(String contactId) throws Exception {
    contactList.remove(findContact(contactId));
  }

  public void updateFirstName(String contactId, String newFirstName) throws Exception {
    findContact(contactId).updateFirstName(newFirstName);
  }

  public void updateLastName(String contactId, String newLastName) throws Exception {
    findContact(contactId).updateLastName(newLastName);
  }

  public void updatePhoneNumber(String contactId, String newPhoneNumber) throws Exception {
    findContact(contactId).updatePhoneNumber(newPhoneNumber);
  }

  public void updateAddress(String contactId, String newAddress) throws Exception {
    findContact(contactId).updateAddress(newAddress);
  }

  protected List<Contact> getContactList() {
    return contactList;
  }

  private String generateUniqueId() {
    return uniqueId = UUID.randomUUID().toString().substring(0, Math.min(UUID.randomUUID().toString().length(), 10));
  }

  private Contact findContact(String contactId) throws Exception {
    for (Contact contact : contactList) {
      if (contactId.equals(contact.getContactId())) {
        return contact;
      }
    }
    throw new Exception("The contact does not exist!");
  }
}
