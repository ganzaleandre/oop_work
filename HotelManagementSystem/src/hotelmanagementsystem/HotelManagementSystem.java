package hotelmanagementsystem;

import java.util.Scanner;

public class HotelManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== HOTEL MANAGEMENT SYSTEM ===");

        System.out.print("Enter Guest ID: ");
        String guestId = scanner.nextLine();

        System.out.print("Enter Guest Name: ");
        String guestName = scanner.nextLine();

        System.out.print("Enter Room Type (STANDARD/DELUXE/SUITE): ");
        String roomType = scanner.nextLine().toUpperCase();

        System.out.print("Enter Stay Duration (days): ");
        int stayDays = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Room Status (AVAILABLE/OCCUPIED): ");
        String roomStatus = scanner.nextLine().toUpperCase();

        GuestInfo guestInfo = new GuestInfo(guestId, guestName, roomType, stayDays, roomStatus);

        int choice;
        do {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Book Room");
            System.out.println("2. Checkout Guest");
            System.out.println("3. Generate Bill");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice) {
                case 1:
                    RoomBooking booking = new RoomBooking(guestInfo);
                    booking.bookRoom();
                    break;

                case 2:
                    GuestCheckout checkout = new GuestCheckout(guestInfo);
                    checkout.checkoutGuest();
                    break;
                case 3:
                    Billing billing = new Billing(guestInfo);
                    billing.generateBill();
                    break;
                case 4:
                    System.out.println("Exiting system. Thank You.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

}
