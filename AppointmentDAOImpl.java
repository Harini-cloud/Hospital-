package project_anp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO {

    @Override
    public int generateTokenNumber(String doctorName, Date date) {
        String sql = "SELECT COUNT(*) FROM appointment WHERE doctor_name=? AND appointment_date=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, doctorName);
            ps.setDate(2, date);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public void addAppointment(AppointmentDTO appt) {
        String sql = "INSERT INTO appointment(patient_name, age, gender, doctor_name, appointment_date, token_number, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, appt.getPatientName());
            ps.setInt(2, appt.getAge());
            ps.setString(3, appt.getGender());
            ps.setString(4, appt.getDoctorName());
            ps.setDate(5, appt.getAppointmentDate());
            ps.setInt(6, appt.getTokenNumber());
            ps.setString(7, appt.getStatus());

            ps.executeUpdate();
            System.out.println("✅ Appointment booked! Token Number: " + appt.getTokenNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        List<AppointmentDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM appointment ORDER BY appointment_date, token_number";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new AppointmentDTO(
                        rs.getInt("appointment_id"),
                        rs.getString("patient_name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("doctor_name"),
                        rs.getDate("appointment_date"),
                        rs.getInt("token_number"),
                        rs.getString("status")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void deleteAppointment(int id) {
        String sql = "DELETE FROM appointment WHERE appointment_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("🗑️ Appointment cancelled.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStatus(int id, String status) {
        String sql = "UPDATE appointment SET status=? WHERE appointment_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("🔄 Status updated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public AppointmentDTO getAppointmentById(int id) {
        String sql = "SELECT * FROM appointment WHERE appointment_id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new AppointmentDTO(
                        rs.getInt("appointment_id"),
                        rs.getString("patient_name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("doctor_name"),
                        rs.getDate("appointment_date"),
                        rs.getInt("token_number"),
                        rs.getString("status")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
