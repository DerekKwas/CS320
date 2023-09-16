package contact;

public class ContactService {

	public void addContact(String firstName, String lastName, String id, String phone, String address) {
		Contact contact = new Contact(firstName, lastName, id, phone, address);
		// Functionality will be added to add this new contact to the in-memory data structure.
	}
	
	public void deleteContact(String id) {
		// Functionality for accessing the in-memory data structure and using the id argument to find
		// the correct contact will be added so the object can be deleted and the data structure can
		// be updated if needed.
	}
	
	public void updateContact(String newFirstName, String newLastName, String newID, String newPhone, String newAddress) {
		if (newFirstName == null || newLastName == null || newID == null || newPhone == null || newAddress == null) {
			throw new IllegalArgumentException("All entries are null");
		}
		// Functionality for accessing the in-memory data structure and using the id argument to find
		// the correct contact will be added so the object's attributes can be updated.
	}
}
