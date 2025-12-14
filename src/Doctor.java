import java.util.ArrayList;
import java.util.List;

class Doctor {
    private String name;
    private String specialization;
    private int consultationCount;

    public Doctor(String name, String specialization) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Doctor name cannot be empty");
        }
        this.name = name;
        this.specialization = specialization;
        this.consultationCount = 0;
    }

    public void consult(Patient patient, Appointment appointment) {
        if (patient == null || appointment == null) {
            throw new IllegalArgumentException("Patient and appointment cannot be null");
        }

        if (appointment.isCompleted()) {
            throw new IllegalStateException("Cannot consult a completed appointment");
        }

        if (!appointment.getDoctor().equals(this)) {
            throw new IllegalStateException("This doctor is not assigned to this appointment");
        }

        if (!appointment.getPatient().equals(patient)) {
            throw new IllegalStateException("Patient does not match the appointment");
        }

        System.out.println("\n=== Consultation in Progress ===");
        System.out.println("Dr. " + name + " (" + specialization + ") is consulting " + patient.getName());
        System.out.println("Appointment Time: " + appointment.getTime());

        String diagnosis = "Examined patient. Prescribed medication and follow-up care.";
        patient.addHistoryRecord(this, diagnosis);

        consultationCount++;
        System.out.println("Consultation completed successfully.");
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getConsultationCount() {
        return consultationCount;
    }
}
