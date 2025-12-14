import java.util.ArrayList;
import java.util.List;

class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String time;
    private boolean completed;
    private static int appointmentCounter = 0;
    private int appointmentId;

    public Appointment(Patient patient, Doctor doctor, String time) {
        if (patient == null || doctor == null || time == null || time.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid appointment parameters");
        }
        this.patient = patient;
        this.doctor = doctor;
        this.time = time;
        this.completed = false;
        this.appointmentId = ++appointmentCounter;
    }

    public void markCompleted() {
        if (completed) {
            System.out.println("Appointment is already completed.");
            return;
        }
        this.completed = true;
        System.out.println("Appointment #" + appointmentId + " marked as completed.");
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getTime() {
        return time;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void printStatus() {
        System.out.println("\nAppointment Status");
        System.out.println("Appointment ID: #" + appointmentId);
        System.out.println("Patient: " + patient.getName() + " (Age: " + patient.getAge() + ")");
        System.out.println("Doctor: Dr. " + doctor.getName() + " (" + doctor.getSpecialization() + ")");
        System.out.println("Time: " + time);
        System.out.println("Status: " + (completed ? "COMPLETED" : "SCHEDULED"));
    }
}
