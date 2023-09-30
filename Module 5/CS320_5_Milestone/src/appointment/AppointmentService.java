package appointment;

import java.util.ArrayList;
import java.time.LocalDate;

public class AppointmentService {

	// Create array list object to hold list of appointments
	public ArrayList<Appointment> appointmentList = new ArrayList<Appointment>(); 
	
	// Method to create appointment object
	public Appointment createAppointment(String id, LocalDate date, String description) {
		return new Appointment(id, date, description);
	}
	
	// Function to add appointment to appointmentList
	public void addAppointment(Appointment appointment) {
		for (int i = 0; i < appointmentList.size(); i++) {
			if (appointmentList.get(i).getID() == appointment.getID()) {
				throw new IllegalArgumentException("Appointment ID already exists");
			}
		}
			appointmentList.add(appointment);
	}
	
	public void deleteAppointment(String id) {
		boolean appointmentFound = false;
		for (int i = 0; i < appointmentList.size(); i++) {
			if (appointmentList.get(i).getID() == id) {
				appointmentList.remove(i);
				appointmentFound = true;
			}
		}
		if (!appointmentFound) {
			throw new IllegalArgumentException("Appointment ID does not exist");
		}
	}
}
