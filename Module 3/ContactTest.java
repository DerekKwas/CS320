package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {

	@Test
	void testContact() {
		Contact contact = new Contact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		assertTrue(contact.getFirstName().equals("John"));
		assertTrue(contact.getLastName().equals("Doe"));
		assertTrue(contact.getID().equals("12345"));
		assertTrue(contact.getPhone().equals("1234567890"));
		assertTrue(contact.getAddress().equals("123 Alligator Alley"));
	}

	// Test First Name
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("JohnDoeJaneDoe", "Doe", "12345", "1234567890", "123 Alligator Alley");
		});
	}
	
	@Test
	void testContactFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null , "Doe", "12345", "1234567890", "123 Alligator Alley");
		});
	}
	
	// Test last name
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("John", "DoeDoeDoeDoe", "12345", "1234567890", "123 Alligator Alley");
		});
	}
	
	@Test
	void testContactLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("John" , null, "12345", "1234567890", "123 Alligator Alley");
		});
	}
	
	// Test ID
	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("John", "Doe", "1234567890123", "1234567890", "123 Alligator Alley");
		});
	}
	
	@Test
	void testContactIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("John" , "Doe", null, "1234567890", "123 Alligator Alley");
		});
	}
	
	// Test Phone number
	@Test
	void testContactPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("John", "Doe", "12345", "1234567890123", "123 Alligator Alley");
		});
	}
	
	@Test
	void testContactPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("John", "Doe", "12345", "12345", "123 Alligator Alley");
		});
	}
	
	@Test
	void testContactPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("John" , "Doe", "12345", null, "123 Alligator Alley");
		});
	}
	
	// Test Address
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("John", "Doe", "12345", "1234567890", "123 Alligator & Crocodile Alley");
		});
	}
	
	@Test
	void testContactAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("John" , "Doe", "12345", "1234567890", null);
		});
	}

}
