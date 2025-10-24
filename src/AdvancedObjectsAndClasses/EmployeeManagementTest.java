package AdvancedObjectsAndClasses;

import java.util.ArrayList;
class       Company{
    private String companyName;
    private ArrayList<Employee> employees = new ArrayList<Employee>();

    public Company(String companyName) {
        this.companyName = companyName;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void addEmployee(Employee employee){
        employees.add(employee);
    }
    public boolean removeEmployee(String id){
        for (Employee employee : employees){
            if (employee.getEmployeeId().equalsIgnoreCase(id)){
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }
    public Employee findEmployee(String id){
        for (Employee employee : employees){
            if (employee.getEmployeeId().equalsIgnoreCase(id)){
                return employee;
            }
        }
        return null;
    }
    public double getAverageSalary(){
        if (employees.isEmpty()){
            return 0.0;
        }
        double total = 0.0;
        for (Employee employee : employees){
            total += employee.getSalary();
        }
        return total/employees.size();
    }
    public int getTotalEmployees(){
        return employees.size();
    }
    public void displayAllEmployees(){
        if (employees.isEmpty()){
            System.out.println("No employees found.");
            return;
        }
        for (Employee employee : employees){
            employee.displayEmployeeInfo();
        }
    }
}
class Employee{
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            System.out.println("Invalid salary amount.");
            return;
        }
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public void giveRaise(double percentage){
        if (percentage <= 0) {
            System.out.println("Raise percentage must be positive.");
            return;
        }
        double increase = salary * (percentage /100);
        salary += increase;
    }
    public void displayEmployeeInfo(){
        System.out.println("\nEmployee ID: " + getEmployeeId());
        System.out.println("Name: " + getName());
        System.out.println("Position: " + getPosition());
        System.out.println("Salary: " + getSalary());
    }
}
public class EmployeeManagementTest {
    public static void main(String[] args) {
        Company company = new Company("Tech Solutions Inc.");

        Employee emp1 = new Employee("E001", "Sarah Williams", "Software Engineer", 75000.0);
        Employee emp2 = new Employee("E002", "Michael Chen", "Project Manager", 85000.0);
        Employee emp3 = new Employee("E003", "Emily Davis", "UI Designer", 65000.0);

        company.addEmployee(emp1);
        company.addEmployee(emp2);
        company.addEmployee(emp3);

        System.out.println("Company: " + company.getCompanyName());
        System.out.println("Total Employees: " + company.getTotalEmployees());
        System.out.println("Average Salary: $" + company.getAverageSalary());
        System.out.println();

        System.out.print("All Employees:");
        company.displayAllEmployees();

        System.out.println("\nGiving 10% raise to Sarah Williams...");
        Employee found = company.findEmployee("E001");
        if (found != null) {
            found.giveRaise(10.0);
            found.displayEmployeeInfo();
        }

        System.out.println("\nPromoting Emily Davis to Senior UI Designer...");
        Employee emp3Found = company.findEmployee("E003");
        if (emp3Found != null) {
            emp3Found.setPosition("Senior UI Designer");
            emp3Found.setSalary(75000.0);
        }

        System.out.println("\nUpdated Company Information:");
        System.out.printf("Average Salary: $ %.2f%n" , company.getAverageSalary());
    }
}