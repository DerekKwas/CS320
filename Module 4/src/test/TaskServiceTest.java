package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import task.TaskService;

class TaskServiceTest {

	@Test
	void testTaskServiceAddTask() {
		TaskService taskService = new TaskService();
		taskService.addTask("12345", "Task 1", "Complete Task 1");
		taskService.addTask("12346", "Task 2", "Complete Task 2");
	}
		
	@Test
	void testTaskServiceAddTaskReoccuringId() {
		TaskService taskService = new TaskService();
		taskService.addTask("12345", "Task 1", "Complete Task 1");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask("12345", "Task 2", "Complete Task 2");
		});
	}
	
	@Test
	void testTaskServiceDeleteTaskId() {
		TaskService taskService = new TaskService();
		taskService.addTask("12345", "Task 1", "Complete Task 1");
		
		taskService.deleteTask("12345");
	}
	
	@Test
	void testTaskServiceDeleteTaskInvalidId() {
		TaskService taskService = new TaskService();
		taskService.addTask("12345", "Task 1", "Complete Task 1");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.deleteTask("15");
		});
	}
	
	@Test
	void testTaskServiceUpdateTaskInvalidId() {
		TaskService taskService = new TaskService();
		taskService.addTask("12345", "Task 1", "Complete Task 1");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTask("12345", "Task 2", "Complete Task 2");
		});
	}
	
	@Test
	void testTaskServiceUpdateTaskNullEntries() {
		TaskService taskService = new TaskService();
		taskService.addTask("12345", "Task 1", "Complete Task 1");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTask("12345", null, null);
		});
	}
	
	@Test
	void testTaskServiceUpdateNameTooLong() {
		TaskService taskService = new TaskService();
		taskService.addTask("12345", "Task 1", "Complete Task 1");
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTask("12345", "Task2Task2Task2", "Complete Task 2");
		});
	}
	
	@Test
	void testTaskServiceUpdateDescriptionTooLong() {
		TaskService taskService = new TaskService();
		taskService.addTask("12345", "Task 1", "Complete Task 1");
	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTask("12345", "Task 2", "CompleteTask2CompleteTask2CompleteTask2CompleteTask2");
		});
	}
}
