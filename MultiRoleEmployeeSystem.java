
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interfaces defining role-specific attributes
interface Doctor {
    void doctorDetails(String field, int experience);
}

interface Lawyer {
    void lawyerDetails(int fees, String department);
}

interface Engineer {
    void engineerDetails(int salary, String department);
}

// Abstract Employee Class
abstract class Employee {
    int id;
    String name, empRole;

    Employee(int id, String name, String empRole) {
        this.id = id;
        this.name = name;
        this.empRole = empRole;
    }

    abstract void displayDetails();
}

// Doctor Employee Class
class DoctorEmployee extends Employee implements Doctor {
    int experience;
    String field;

    DoctorEmployee(int id, String name, String empRole, String field, int experience) {
        super(id, name, empRole);
        doctorDetails(field, experience);
    }

    public void doctorDetails(String field, int experience) {
        this.field = field;
        this.experience = experience;
    }

    void displayDetails() {
        System.out.println("Doctor Employee Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Role: " + empRole);
        System.out.println("Experience: " + experience + " Years");
        System.out.println("Field: " + field);
        System.out.println("----------------------------");
    }
}

// Lawyer Employee Class
class LawyerEmployee extends Employee implements Lawyer {
    int fees;
    String department;

    LawyerEmployee(int id, String name, String empRole, int fees, String department) {
        super(id, name, empRole);
        lawyerDetails(fees, department);
    }

    public void lawyerDetails(int fees, String department) {
        this.fees = fees;
        this.department = department;
    }

    void displayDetails() {
        System.out.println("Lawyer Employee Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Role: " + empRole);
        System.out.println("Fees: " + fees);
        System.out.println("Department: " + department);
        System.out.println("----------------------------");
    }
}

// Engineer Employee Class
class EngineerEmployee extends Employee implements Engineer {
    int salary;
    String department;

    EngineerEmployee(int id, String name, String empRole, int salary, String department) {
        super(id, name, empRole);
        engineerDetails(salary, department);
    }

    public void engineerDetails(int salary, String department) {
        this.salary = salary;
        this.department = department;
    }

    void displayDetails() {
        System.out.println("Engineer Employee Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Role: " + empRole);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
        System.out.println("----------------------------");
    }
}

// Other-role Employee Class
class OtherRoleEmployee extends Employee {
    OtherRoleEmployee(int id, String name, String empRole) {
        super(id, name, empRole);
    }

    void displayDetails() {
        System.out.println("Other-Role Employee Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Role: " + empRole);
        System.out.println("----------------------------");
    }
}

public class MultiRoleEmployeeSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("Choose an option:\n1. Add Employee\n2. Display Employees\n3. Update Employee\n4. Delete Employee\n5. Exit");
            System.out.print("Enter an Option Number: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();
                    System.out.println("Choose Role: \n1. Doctor\n2. Lawyer\n3. Engineer\n4. Other Role");
                    System.out.print("Enter Employee Role: ");
                    int roleChoice = sc.nextInt();
                    sc.nextLine();

                    switch (roleChoice) {
                        case 1:
                            System.out.print("Enter Doctor Experience: ");
                            int exp = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Doctor Field: ");
                            String field = sc.nextLine();
                            employees.add(new DoctorEmployee(id, name, "Doctor", field, exp));
                            System.out.println("----------------------------");
                            break;
                        case 2:
                            System.out.print("Enter Lawyer Fees: ");
                            int fee = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Lawyer Department: ");
                            String department = sc.nextLine();
                            employees.add(new LawyerEmployee(id, name, "Lawyer", fee, department));
                            System.out.println("----------------------------");
                            break;
                        case 3:
                            System.out.print("Enter Engineer Salary: ");
                            int salary = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Engineer Department: ");
                            String edepartment = sc.nextLine();
                            employees.add(new EngineerEmployee(id, name, "Engineer", salary, edepartment));
                            System.out.println("----------------------------");
                            break;
                        case 4:
                            System.out.print("Enter the Other Role: ");
                            String otherRole = sc.nextLine();
                            employees.add(new OtherRoleEmployee(id, name, otherRole));
                            System.out.println("----------------------------");
                            break;
                        default:
                            System.out.println("Invalid role selection.");
                            System.out.println("----------------------------");
                    }
                    break;
                }
                case 2:
                    if (employees.isEmpty()) {
                        System.out.println("No employees to display!");
                        System.out.println("----------------------------");
                    } else {
                        for (Employee emp : employees) {
                            emp.displayDetails();
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    boolean found = false;
                    for (Employee emp : employees) {
                        if (emp.id == updateId) {
                            System.out.print("Enter new Name: ");
                            emp.name = sc.nextLine();
                            System.out.println("Employee updated successfully!");
                            System.out.println("----------------------------");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Employee not found!");
                        System.out.println("----------------------------");
                    }
                    break;
                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = sc.nextInt();
                    int initialSize = employees.size();
                    employees.removeIf(emp -> emp.id == deleteId);
                    if (employees.size() < initialSize) {
                        System.out.println("Employee deleted successfully!");
                        System.out.println("----------------------------");
                    } else {
                        System.out.println("Employee not found!");
                        System.out.println("----------------------------");
                    }
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                    System.out.println("----------------------------");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    System.out.println("----------------------------");
            }
        }
        sc.close();
    }
}