package appointment;

import java.util.ArrayList;
import java.time.LocalDate;

public class AppointmentService {

	// Create array list object to hold list of appointments
	public ArrayList<Appointment> appointmentList = new ArrayList<Appointment>(); 
	
	// Function to add appointment to appointmentList
	public void addAppointment(String id, LocalDate date, String description) {
		for (int i = 0; i < appointmentList.size(); i++) {
			if (appointmentList.get(i).getID() == id) {
				throw new IllegalArgumentException("Appointment ID already exists");
			}
		}
		Appointment appointment = new Appointment(id, date, description);
		
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
