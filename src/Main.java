import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {;
        System.out.println("  CLINIC APPOINTMENT SYSTEM DEMO");

        Clinic cityClinic = new Clinic("City General Clinic");
        Doctor drSmith = new Doctor("Dr. Sarah Smith", "General Practitioner");
        Patient johnDoe = new Patient("John Doe", 35);

        System.out.println("\nClinic: " + cityClinic.getName());
        System.out.println("Doctor: " + drSmith.getName() + " - " + drSmith.getSpecialization());
        System.out.println("Patient: " + johnDoe.getName() + ", Age: " + johnDoe.getAge());

        Appointment appointment1 = cityClinic.scheduleAppointment(johnDoe, drSmith, "2025-12-16 10:00 AM");

        drSmith.consult(johnDoe, appointment1);

        cityClinic.complete(appointment1);

        appointment1.printStatus();

        johnDoe.printMedicalHistory();

        System.out.println("  EXTENDED SCENARIO");
        Patient janeDoe = new Patient("Jane Doe", 28);
        Doctor drJones = new Doctor("Dr. Michael Jones", "Cardiologist");

        Appointment appointment2 = cityClinic.scheduleAppointment(janeDoe, drJones, "2025-12-16 2:00 PM");
        Appointment appointment3 = cityClinic.scheduleAppointment(johnDoe, drJones, "2025-12-17 9:00 AM");

        drJones.consult(janeDoe, appointment2);
        cityClinic.complete(appointment2);

        cityClinic.printAllAppointments();

        janeDoe.printMedicalHistory();
        johnDoe.printMedicalHistory();

        System.out.println("  VALIDATION DEMONSTRATIONS");

        System.out.println("\nAttempting to consult an already completed appointment...");
        try {
            drSmith.consult(johnDoe, appointment1);
        } catch (IllegalStateException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\nAttempting consultation with wrong doctor...");
        try {
            drSmith.consult(johnDoe, appointment3);
        } catch (IllegalStateException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\nAttempting consultation with wrong patient...");
        try {
            drJones.consult(johnDoe, appointment2);
        } catch (IllegalStateException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("  DEMO COMPLETED SUCCESSFULLY");
    }
}