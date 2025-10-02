import java.io.*;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    String designation;
    double salary;

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + designation + "," + salary;
    }

    public static Employee fromString(String line) {
        String[] parts = line.split(",");
        return new Employee(Integer.parseInt(parts[0]), parts[1], parts[2], Double.parseDouble(parts[3]));
    }
}

public class EmployeeManagementSystem {
    static final String FILE_NAME = "employees.txt";

    public static void addEmployee(Employee emp) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(emp.toString());
            bw.newLine();
            System.out.println("Employee added successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayEmployees() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- Employee Records ---");
            while ((line = br.readLine()) != null) {
                Employee emp = Employee.fromString(line);
                System.out.println("ID: " + emp.id + ", Name: " + emp.name +
                                   ", Designation: " + emp.designation + ", Salary: " + emp.salary);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No employees found. Add some first!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Designation: ");
                    String desig = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    Employee emp = new Employee(id, name, desig, salary);
                    addEmployee(emp);
                    break;

                case 2:
                    displayEmployees();
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}
