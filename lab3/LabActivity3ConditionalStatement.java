import java.util.Scanner;

public class LabActivity3ConditionalStatement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter hours worked: ");
        double hoursWorked = scanner.nextDouble();

        System.out.print("Enter hourly wage: ");
        double hourlyWage = scanner.nextDouble();

        System.out.print("Enter role code (1-Manager, 2-Supervisor, 3-Staff, 4-Intern): ");
        int jobRoleCode = scanner.nextInt();

        if (hoursWorked > 24) {
            System.out.println("Number of hours worked cannot exceed 24 hours.");
            return;
        } else if (hoursWorked <= 0) {
            System.out.println("Wrong input on daily work hours.");
            return;
        }
        if (age < 18) {
            System.out.println("Minors are not allowed.");
            return;
        } else if (age >= 65) {
            System.out.println("Senior Citizens are not allowed.");
            return;
        }
        String jobRole;
        switch (jobRoleCode) {
            case 1:
                jobRole = "Manager";
                break;
            case 2:
                jobRole = "Supervisor";
                break;
            case 3:
                jobRole = "Staff";
                break;
            case 4:
                jobRole = "Intern";
                break;
            default:
                jobRole = "Undefined";
        }

        String fullName = (lastName + ", " + firstName).toUpperCase();
        int yearsToRetirement = Math.abs(65 - age);
        double dailyWage = (int) Math.round(hoursWorked * hourlyWage);
        double weeklyWage = dailyWage * 5;
        double monthlyWage = weeklyWage * 4;
        double grossYearlyWage = monthlyWage * 12;
        double netYearlyWage = grossYearlyWage - (grossYearlyWage * 0.32) - 1500.00;
        double tax = 0;
        double govBenefit = 1500;
    
        if (netYearlyWage > 250000) {
        tax = netYearlyWage * 0.32;
        }
        double netSalary = netYearlyWage - tax - govBenefit;

        System.out.println("\nEmployee Information");
        System.out.println("--------------------");
        System.out.println("Full Name:\t\t "  + fullName);
        System.out.println("Age:\t\t\t "  + age + " years old");
        System.out.println("Position:\t\t " + jobRole);
        System.out.println("Years to Retirement:\t " + yearsToRetirement + " years");
        System.out.printf("Daily Salary:\t\t Php %.2f\n", dailyWage);
        System.out.printf("Weekly Salary:\t\t Php %.2f\n", weeklyWage);
        System.out.printf("Monthly Salary:\t\t Php %.2f\n",  monthlyWage);
        System.out.printf("Gross Yearly Salary:\t Php %.2f\n", grossYearlyWage);
        System.out.printf("Net Yearly Salary:\t Php %.2f\n", netYearlyWage);
    }
}