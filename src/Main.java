import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final EmployeeService employeeService = new EmployeeServiceImpl();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        System.out.println("Welcome to the employee Management System please choose your option");
        while (isRunning) {
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Print Employee List");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> deleteEmployee();
                case 3 -> printEmployeeList();
                case 4 -> {
                    isRunning = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid Choice. Please try again.");
            }
        }
    }

    public static void addEmployee() {
        Employee newEmployee = new Employee();
        System.out.println("Enter Employee ID:");
        int id = sc.nextInt();
        newEmployee.setEmployeeId(id);
        System.out.println("Enter Employee Name:");
        sc.nextLine();
        String name = sc.nextLine();
        newEmployee.setEmployeeName(name);
        System.out.println("Enter Employee Designation:");
        String designation = sc.nextLine();
        newEmployee.setEmployeeDesignation(designation);
        System.out.println("Enter Employee Experience:");
        short experience = sc.nextShort();
        newEmployee.setExperience(experience);
        System.out.println("Enter Employee Age:");
        short age = sc.nextShort();
        newEmployee.setAge(age);
        boolean inserted = employeeService.insertEmployee(newEmployee);
        if (!inserted) {
            System.out.println("Sorry, the employee with same employee id is already present\n");
            return;
        }
        System.out.println("Employee Added Successfully!\n");
    }

    private static void deleteEmployee() {
        System.out.println("Enter Employee ID to delete:");
        int id = sc.nextInt();
        boolean isDeleted = employeeService.deleteEmployee(id);
        if (isDeleted) {
            System.out.println("Employee with id " + id + " deleted successfully\n");
        }
        if (!isDeleted) {
            System.out.println("Employee Not Found.\n");
        }
    }

    private static void printEmployeeList() {
        System.out.println("----------Here is your employee list---------");
        ArrayList<Employee> employeeDatabase = employeeService.getAllEmployee();
        if (employeeDatabase.size() == 0) {
            System.out.println("Employee Database is Empty.");
        } else {
            System.out.println("Employee List:");
            for (int i = 0; i < employeeDatabase.size(); i++) {
                System.out.println((i + 1) + ". " + employeeDatabase.get(i).toString());
            }
        }
        System.out.println("----------------------------------------------");
    }
}
