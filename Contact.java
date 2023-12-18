public class Contact {
    private String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (validateFirstName(firstName)) {
            this.firstName = firstName;
        } else {
            System.out.println("Invalid firstName");
        }
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (validateLastName(lastName)) {
            this.lastName = lastName;
        } else {
            System.out.println("Invalid lastName");
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (validatePhone(phone)) {
            this.phone = phone;
        } else {
            System.out.println("Invalid phone number");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (validateAddress(address)) {
            this.address = address;
        } else {
            System.out.println("Invalid address");
        }
    }

    private boolean validateFirstName(String firstName) {
        return firstName != null && firstName.length() <= 10;
    }

    private boolean validateLastName(String lastName) {
        return lastName != null && lastName.length() <= 10;
    }

    private boolean validatePhone(String phone) {
        return phone != null && phone.length() == 10 && phone.matches("\\d+"); // Check if phone is exactly 10 digits
    }

    private boolean validateAddress(String address) {
        return address != null && address.length() <= 30;
    }
}
