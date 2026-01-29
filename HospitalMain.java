package project_anp;

import java.util.Scanner;

public class HospitalMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppointmentService service = new AppointmentService();
        int choice;

        do {
            System.out.println("\n--- HOSPITAL APPOINTMENT MENU ---");
            System.out.println("1. Book Appointment");
            System.out.println("2. View Appointment Queue");
            System.out.println("3. Cancel Appointment");
            System.out.println("4. Update Appointment Status");
            System.out.println("5. Search Appointment by ID");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Patient Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Gender: ");
                    String gender = sc.nextLine();
                    System.out.print("Doctor Name: ");
                    String doctor = sc.nextLine();
                    System.out.print("Appointment Date (yyyy-mm-dd): ");
                    String date = sc.nextLine();
                    service.bookAppointment(name, age, gender, doctor, date);
                    break;

                case 2:
                    service.viewAppointments();
                    break;

                case 3:
                    System.out.print("Enter Appointment ID to cancel: ");
                    service.cancelAppointment(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Appointment ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Status (Scheduled/Completed/Cancelled): ");
                    String status = sc.nextLine();
                    service.updateStatus(id, status);
                    break;

                case 5:
                    System.out.print("Enter Appointment ID to search: ");
                    service.searchAppointment(sc.nextInt());
                    break;

                case 6:
                    System.out.println("👋 Exiting system...");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
