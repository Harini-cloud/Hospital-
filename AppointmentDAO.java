package project_anp;

import java.util.List;

public interface AppointmentDAO {
    void addAppointment(AppointmentDTO appt);
    List<AppointmentDTO> getAllAppointments();
    void deleteAppointment(int id);
    void updateStatus(int id, String status);
    AppointmentDTO getAppointmentById(int id);
    int generateTokenNumber(String doctorName, java.sql.Date date);
}
