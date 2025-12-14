import java.util.ArrayList;
import java.util.List;

class Patient {
    private String name;
    private int age;
    private List<String> medicalHistory;

    public Patient(String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.name = name;
        this.age = age;
        this.medicalHistory = new ArrayList<>();
    }

    public void addHistoryRecord(Doctor doctor, String note) {
        if (doctor == null || note == null || note.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid doctor or note");
        }
        String record = "Dr. " + doctor.getName() + ": " + note;
        medicalHistory.add(record);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void printMedicalHistory() {
        System.out.println("\nMedical History for " + name);
        if (medicalHistory.isEmpty()) {
            System.out.println("No medical history recorded.");
        } else {
            for (int i = 0; i < medicalHistory.size(); i++) {
                System.out.println((i + 1) + ". " + medicalHistory.get(i));
            }
        }
    }
}