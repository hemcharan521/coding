import java.util.Scanner;
import java.util.ArrayList;

class Employee {

    // Final variable
    final String companyName = "TechNova Solutions";

    int id;
    String name;
    double basicSalary;
    double allowance;
    Department dept;//first read the main class department then read this
    //here this is a reference variable not a object
    //below we create a department object and send value but to link it to specific employee we need this variable

    // Constructor with all parameters
    Employee(int id, String name, double basicSalary, double allowance, Department dept) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        this.allowance = allowance;
        this.dept = dept;
    }

    // Overloaded constructor
    Employee(int id, String name) {
        this(id, name, 0, 0, null);
    }

    double calculateNetSalary() {
        return basicSalary + allowance;
    }

    static void companyPolicy() {
        System.out.println("\nPolicy: All employees must work 8 hours/day with 90% attendance.\n");
    }
//     //// 🔹 Non-static version of displayEmployee()
// void displayEmployee() {
//     System.out.println("---- Employee Details ----");
//     System.out.println("Company: " + companyName);
//     System.out.println("Employee ID: " + id);
//     System.out.println("Name: " + name);
//     System.out.println("Basic Salary: " + basicSalary);
//     System.out.println("Allowance: " + allowance);
//     System.out.println("Net Salary: " + calculateNetSalary());
    
//     if (dept != null)
//         dept.displayDept();
// }//non static version
//in main we should have use e1.display,e2.display
//since we use arraylist we can for each to print all employees at once or use name match to employee then print specific like in bank  using found

    static void displayEmployee(Employee e) {
        System.out.println("\n---- Employee Details ----");
        System.out.println("Company: " + e.companyName);
        System.out.println("Employee ID: " + e.id);
        System.out.println("Name: " + e.name);
        System.out.println("Basic Salary: " + e.basicSalary);
        System.out.println("Allowance: " + e.allowance);
        System.out.println("Net Salary: " + e.calculateNetSalary());//note netsalary is not stored instead called while printing
        if (e.dept != null)
            e.dept.displayDept();
        System.out.println("---------------------------");
    }

    // Nested Static Class
    static class Department {
        int deptId;
        String deptName;

        Department(int deptId, String deptName) {
            this.deptId = deptId;
            this.deptName = deptName;
        }

        void displayDept() {
            System.out.println("Department ID: " + deptId);
            System.out.println("Department Name: " + deptName);
        }
    }
}

// 🔹 Main class
public class test2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        Employee.companyPolicy();  // Show once at start

        int choice;
        do {
            System.out.println("\n=== Employee Payroll System ===");
            System.out.println("1. Add New Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Display Specific Employee by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Basic Salary: ");
                    double bs = sc.nextDouble();
                    System.out.print("Enter Allowance: ");
                    double al = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Department ID: ");
                    int did = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Department Name: ");
                    String dname = sc.nextLine();

                    Employee.Department dept = new Employee.Department(did, dname);
                    //if department is non static it should have looked like
                    //Employee.Department dept=emp.new Department()
                    //here we created a department object but it does not belong to any employee yet
                    Employee emp = new Employee(id, name, bs, al, dept);//notice we  send dept(dept is object not a reference variable) to link it to the current employee
                    employees.add(emp);
                    System.out.println("✅ Employee added successfully!");
                    break;

                case 2:
                    if (employees.isEmpty())
                        System.out.println("No employees to display!");
                    else
                        for (Employee e : employees)
                            Employee.displayEmployee(e);
                    break;

                case 3:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;
                    for (Employee e : employees) {//datatype  variable : listname
                        if (e.id == searchId) {
                            Employee.displayEmployee(e);
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        System.out.println("❌ Employee not found!");
                    break;

                case 4:
                    System.out.println("Exiting Payroll System... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 4); // run forever until user chooses 4

        sc.close();
    }
}
