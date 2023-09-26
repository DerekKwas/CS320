package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointment.Appointment;
import java.time.LocalDate;

class AppointmentTest {

	@Test
	void testAppointment() {
		Appointment appointment = new Appointment("12345", LocalDate.now().plusDays(14), "Arrive at appointment 1");
		assertTrue(appointment.getID().equals("12345"));
		assertTrue(appointment.getDate().toString().equals("2023-10-10"));
		assertTrue(appointment.getDescription().equals("Arrive at appointment 1"));
	}

	// Test Appointment Id
	@Test
	void testAppointmentIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567890123", LocalDate.now().plusDays(14), "Arrive at appointment 1");		
		});
	}
	
	@Test
	void testAppointmentIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, LocalDate.now().plusDays(14), "Arrive at appointment 1");		
		});
	}
	
	// Test Appointment Date
	@Test
	void testAppointmentDateInPast() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", LocalDate.now().minusDays(7), "Arrive at appointment 1");		
		});
	}
	
	@Test
	void testAppointmentDateNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345" , null, "Arrive at Appointment 1");
		});
	}
	
	// Test Appointment Description
	@Test
	void testAppointmentDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", LocalDate.now().plusDays(14), "Arriveatappointment1Arriveatappointment1Arriveatappointment1");		
		});
	}
	
	@Test
	void testAppointmentDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", LocalDate.now().plusDays(14), null);		
		});
	}
}
