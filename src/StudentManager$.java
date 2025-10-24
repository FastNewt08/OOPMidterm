import java.util.Scanner;

class Student$ {
    private String name;
    private int age;
    private String studentId;
    private double gpa;
    private static int studentCount = 0;

    public Student$(String name, int age, String studentId, double gpa) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.gpa = gpa;
        studentCount++;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Invalid age");
            return;
        }
        this.age = age;
    }

    public String getStudentId() {
        return studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if(gpa < 65 || gpa > 100) {
            System.out.println("Invalid GPA");
            return;
        }
        this.gpa = gpa;
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public static void setStudentCount(int studentCount) {
        Student$.studentCount = studentCount;
    }
    public void study(){
        System.out.println(getName() + " is studying.");
    }
    public void displayInfo(){
        System.out.println("Student Name: " + getName());
        System.out.println("Student Age: " + getAge());
        System.out.println("Student ID: " + getStudentId());
        System.out.println("Student GPA: " + getGpa());
    }
}
public class StudentManager$ {
    static Scanner sc = new Scanner(System.in);
    static Student$ [] students1 = new Student$[10];
    static int studentCounter = 0;

    public static void main(String[] args) {
        String input = "";

        do {
            displayMenu();
            input = sc.nextLine();
            switch (input.toUpperCase()){
                case "A":
                    addStudents();
                    break;
                case "B":
                    remove();
                    break;
                case "C":
                    displayAllStudents();
                    break;
            }
        } while (!input.toUpperCase().equals("D"));
    }
    public static void displayMenu(){
        System.out.println("=== Student Management System ===");
        System.out.println("A. Add Student");
        System.out.println("B. Remove Student");
        System.out.println("C. Display All Students");
        System.out.println("D. Exit");
        System.out.print("Choose an option: ");
    }
    public static void addStudents(){
        if (studentCounter == students1.length){
            System.out.println("The Array is full.");
            return;
        }
        System.out.println("Student ## " + (studentCounter + 1) );
        System.out.println("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Student Age: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.println("Enter Student ID: ");
        String id = sc.nextLine();
        System.out.println("Enter Student GPA: ");
        double gpa = sc.nextDouble(); sc.nextLine();

        students1[studentCounter++] = new Student$(name, age, id, gpa);
    }
    public static void displayAllStudents(){
        if (studentCounter == 0){
            System.out.println("The array is empty.");
            return;
        }
        System.out.println("Total Students: " + Student$.getStudentCount());
        for (int i = 0; i < studentCounter; i++){
            students1[i].displayInfo();
        }
    }
    public static void remove(){
        if (studentCounter == 0){
            System.out.println("The array is empty.");
            return;
        }
        System.out.println("Enter ID to remove: ");
        String id = sc.nextLine();

        int index = -1;
        for (int i = 0; i < studentCounter; i++){
            if (students1[i].getStudentId().equalsIgnoreCase(id)){
                index = i;
            }
        }
        for (int i = index; i < studentCounter - 1; i++){
            System.out.println(i);
            students1[i] = students1[i + 1];
        }
        students1[--studentCounter] = null;
    }
}
