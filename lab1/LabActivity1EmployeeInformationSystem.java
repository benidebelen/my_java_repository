import java.util.Scanner;

public class LabActivity1EmployeeInformationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee's first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter employee's last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter employee's age: ");
        int age = scanner.nextInt();

        System.out.print("Enter the number of hours worked in a day: ");
        double hoursWorked = scanner.nextDouble();

        System.out.print("Enter the employee's hourly wage: ");
        double hourlyWage = scanner.nextDouble();

        String fullName = firstName + " " + lastName;
        double dailyWage = hoursWorked * hourlyWage;

        System.out.println("\nEmployee Information");
        System.out.println("--------------------");
        System.out.println("Full Name\t: " + fullName);
        System.out.println("Age\t\t: " + age);
        System.out.printf("Daily Wage\t: PHP%.2f\n", dailyWage);
    }
}