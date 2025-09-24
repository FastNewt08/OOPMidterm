public class StudentInfoSys {
    private String name;
    private String idNum;
    private int grade1;
    private int grade2;
    private int grade3;
    private static int totalStudents = 0;

    public StudentInfoSys(String name, String idNum, int grade1, int grade2, int grade3) {
        this.name = name;
        this.idNum = idNum;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
        totalStudents++;
    }
    public String getName() {
        return name;
    }
    public String getIdNum() {
        return idNum;
    }
    public int getGrade1() {
        return grade1;
    }
    public int getGrade2() {
        return grade2;
    }
    public int getGrade3() {
        return grade3;
    }
    public static int getTotalStudents() {
        return totalStudents;
    }
    public double getAverage(){
        return averageGrade();
    }
    public double averageGrade (){
        return ((double) getGrade1() + getGrade2()+ getGrade3() )/ (double) 3;
    }
    public void displayInfo(){
        System.out.println("Name: " + getName());
        System.out.println("Id Number: " + getIdNum());
        System.out.printf("Average: " + "%.2f%n", getAverage());
        System.out.println("=============================");
    }

    public static void main(String[] args) {
        StudentInfoSys s1 = new StudentInfoSys("Alenere", "0310111", 94, 98, 89);
        StudentInfoSys s2 = new StudentInfoSys("Roshan", "9901233", 94, 95, 90);
        StudentInfoSys s3 = new StudentInfoSys("Vince", "5347832", 91, 87, 90);

        s1.displayInfo();
        s2.displayInfo();;
        s3.displayInfo();

        System.out.println("Total students: " + getTotalStudents());
    }
}

