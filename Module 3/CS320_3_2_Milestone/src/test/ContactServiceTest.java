package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.ContactService;

class ContactServiceTest {

	@Test
	void testContactServiceAddContact() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		contactService.addContact("Jane", "Doe", "12346", "1234567890", "123 Alligator Alley");
	}
		
	@Test
	void testContactServiceAddContactReoccuringId() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact("Jane", "Doe", "12345", "1234567890", "123 Alligator Alley");
		});
	}
	
	@Test
	void testContactServiceDeleteContactId() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		
		contactService.deleteContact("12345");
	}
	
	@Test
	void testContactServiceDeleteContactInvalidId() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.deleteContact("15");
		});
	}
	
	@Test
	void testContactServiceUpdateContactInvalidId() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact("Luke", "Cunningham", "100", "1234567890", "851 Dunk Road");
		});
	}
	
	@Test
	void testContactServiceUpdateContactNullEntries() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact(null, null, "12345", null, null);
		});
	}
	
	@Test
	void testContactServiceUpdateFirstNameTooLong() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact("JohnDoeJaneDoe", "Doe", "12345", "1234567890", "123 Alligator Alley");
		});
	}
	
	@Test
	void testContactServiceUpdateLastNameTooLong() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact("John", "DoeDoeDoeDoe", "12345", "1234567890", "123 Alligator Alley");
		});
	}
	
	@Test
	void testContactServiceUpdateIdTooLong() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact("John", "Doe", "1234567890123", "1234567890", "123 Alligator Alley");
		});
	}
	
	@Test
	void testContactServiceUpdatePhoneTooLong() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact("John", "Doe", "12345", "1234567890123", "123 Alligator Alley");
		});
	}
	
	@Test
	void testContactServiceUpdateAddressTooLong() {
		ContactService contactService = new ContactService();
		contactService.addContact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact("John", "Doe", "12345", "1234567890123", "123 Alligator Alley");
		});
	}
}
