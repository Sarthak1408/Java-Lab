import java.io.*;
import java.util.ArrayList;

public class Employee extends EmployeeSalary {
    protected String EmployeeID, CompanyName, Department, Designation;

    Employee() {
        EmployeeID = CompanyName = Department = Designation = "";
    }

    Employee(Employee empobj) {
        super(empobj.Basic, empobj.NetSalary, empobj.name, empobj.age, empobj.address);
        EmployeeID = empobj.EmployeeID;
        CompanyName = empobj.CompanyName;
        Department = empobj.Department;
        Designation = empobj.Designation;
    }

    protected void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\n\n\nEnter EmployeeID: ");
        this.EmployeeID = br.readLine();
        System.out.print("Enter Company Name: ");
        this.CompanyName = br.readLine();
        System.out.print("Enter Department: ");
        this.Department = br.readLine();
        System.out.print("Enter Designation: ");
        this.Designation = br.readLine();
        super.read();

    }

    private void display() {
        System.out.println("Employee ID: " + this.EmployeeID);
        super.show();
        super.NetSalary();
        System.out.println("Company Name: " + this.CompanyName);
        System.out.println("Department: " + this.Department);
        System.out.println("Designation: " + this.Designation);
        System.out.println("Net Salary: " + this.NetSalary);
    }

    private static int highest_salary(ArrayList<Employee> emp, String Company_Name) {
        int i = 0;
        float max_salary = -999.99F;
        for (i = 0; i < emp.size(); i++) {
            if (emp.get(i).CompanyName.equalsIgnoreCase(Company_Name)) {
                if (max_salary < emp.get(i).NetSalary) {
                    max_salary = emp.get(i).NetSalary;
                }
            }
        }
        System.out.println("Highest Salary Found: "+max_salary);
        if (max_salary == -999.99F)
            System.out.println("\n\nNo employees of said company exist in database!!");
        else {
            System.out.println("\n\nList of employees with highest salary from " + Company_Name + " :~");
            for (i = 0; i < emp.size(); i++) {
                if (emp.get(i).CompanyName.equalsIgnoreCase(Company_Name)) {
                    if (emp.get(i).NetSalary == max_salary)
                        System.out.println("Name: " + emp.get(i).name + " Employee ID: " + emp.get(i).EmployeeID);
                }
            }
        }
        return 0;
    }

    private static int highest_salary(ArrayList<Employee> emp) {
        int i = 0;
        float max_salary = emp.get(i).NetSalary;
        for (i = 0; i < emp.size(); i++) {
            if (max_salary < emp.get(i).NetSalary) {
                max_salary = emp.get(i).NetSalary;
            }
        }

        ArrayList<Employee> HPE_C = new ArrayList<Employee>();

        for (i = 0; i < emp.size(); i++) {
            if (emp.get(i).NetSalary == max_salary) {
                HPE_C.add(new Employee(emp.get(i)));
            }
        }
        System.out.println("\n\nList of employees with highest salary :~");
        for (i = 0; i < HPE_C.size(); i++) {
            System.out.println("Name: " + HPE_C.get(i).name + " Employee ID: " + HPE_C.get(i).EmployeeID
                    + " Company Name: " + HPE_C.get(i).CompanyName);
        }
        return 0;
    }

    private static int lowest_salary(ArrayList<Employee> emp, String Company_Name) {
        int i = 0;
        float min_salary = 0;
        boolean flag = false;
        for (i = 0; i < emp.size(); i++) {
            if (emp.get(i).CompanyName.equalsIgnoreCase(Company_Name)) {
                if (min_salary == 0) {
                    min_salary = emp.get(i).NetSalary;
                    flag = true;
                }
                if (min_salary > emp.get(i).NetSalary) {
                    min_salary = emp.get(i).NetSalary;
                    flag = true;
                }
            }
        }
        if (flag == false)
            System.out.println("\n\nNo employees of said company exist in database!!");
        else {
            System.out.println("\n\nList of employees with lowest salary from " + Company_Name + " :~");
            for (i = 0; i < emp.size(); i++) {
                if (emp.get(i).CompanyName.equalsIgnoreCase(Company_Name) && emp.get(i).NetSalary == min_salary) {
                    System.out.println("Name: " + emp.get(i).name + " Employee ID: " + emp.get(i).EmployeeID);
                }
            }
        }
        return 0;
    }

    private static int lowest_salary(ArrayList<Employee> emp) {
        int i = 0;
        float min_salary = emp.get(i).NetSalary;
        for (i = 0; i < emp.size(); i++) {
            if (min_salary > emp.get(i).NetSalary) {
                min_salary = emp.get(i).NetSalary;
            }
        }
        System.out.println("\n\nList of employees with highest salary :~");
        for (i = 0; i < emp.size(); i++) {
            if (emp.get(i).NetSalary == min_salary) {
                System.out.println("Name: " + emp.get(i).name + " Employee ID: " + emp.get(i).EmployeeID
                        + " Company Name: " + emp.get(i).CompanyName);
            }
        }
        return 0;
    }

    private static int display_menu() {
        System.out.println("\n\nEnter 1 to add employee.");
        System.out.println("Enter 2 to view the list of all the employees in the current database.");
        System.out.println("Enter 3 to view the highest paid employee.");
        System.out.println("Enter 4 to view the highest paid employee of a given company.");
        System.out.println("Enter 5 to view the lowest paid employee.");
        System.out.println("Enter 6 to view the lowest paid employee of a given company.");
        System.out.println("Enter -1 to exit.");
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte choice = 0;
        String company;
        ArrayList<Employee> emplist = new ArrayList<Employee>();
        do {
            display_menu();
            System.out.print("Enter your choice: ");
            choice = Byte.parseByte(br.readLine());
            switch (choice) {
                case 1:
                    Employee obj = new Employee();
                    emplist.add(obj);
                    obj.read();
                    break;
                case 2:
                    System.out.print("\n\nEMPLOYEE LIST:\n******************************\n\n");
                    for (int i = 0; i < emplist.size(); i++) {
                        emplist.get(i).display();
                        System.out.println("\n\n******************************");
                    }
                    break;
                case 3:
                    highest_salary(emplist);
                    break;
                case 4:
                    System.out.print("Enter name of the company to search: ");
                    company = br.readLine();
                    highest_salary(emplist, company);
                    break;
                case 5:
                    lowest_salary(emplist);
                case 6:
                    System.out.print("Enter name of the company to search: ");
                    company = br.readLine();
                    lowest_salary(emplist, company);
                    break;
                case -1:
                    System.out.print("\n\nEnd of Program");
                    break;
                default:
                    System.out.println("Wrong choice. Please try again!!\n\n");
                    break;
            }

        } while (choice != -1);
    }
}
