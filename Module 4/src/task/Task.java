package task;

public class Task {
	private String id;
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private String description;
	
	// Create constructor with attribute requirement checks
	public Task (String id, String name, String description) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid id.");
		}
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name.");
		}
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description.");
		}
		
		// If all checks pass, assign object the pass attributes
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	// Getter methods	
	public String getID() {
		return id;
	}
	
	// Setter methods
	public void setName(String newName) {
		if (newName == null || newName.length() > 20) {
			throw new IllegalArgumentException("Invalid name.");
		}
		this.name = newName;
	}
	
	public void setDescription(String newDescription) {
		if (newDescription == null || newDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid description.");
		}
		this.description = newDescription;
	}
}
