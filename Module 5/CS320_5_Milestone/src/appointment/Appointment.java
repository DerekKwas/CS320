package appointment;

import java.time.LocalDate;

public class Appointment {
	private String id;
	@SuppressWarnings("unused")
	private LocalDate date;
	@SuppressWarnings("unused")
	private String description;
	
	// Create constructor with attribute requirement checks
	public Appointment (String id, LocalDate date, String description) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid id.");
		}
		if (date == null || date.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("Invalid date, must be in the future.");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description.");
		}
		
		// If all checks pass, assign object the pass attributes
		this.id = id;
		this.date = date;
		this.description = description;
	}
	
	// Getter methods	
	public String getID() {
		return id;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public String getDescription() {
		return description;
	}
}
