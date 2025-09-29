import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private double [] grades;
    private static int totalStudents = 0;

    Student(String name, int age, int size){
        this.name = name;
        this.age = age;
        this.grades = new double[size];
        totalStudents++;
    }
    public String getName() {
        return name;
    }
    public static int getTotalStudents() {
        return totalStudents;
    }
    public double[] getGrades() {
        return grades;
    }
    public int getAge() {
        return age;
    }
    public void setGrades(int subjectIndex, double grade){
        if (subjectIndex >= 0 && subjectIndex < getGrades().length){
            grades[subjectIndex] = grade;
        } else {
            System.out.println("Invalid subject index.");
        }
    }
    public double calculateAverage(){
        double sum = 0;
        for (int i = 0; i < getGrades().length; i++){
            sum += grades[i];
        }
        //System.out.println("The average of " + getName() + "'s grades: " + average);
        return sum/getGrades().length;
    }

    @Override
    public String toString() {
        return "Name: " + getName()  + ", Age: " + getAge() + ", Average: " + calculateAverage();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter student name: ");
        String name = sc.next();

        System.out.println("Enter student age: ");
        int age = sc.nextInt();

        System.out.println("Enter number of subjects: ");
        int size = sc.nextInt();

        Student student = new Student(name, age, size);

        for (int i = 0; i < size; i++){
            System.out.print("Enter grade for subject " + (i + 1) + ": ");
            double grade = sc.nextDouble();
            student.setGrades(i, grade);
        }

        System.out.println(student.toString());

        if (student.calculateAverage() >= 75){
            System.out.println("Result: Passed");
        } else {
            System.out.println("Result: Failed");
        }
        System.out.println(Student.getTotalStudents());
    }
}
