package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointment.AppointmentService;

class AppointmentServiceTest {

	@Test
	void testAppointmentServiceAddAppointment() {
		AppointmentService appointmentService = new AppointmentService();
		appointmentService.addAppointment("12345", LocalDate.of(2023, 10, 13), "Arrive at Appointment 1");
		appointmentService.addAppointment("12346", LocalDate.of(2023, 10, 17), "Arrive at Appointment 2");
	}
		
	@Test
	void testAppointmentServiceAddAppointmentReoccuringId() {
		AppointmentService appointmentService = new AppointmentService();
		appointmentService.addAppointment("12345", LocalDate.of(2023, 10, 10), "Arrive at Appointment 1");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment("12345", LocalDate.of(2023, 10, 14), "Arrive at Appointment 2");
		});
	}
	
	@Test
	void testAppointmentServiceDeleteAppointmentId() {
		AppointmentService appointmentService = new AppointmentService();
		appointmentService.addAppointment("12345", LocalDate.of(2023, 10, 17), "Arrive at Appointment 1");
		
		appointmentService.deleteAppointment("12345");
	}
	
	@Test
	void testAppointmentServiceDeleteAppointmentInvalidId() {
		AppointmentService appointmentService = new AppointmentService();
		appointmentService.addAppointment("12345", LocalDate.of(2023, 11, 2), "Arrive at Appointment 1");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.deleteAppointment("15");
		});
	}
}
