package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import appointment.Appointment;
import appointment.AppointmentService;

class AppointmentServiceTest {

	@Test
	void testAppointmentServiceAddAppointment() {
		AppointmentService appointmentService = new AppointmentService();
		Appointment Appt1 = appointmentService.createAppointment("12345", LocalDate.of(2023, 10, 13), "Arrive at Appointment 1");
		appointmentService.addAppointment(Appt1);
		Appointment Appt2 = appointmentService.createAppointment("12346", LocalDate.of(2023, 10, 13), "Arrive at Appointment 2");
		appointmentService.addAppointment(Appt2);
	}

	@Test
	void testAppointmentServiceAddAppointmentReoccuringId() {
		AppointmentService appointmentService = new AppointmentService();
		Appointment Appt1 = appointmentService.createAppointment("12345", LocalDate.of(2023, 10, 10), "Arrive at Appointment 1");
		appointmentService.addAppointment(Appt1);
		Appointment Appt2 = appointmentService.createAppointment("12345", LocalDate.of(2023, 10, 14), "Arrive at Appointment 2");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment(Appt2);
		});
	}
	
	@Test
	void testAppointmentServiceDeleteAppointmentId() {
		AppointmentService appointmentService = new AppointmentService();
		Appointment Appt1 = appointmentService.createAppointment("12345", LocalDate.of(2023, 10, 17), "Arrive at Appointment 1");
		appointmentService.addAppointment(Appt1);
		
		appointmentService.deleteAppointment("12345");
	}
	
	@Test
	void testAppointmentServiceDeleteAppointmentInvalidId() {
		AppointmentService appointmentService = new AppointmentService();
		Appointment Appt1 = appointmentService.createAppointment("12345", LocalDate.of(2023, 11, 2), "Arrive at Appointment 1");
		appointmentService.addAppointment(Appt1);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.deleteAppointment("15");
		});
	}
}
