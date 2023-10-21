package contact;

public class Contact {
	@SuppressWarnings("unused")
	private String firstName;
	@SuppressWarnings("unused")
	private String lastName;
	private String id;
	@SuppressWarnings("unused")
	private String phone;
	@SuppressWarnings("unused")
	private String address;
	
	// Create constructor with attribute requirement checks
	public Contact (String firstName, String lastName, String id, String phone, String address) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid id");
		}
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		// Test if entered phone number includes any character that aren't digits
		try {
			Integer.parseInt(phone);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Phone number must only be digits.");
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		// If all checks pass, assign object the pass attributes
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.phone = phone;
		this.address = address;
	}
	
	// Getter methods	
	public String getID() {
		return id;
	}
	
	// Setter methods
	public void setFirstName(String newFirstName) {
		if (newFirstName == null || newFirstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = newFirstName;
	}
	
	public void setLastName(String newLastName) {
		if (newLastName == null || newLastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = newLastName;
	}
	
	public void setPhone(String newPhone) {
		if (newPhone == null || newPhone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		// Test if entered phone number includes any character that aren't digits
		try {
			Integer.parseInt(newPhone);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Phone number must only be digits.");
		}
		this.phone = newPhone;
	}
	
	public void setAddress(String newAddress) {
		if (newAddress == null || newAddress.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = newAddress;
	}
}
