package project_anp;

import java.sql.Date;

public class AppointmentDTO {

    private int appointmentId;
    private String patientName;
    private int age;
    private String gender;
    private String doctorName;
    private Date appointmentDate;
    private int tokenNumber;
    private String status;

    public AppointmentDTO() {}

    public AppointmentDTO(String patientName, int age, String gender, String doctorName, Date appointmentDate, int tokenNumber, String status) {
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
        this.tokenNumber = tokenNumber;
        this.status = status;
    }

    public AppointmentDTO(int appointmentId, String patientName, int age, String gender, String doctorName, Date appointmentDate, int tokenNumber, String status) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
        this.tokenNumber = tokenNumber;
        this.status = status;
    }

    // Getters & Setters
    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

    public Date getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(Date appointmentDate) { this.appointmentDate = appointmentDate; }

    public int getTokenNumber() { return tokenNumber; }
    public void setTokenNumber(int tokenNumber) { this.tokenNumber = tokenNumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
