package project_anp;

import java.sql.Date;
import java.util.List;

public class AppointmentService {

    AppointmentDAO dao = new AppointmentDAOImpl();

    public void bookAppointment(String name, int age, String gender, String doctor, String dateStr) {
        Date date = Date.valueOf(dateStr);
        int token = dao.generateTokenNumber(doctor, date);
        dao.addAppointment(new AppointmentDTO(name, age, gender, doctor, date, token, "Scheduled"));
    }

    public void viewAppointments() {
        List<AppointmentDTO> list = dao.getAllAppointments();
        for (AppointmentDTO a : list) {
            System.out.println(a.getAppointmentId() + " | " + a.getPatientName() + " | Dr." + a.getDoctorName()
                    + " | " + a.getAppointmentDate() + " | Token: " + a.getTokenNumber() + " | " + a.getStatus());
        }
    }

    public void cancelAppointment(int id) {
        dao.deleteAppointment(id);
    }

    public void updateStatus(int id, String status) {
        dao.updateStatus(id, status);
    }

    public void searchAppointment(int id) {
        AppointmentDTO a = dao.getAppointmentById(id);
        if (a != null) {
            System.out.println(a.getAppointmentId() + " | " + a.getPatientName() + " | Dr." + a.getDoctorName()
                    + " | " + a.getAppointmentDate() + " | Token: " + a.getTokenNumber() + " | " + a.getStatus());
        } else {
            System.out.println("❌ Appointment not found.");
        }
    }
}
