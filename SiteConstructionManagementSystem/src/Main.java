import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get contractor details
        System.out.print("Enter Contractor ID: ");
        String contractorId = scanner.nextLine();

        System.out.print("Enter Contractor Name: ");
        String contractorName = scanner.nextLine();

        System.out.print("Enter Initial Material Quantity (in tons): ");
        double materialQuantity = scanner.nextDouble();

        double materialBalance = 5.0; // Starting stock

        // Create Contractor object
        Constructor contractor = new Constructor(contractorId, contractorName, materialQuantity, materialBalance);

        int choice;
        do {
            // Menu
            System.out.println("\n=== MENU ===");
            System.out.println("1. Deliver Material");
            System.out.println("2. Use Material");
            System.out.println("3. Estimate Cost");
            System.out.println("4. View Material Balance");
            System.out.println("5. Exit");
            System.out.print("Select an option (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter quantity to deliver (in tons): ");
                    double deliveryQuantity = 0;
                    while (true) {
                        System.out.print("Enter a double: ");
                        if (scanner.hasNextDouble()) {
                            deliveryQuantity = scanner.nextDouble();
                            contractor.setMaterialQuantity(deliveryQuantity);
                            new MaterialDelivery(contractor).receiveMaterial();
                            if (deliveryQuantity >= 0) {
                                break;
                            } else {
                                System.out.println(
                                        "Invalid input! Please try again.");
                            }
                        } else {
                            System.out.println("Invalid input! Please enter a valid double.");
                            scanner.next();
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter quantity to use (in tons): ");
                    double usageQuantity = 0;
                    while (true) {
                        System.out.print("Enter a double: ");
                        if (scanner.hasNextDouble()) {
                            usageQuantity = scanner.nextDouble();
                            contractor.setMaterialQuantity(usageQuantity);
                            new MaterialUsage(contractor).useMaterial();
                            if (usageQuantity >= 0) {
                                break;
                            } else {
                                System.out.println(
                                        "Invalid input! Please try again.");
                            }
                        } else {
                            System.out.println("Invalid input! Please enter a valid double.");
                            scanner.next(); // Clear invalid input
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter quantity used (in tons) for cost estimation: ");
                    double costQuantity = 0;
                    while (true) {
                        System.out.print("Enter a double: ");
                        if (scanner.hasNextDouble()) {
                            costQuantity = scanner.nextDouble();
                            contractor.setMaterialQuantity(costQuantity);
                            new CostEstimation(contractor).estimateCost();
                            if (costQuantity >= 0) {
                                break;
                            } else {
                                System.out.println(
                                        "Invalid input! Please try again.");
                            }
                        } else {
                            System.out.println("Invalid input! Please enter a valid double.");
                            scanner.next(); // Clear invalid input
                        }
                    }
                    break;

                case 4:
                    System.out.println("Current material balance: " + contractor.getMaterialBalance() + " tons.");
                    break;

                case 5:
                    System.out.println("Exiting program. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select between 1 and 5.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
