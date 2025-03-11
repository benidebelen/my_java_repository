import java.util.Scanner;

public class LabActivity2EmployeeInformationSystemPart2 {
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

        String fullName = (lastName + ", " + firstName).toUpperCase();
        int yearsToRetirement = Math.abs(65 - age);
        double dailyWage = (int) Math.round(hoursWorked * hourlyWage);
        double weeklyWage = dailyWage * 5;
        double monthlyWage = weeklyWage * 4;
        double grossYearlyWage = monthlyWage * 12;
        double netYearlyWage = grossYearlyWage - (grossYearlyWage * 0.32) - 1500.00;

        System.out.println("\nEmployee Information");
        System.out.println("--------------------");
        System.out.println("Full Name:\t\t "  + fullName);
        System.out.println("Age:\t\t\t "  + age + " years old");
        System.out.println("Years to Retirement:\t " + yearsToRetirement + " years");
        System.out.printf("Daily Salary:\t\t Php %.2f\n", dailyWage);
        System.out.printf("Weekly Salary:\t\t Php %.2f\n", weeklyWage);
        System.out.printf("Monthly Salary:\t\t Php %.2f\n",  monthlyWage);
        System.out.printf("Gross Yearly Salary:\t Php %.2f\n", grossYearlyWage);
        System.out.printf("Net Yearly Salary:\t Php %.2f\n", netYearlyWage);
    }
}