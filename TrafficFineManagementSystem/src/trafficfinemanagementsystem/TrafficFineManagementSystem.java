package trafficfinemanagementsystem;

import java.util.Scanner;

public class TrafficFineManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner scanner = new Scanner(System.in);
        DriverViolationInfo info = null;

        while (true) {

            System.out.println("\n=== Traffic Fine Management System ===");
            System.out.println("1. Record Violation");
            System.out.println("2. Assess Fine");
            System.out.println("3. Process Payment");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Driver ID: ");
                    String driverId = "";
                    while (true) {
                        System.out.print("Enter an integer: ");
                        if (scanner.hasNextInt()) {
                            driverId = scanner.nextLine();
                            if (driverId.matches("\\d{16}")) {
                                break;
                            } else {
                                System.out.println(
                                        "Invalid input! Please try again.");
                            }
                        } else {
                            System.out.println("Invalid input! Please enter a valid integer.");
                            scanner.next();
                        }
                    }

                    System.out.println("Enter Driver Name: ");
                    String driverName = "";
                    while (true) {
                        System.out.print("Enter a string: ");
                        driverName = scanner.nextLine();
                        if (driverName.matches("[a-zA-Z\\s]+")) {
                            break;
                        } else {
                            System.out.println(
                                    "Invalid input! Please try again.");
                        }
                    }

                    System.out.println("Enter Vehicle Plate (e.g., RAD786D): ");

                    String vehiclePlate = scanner.nextLine();
                    if (!vehiclePlate.matches("[A-Z]{3}\\d{3}[A-Z]")) {
                        System.out.println("Invalid plate format.");
                        break;
                    }

                    System.out.println("Enter Violation Type: ");
                    String violationType = "";

                    while (true) {
                        System.out.print("Enter a string: ");
                        violationType = scanner.nextLine();
                        System.out.print("Enter Violation Type (SPEEDING, RED_LIGHT, NO_HELMET, DUI): ");

                        violationType = scanner.nextLine();

                        if (!violationType.equalsIgnoreCase("SPEEDING") &&
                                !violationType.equalsIgnoreCase("RED_LIGHT") &&
                                !violationType.equalsIgnoreCase("NO_HELMET") &&
                                !violationType.equalsIgnoreCase("DUI")) {
                            System.out.println("Invalid violation type entered.");
                            break;
                        } else {
                            System.out.println(
                                    "Invalid input! String cannot contain numbers or special characters. Please try again.");
                        }
                    }

                    info = new DriverViolationInfo(driverId, driverName, vehiclePlate, violationType);
                    new ViolationEntry(info).recordViolation();
                    break;

                case 2:
                    if (info == null) {
                        System.out.println("Please record a violation.");
                        break;
                    }
                    new FineAssessment(info).assessFine();
                    break;

                case 3:
                    if (info == null || info.getFineAmount() == 0) {
                        System.out.println("Please assess the fine before paying.");
                        break;
                    }
                    new FinePayment(info).processPayment();
                    break;

                case 4:
                    System.out.println("Exiting, Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.Try again.");
            }
        }
    }

}
