package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {

	@Test
	void testContact() {
		Contact contact = new Contact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		assertTrue(contact.getID().equals("12345"));
		contact.setFirstName("John");
		contact.setLastName("Doe");
		contact.setPhone("1234567890");
		contact.setAddress("123 Alligator Alley");
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

	// Test Set First Name
	@Test
	void testContactSetFirstNameTooLong() {
		Contact temp = new Contact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			temp.setFirstName("JohnDoeJohnDoe");
		});
	}
	
	@Test
	void testContactSetFirstNameNull() {
		Contact temp = new Contact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			temp.setFirstName(null);
		});
	}
	
	// Test Set Last Name
	@Test
	void testContactSetLastNameTooLong() {
		Contact temp = new Contact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			temp.setLastName("DoeDoeDoeDoe");
		});
	}
	
	@Test
	void testContactSetLastNameNull() {
		Contact temp = new Contact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			temp.setLastName(null);
		});
	}
	
	// Test Set Phone
	@Test
	void testContactSetPhoneTooLong() {
		Contact temp = new Contact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			temp.setPhone("1234567890123");
		});
	}
	
	@Test
	void testContactSetPhoneNull() {
		Contact temp = new Contact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			temp.setPhone(null);
		});
	}
	
	// Test Set Last Name
	@Test
	void testContactSetAddressLong() {
		Contact temp = new Contact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			temp.setAddress("123 Alligator & Crocodile Alley");
		});
	}
	
	@Test
	void testContactSetAddressNull() {
		Contact temp = new Contact("John", "Doe", "12345", "1234567890", "123 Alligator Alley");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			temp.setAddress(null);
		});
	}
}
