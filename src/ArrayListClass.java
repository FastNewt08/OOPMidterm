import java.util.ArrayList;
import java.util.Scanner;

class Student_$ {
    private String name;
    private int age;
    private String studentId;
    private double gpa;
    private static int totalStudent = 0;

    public Student_$(String name, int age, String studentId, double gpa) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.gpa = gpa;
        totalStudent++;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age < 0){
            return;
        }
        this.age = age;
    }
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        if (gpa < 65 || gpa > 100){
            return;
        }
        this.gpa = gpa;
    }

    public static int getTotalStudent() {
        return totalStudent;
    }

    public void displayInfo(){
        System.out.println("Student Name: " + getName());
        System.out.println("Student Age: " + getAge());
        System.out.println("Student Id: " + getStudentId());
        System.out.println("Student GPA: " + getGpa());
        System.out.println("====================================");
    }
}
public class ArrayListClass {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student_$> students = new ArrayList<>(); //constructor name

    public static void displayMenu(){
        System.out.println("=== Student Management System ===");
        System.out.println("A. Add Student");
        System.out.println("B. Remove Student by ID");
        System.out.println("C. Update Student by ID");
        System.out.println("D. Display Students");
        System.out.println("E. Exit");
        System.out.println("Choose an option");
    }
    public static void addStudent(){
        System.out.println("Enter Student Name:");
        String name = sc.nextLine();
        System.out.println("Enter Student Age: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.println("Enter Student ID: ");
        String studentID = sc.nextLine();
        System.out.println("Enter Student GPA: ");
        double gpa = sc.nextDouble(); sc.nextLine();

        students.add(new Student_$(name, age, studentID, gpa));
    }
    public static void removeStudent(){
        System.out.println("Enter Student ID to remove: ");
        String id = sc.nextLine();
        boolean removed = false;

        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getStudentId().equalsIgnoreCase(id)){
                students.remove(i);
                removed = true;
                System.out.println("Student with ID: " + id + " was removed.");
            }
        }
        if (!removed){
            System.out.println("Student not found.");
        }
    }
    public static void updateStudent(){
        System.out.println("Enter the Id of Student to Update: ");
        String id = sc.nextLine();
        boolean found = false;

        for (Student_$ student : students){
            if (student.getStudentId().equalsIgnoreCase(id)){
                System.out.println("Enter new Name: ");
                String newName = sc.nextLine();
                if (!newName.isEmpty()){
                    student.setName(newName);
                }
                System.out.println("Enter new Age: ");
                int newAge = sc.nextInt(); sc.nextLine();
                if (newAge > 0){
                    student.setAge(newAge);
                }
                System.out.println("Enter new GPA: ");
                double newGpa = sc.nextDouble(); sc.nextLine();
                if (newGpa > 0){
                    student.setGpa(newGpa);
                }
                found = true;
                System.out.println("Student with ID: " + id + " was updated.");
            }
            if (!found){
                System.out.println("Student not found.");
            }
        }
    }
    public static void displayStudents(){
        if (students.isEmpty()){
            System.out.println("Student list is empty.");
            return;
        }
        for (Student_$ student : students){
            student.displayInfo();
        }
        System.out.println("Total Students : " + Student_$.getTotalStudent());
    }

    public static void main(String[] args) {
        String input = "";
        do {
            displayMenu();
            input = sc.nextLine();
            switch (input.toUpperCase()){
                case "A":
                    addStudent();
                    break;
                case "B":
                    removeStudent();
                    break;
                case "C":
                    updateStudent();
                    break;
                case "D":
                    displayStudents();
                    break;
            }
        } while (!input.equalsIgnoreCase("E"));
        System.out.println("Exiting...");
    }
}