package contact;

import java.util.ArrayList;

public class ContactService {

	// Create array list object to hold list of contacts
	public ArrayList<Contact> contactList = new ArrayList<Contact>(); 
	
	// Function to add contact to contactList
	public void addContact(String firstName, String lastName, String id, String phone, String address) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getID() == id) {
				throw new IllegalArgumentException("Contact ID already exists");
			}
		}
		Contact contact = new Contact(firstName, lastName, id, phone, address);
		
		contactList.add(contact);
	}
	
	public void deleteContact(String id) {
		boolean contactFound = false;
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getID() == id) {
				contactList.remove(i);
				contactFound = true;
			}
		}
		if (!contactFound) {
			throw new IllegalArgumentException("Contact ID does not exist");
		}
	}
	
	public void updateContact(String newFirstName, String newLastName, String id, String newPhone, String newAddress) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getID() == id) {
				if (newFirstName != null && newFirstName.length() <= 10) {
					contactList.get(i).setFirstName(newFirstName);
				}
				if (newLastName != null && newLastName.length() <= 10) {
					contactList.get(i).setLastName(newLastName);
				}
				if (newPhone != null && newPhone.length() == 10) {
					contactList.get(i).setPhone(newPhone);
				}
				if (newAddress != null && newAddress.length() <= 30) {
					contactList.get(i).setAddress(newAddress);
				}
				else {
					throw new IllegalArgumentException("Not all entries valid");
				}
			}
		}
		throw new IllegalArgumentException("Contact ID does not exist");
	}
}
