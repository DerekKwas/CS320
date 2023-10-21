package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.ContactService;
import contact.Contact;

class ContactServiceTest {

	@Test
	void testContactServiceAddContact() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
		Contact contact2 = contactService.createContact("Jane", "Doe", "12346", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact2);
	}
		
	@Test
	void testContactServiceAddContactReoccuringId() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
		Contact contact2 = contactService.createContact("Jane", "Doe", "12345", "1234567890", "123 Alligator Alley");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(contact2);
		});
	}
	
	@Test
	void testContactServiceDeleteContactId() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
		
		contactService.deleteContact("12345");
	}
	
	@Test
	void testContactServiceDeleteContactInvalidId() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.deleteContact("15");
		});
	}
	
	// Test Update Methods with valid values
	@Test
	void testContactServiceUpdateContactFirstName() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactFirstName("12345", "Luke");
		});
	}
	
	@Test
	void testContactServiceUpdateContactLastName() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactLastName("12345", "Cunningham");
		});
	}
	
	@Test
	void testContactServiceUpdateContactPhone() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactPhone("12345", "1233567890");
		});
	}
	
	@Test
	void testContactServiceUpdateContactAddress() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactAddress("12345", "123 Crocidile Lane");
		});
	}
	
	// Test Update Methods with Invalid IDs
	@Test
	void testContactServiceUpdateContactFirstNameInvalidId() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactFirstName("100", "Luke");
		});
	}
	
	@Test
	void testContactServiceUpdateContactLastNameInvalidId() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactFirstName("100", "Cunningham");
		});
	}
	
	@Test
	void testContactServiceUpdateContactPhoneInvalidId() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactFirstName("100", "1234567890");
		});
	}
	
	@Test
	void testContactServiceUpdateContactAddressInvalidId() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactAddress("100", "123 Alligator Lane");
		});
	}
	
	// Test Update Methods with Null entries
	@Test
	void testContactServiceUpdateContactFirstNameNull() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactFirstName("12345", null);
		});
	}
	
	@Test
	void testContactServiceUpdateContactLastNameNull() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactLastName("12345", null);
		});
	}
	
	@Test
	void testContactServiceUpdateContactPhoneNull() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactPhone("12345", null);
		});
	}
	
	@Test
	void testContactServiceUpdateContactAddressNull() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactAddress("12345", null);
		});
	}
	
	// Test Update Methods with too long entries
	@Test
	void testContactServiceUpdateFirstNameTooLong() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactFirstName("12345", "JohnDoeJaneDoe");
		});
	}
	
	@Test
	void testContactServiceUpdateLastNameTooLong() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactLastName("12345", "JohnDoeJaneDoe");
		});
	}
	
	@Test
	void testContactServiceUpdatePhoneTooLong() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactPhone("12345", "1234567890123");
		});
	}
	
	@Test
	void testContactServiceUpdateAddressTooLong() {
		ContactService contactService = new ContactService();
		Contact contact1 = contactService.createContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact(contact1);
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContactAddress("12345", "123 Alligator Alley & Crocidile Crossing");
		});
	}
}
