package task;

import java.util.ArrayList;

public class TaskService {

	// Create array list object to hold list of tasks
	public ArrayList<Task> taskList = new ArrayList<Task>(); 
	
	// Function to add task to taskList
	public void addTask(String id, String name, String description) {
		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getID() == id) {
				throw new IllegalArgumentException("Task ID already exists");
			}
		}
		Task task = new Task(id, name, description);
		
		taskList.add(task);
	}
	
	public void deleteTask(String id) {
		boolean taskFound = false;
		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getID() == id) {
				taskList.remove(i);
				taskFound = true;
			}
		}
		if (!taskFound) {
			throw new IllegalArgumentException("Task ID does not exist");
		}
	}
	
	public void updateTask(String id, String newName, String newDescription) {
		for (int i = 0; i < taskList.size(); i++) {
			if (taskList.get(i).getID() == id) {
				if (newName != null && newName.length() <= 10) {
					taskList.get(i).setName(newName);
				}
				if (newDescription != null && newDescription.length() <= 50) {
					taskList.get(i).setDescription(newDescription);
				}
				else {
					throw new IllegalArgumentException("Not all entries valid");
				}
			}
		}
		throw new IllegalArgumentException("Task ID does not exist");
	}
}
