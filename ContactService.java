package contact;

import java.util.ArrayList;

public class ContactService {

	// Create array list object to hold list of contacts
	public ArrayList<Contact> contactList = new ArrayList<Contact>(); 
	
	// Method to create Contact objects
	public Contact createContact (String firstName, String lastName, String id, String phone, String address) {
		return new Contact(firstName, lastName, id, phone, address);
	}
	
	// Method to add contact to contactList
	public void addContact(Contact contact) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getID() == contact.getID()) {
				throw new IllegalArgumentException("Contact ID already exists");
			}
		}		
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
	
	public void updateContactFirstName(String id, String newFirstName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getID() == id) {
				if (newFirstName != null && newFirstName.length() <= 10) {
					contactList.get(i).setFirstName(newFirstName);
				}
				else {
					throw new IllegalArgumentException("New first name is not valid.");
				}
			}
		}
		throw new IllegalArgumentException("Contact ID does not exist");
	}
	
	public void updateContactLastName(String id, String newLastName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getID() == id) {
				if (newLastName != null && newLastName.length() <= 10) {
					contactList.get(i).setLastName(newLastName);
				}
				else {
					throw new IllegalArgumentException("New last name is not valid.");
				}
			}
		}
		throw new IllegalArgumentException("Contact ID does not exist");
	}
	
	public void updateContactPhone(String id, String newPhone) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getID() == id) {
				if (newPhone != null && newPhone.length() == 10) {
					contactList.get(i).setPhone(newPhone);
				}
				else {
					throw new IllegalArgumentException("New phone number is not valid.");
				}
			}
		}
		throw new IllegalArgumentException("Contact ID does not exist");
	}
	
	public void updateContactAddress(String id, String newAddress) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getID() == id) {
				if (newAddress != null && newAddress.length() <= 30) {
					contactList.get(i).setAddress(newAddress);
				}
				else {
					throw new IllegalArgumentException("New address is not valid.");
				}
			}
		}
		throw new IllegalArgumentException("Contact ID does not exist");
	}
}
