import java.util.ArrayList;
import java.util.List;

class Clinic {
    private String name;
    private List<Appointment> appointments;

    public Clinic(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Clinic name cannot be empty");
        }
        this.name = name;
        this.appointments = new ArrayList<>();
    }

    public Appointment scheduleAppointment(Patient patient, Doctor doctor, String time) {
        if (patient == null || doctor == null || time == null || time.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid appointment parameters");
        }

        Appointment appointment = new Appointment(patient, doctor, time);
        appointments.add(appointment);

        System.out.println("\nAppointment Scheduled");
        System.out.println("Clinic: " + name);
        System.out.println("Patient: " + patient.getName());
        System.out.println("Doctor: Dr. " + doctor.getName());
        System.out.println("Time: " + time);
        System.out.println("Appointment ID: #" + appointment.getAppointmentId());

        return appointment;
    }

    public void complete(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null");
        }

        if (!appointments.contains(appointment)) {
            throw new IllegalStateException("This appointment does not belong to this clinic");
        }

        appointment.markCompleted();
    }

    public String getName() {
        return name;
    }

    public void printAllAppointments() {
        System.out.println("\nAll Appointments at " + name);
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            for (Appointment apt : appointments) {
                System.out.println("Appointment #" + apt.getAppointmentId() +
                        " - " + apt.getPatient().getName() +
                        " with Dr. " + apt.getDoctor().getName() +
                        " at " + apt.getTime() +
                        " [" + (apt.isCompleted() ? "COMPLETED" : "SCHEDULED") + "]");
            }
        }
    }
}