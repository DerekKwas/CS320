package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import task.Task;

class TaskTest {

	@Test
	void testTask() {
		Task task = new Task("12345", "Task 1", "Complete Task 1");
		assertTrue(task.getID().equals("12345"));
		task.setName("Task 2");
		task.setDescription("Task 2");
	}

	// Test Task Id
	@Test
	void testTaskIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890123", "Task 1", "Complete Task 1");
		});
	}
	
	@Test
	void testTaskIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null , "Task 1", "Complete Task 1");
		});
	}
	
	// Test Task Name
	@Test
	void testTaskNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "Task1Task1Task1Task1Task1", "Complete Task 1");
		});
	}
	
	@Test
	void testTaskNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345" , null, "Complete Task 1");
		});
	}
	
	// Test Task Description
	@Test
	void testTaskDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345", "Task 1", "CompleteTask1CompleteTask1CompleteTask1CompleteTask1");
		});
	}
	
	@Test
	void testTaskDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345" , "Task 1", null);
		});
	}
	
	// Test Set Task Name
	@Test
	void testSetTaskNameTooLong() {
		Task temp = new Task("12345", "Task 1", "Complete Task 1");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			temp.setName("Task1Task1Task1Task1Task1");
		});
	}
	
	@Test
	void testSetTaskNameNull() {
		Task temp = new Task("12345", "Task 1", "Complete Task 1");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			temp.setName(null);
		});
	}
	
	// Test Set Last Name
	@Test
	void testSetTaskDescriptionTooLong() {
		Task temp = new Task("12345", "Task 1", "Complete Task 1");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			temp.setDescription("CompleteTask1CompleteTask1CompleteTask1CompleteTask1");
		});
	}
	
	@Test
	void testTaskSetLastNameNull() {
		Task temp = new Task("12345", "Task 1", "Complete Task 1");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			temp.setDescription(null);
		});
	}
}
