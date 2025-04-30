 import java.util.Scanner;
 
 public class MyMidtermLabExam {

    static final int MAX_TICKETS = 5;
    static String[] issueDescriptions = new String[MAX_TICKETS];
    static String[] urgencyLevels = new String[MAX_TICKETS];
    static String[] statuses = new String[MAX_TICKETS];
    static int ticketCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== IT Ticket System ===");
            System.out.println("1. Add Ticket");
            System.out.println("2. Update Ticket Status");
            System.out.println("3. Show All Tickets");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTicket(scanner);
                    break;
                case 2:
                    updateTicketStatus(scanner);
                    break;
                case 3:
                    showTickets();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

        } while (choice != 5);

        scanner.close();
    }

    public static void addTicket(Scanner scanner) {
        if (ticketCount >= MAX_TICKETS) {
            System.out.println("Maximum number of tickets reached.");
            return;
        }

        System.out.print("Enter issue description: ");
        String description = scanner.nextLine();

        String urgency;
        while (true) {
            System.out.print("Enter urgency level (Low/Medium/High): ");
            urgency = scanner.nextLine();
            if (urgency.equalsIgnoreCase("Low") || urgency.equalsIgnoreCase("Medium") || urgency.equalsIgnoreCase("High")) {
                break;
            } else {
                System.out.println("Invalid urgency level. Please enter Low, Medium, or High.");
            }
        }

        issueDescriptions[ticketCount] = description;
        urgencyLevels[ticketCount] = urgency;
        statuses[ticketCount] = "Pending";
        ticketCount++;

        System.out.println("Ticket successfully added!");
    }

    public static void updateTicketStatus(Scanner scanner) {
        if (ticketCount == 0) {
            System.out.println("No tickets available to update.");
            return;
        }

        showTickets();
        System.out.print("Enter ticket number to update: ");

        int ticketNum = scanner.nextInt();
        scanner.nextLine();

        if (ticketNum < 1 || ticketNum > ticketCount) {
            System.out.println("Invalid ticket number.");
            return;
        }

        int index = ticketNum - 1;

        if (statuses[index].equalsIgnoreCase("Resolved")) {
            System.out.println("Ticket is already resolved. Cannot update.");
            return;
        }

        String newStatus;
        while (true) {
            System.out.print("Enter new status (In Progress / Resolved): ");
            newStatus = scanner.nextLine();
            if (newStatus.equalsIgnoreCase("In Progress") || newStatus.equalsIgnoreCase("Resolved")) {
                break;
            } else {
                System.out.println("Invalid status. Please enter 'In Progress' or 'Resolved'.");
            }
        }

        statuses[index] = newStatus;
        System.out.println("Ticket status updated.");
    }

    public static void showTickets() {
        if (ticketCount == 0) {
            System.out.println("No tickets to display.");
            return;
        }

        System.out.println("\n--- All Tickets ---");
        for (int i = 0; i < ticketCount; i++) {
        System.out.println((i + 1) + ". [" + capitalize(urgencyLevels[i]) + "] " + issueDescriptions[i] + " - Status: " + capitalize(statuses[i]));
    }
}
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
}   

    public static void generateReport() {
        int resolvedCount = 0;
        int pendingCount = 0;

        for (int i = 0; i < ticketCount; i++) {
            if (statuses[i].equalsIgnoreCase("Resolved")) {
                resolvedCount++;
            } else {
                pendingCount++;
            }
        }

        System.out.println("\n=== Ticket Report ===");
        System.out.println("Total Tickets: " + ticketCount);
        System.out.println("Pending Tickets: " + pendingCount);
        System.out.println("Resolved Tickets: " + resolvedCount);
    }
}
