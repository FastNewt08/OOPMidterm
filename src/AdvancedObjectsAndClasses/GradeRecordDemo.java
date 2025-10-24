package AdvancedObjectsAndClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//
//class GradeRecord {
//    private String subject;
//    private double [] scores;
//    private double average;
//
//    public GradeRecord(String subject, double q1, double q2, double q3) {
//        this.subject = subject;
//        scores = new double[3];
//
//        if (q1 >= 0 && q1 <= 100 && q2 >= 0 && q2 <= 100 && q3 >= 0 && q3 <= 100){
//            scores[0] = q1;
//            scores[1] = q2;
//            scores[2] = q3;
//
//            average = (q1 + q2 + q3)/3;
//        } else {
//            scores[0] = scores[1] = scores[2] = 0;
//            average = 0;
//            System.out.println("Error: Invalid Score/s.");
//        }
//    }
//
//    public String getSubject() {
//        return subject;
//    }
//    public double[] getScores() {
//        return scores;
//    }
//    public double getAverage() {
//        return average;
//    }
//    public void displayReport(){
//        System.out.printf(getSubject() + " | " + "Quizzes: " + Arrays.toString(getScores()) + " | Average: %.2f%n",  getAverage());
//    }
//}
//public class GradeRecordDemo {
//    public static void main(String[] args) {
//        ArrayList<GradeRecord> s = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//
//        while (true) {
//            System.out.print("Enter subject name (or 'done' to finish): ");
//            String subject = sc.nextLine();
//            if (subject.equalsIgnoreCase("done")) {
//                break;
//            }
//            System.out.print("Enter Quiz 1: ");
//            double q1 = sc.nextDouble();
//            sc.nextLine();
//            System.out.print("Enter Quiz 2: ");
//            double q2 = sc.nextDouble();
//            sc.nextLine();
//            System.out.print("Enter Quiz 3: ");
//            double q3 = sc.nextDouble();
//            sc.nextLine();
//
//            GradeRecord object = new GradeRecord(subject, q1, q2, q3);
//            if (object.getAverage() < 0) {
//                System.out.println("Invalid score! All scores must be between 0 and 100. Record not saved.");
//                break;
//            } else {
//                s.add(object);
//            }
//        }
//
//        if (s.isEmpty()){
//            System.out.println("No grade records to display.");
//        }
//        double totalAverage = 0;
//        System.out.println();
//        for (GradeRecord object : s){
//            object.displayReport();
//            totalAverage += object.getAverage();
//        }
//
//        double overAll = totalAverage / s.size();
//        System.out.printf("Overall Average Across All Subjects: %.2f%n", overAll);
//        System.out.println("Total Subjects Recorded: " + s.size());
//        System.out.println();
//        System.out.println("Test = Test " + s.size());
//    }
//}
class GradeRecord{
    private String subject;
    private double [] scores;
    private double average;

    GradeRecord(String subject, double q1, double q2, double q3){
        this.subject = subject;
        scores = new double[3];

        if (q1 > 0 && q1 < 100 && q2 > 0 && q2 < 100 && q3 > 0 && q3 < 100){
            scores[0] = q1;
            scores[1] = q2;
            scores[2] = q3;

            average = (q1 + q2 + q3) / scores.length;
        } else {
            scores[0] = scores[1] = scores[2] = 0;
            average = 0;
            System.out.println("Error: Invalid Input.");
        }
    }

    public String getSubject() {
        return subject;
    }

    public double[] getScores() {
        return scores;
    }

    public double getAverage() {
        return average;
    }
    public void displayReport(){
        System.out.printf(getSubject() + " | Quizzes: " + Arrays.toString(getScores()) + " | Average: %.2f%n" , getAverage());
    }
}
public class GradeRecordDemo {
    public static void main(String[] args) {
        ArrayList<GradeRecord> grades = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.print("Enter subject (or 'done' to finish): ");
            String subject = sc.nextLine();
            if (subject.equalsIgnoreCase("done")){
                break;
            } else {
                System.out.print("Enter Quiz 1: ");
                double q1 = sc.nextDouble(); sc.nextLine();
                System.out.print("Enter Quiz 2: ");
                double q2 = sc.nextDouble(); sc.nextLine();
                System.out.print("Enter Quiz 3: ");
                double q3 = sc.nextDouble(); sc.nextLine();

                GradeRecord record = new GradeRecord(subject, q1,q2,q3);

                if (record.getAverage() < 0){
                    System.out.println("Invalid score! All scores must be between 0 and 100. Record not saved.");
                    break;
                } else {
                    grades.add(record);
                }
            }
        }

        if (grades.isEmpty()){
            System.out.println("No grade records to display.");
        } else {
            double totalAverage = 0;
            for (GradeRecord grade : grades){
                grade.displayReport();
                totalAverage += grade.getAverage();
            }

            double overallAve = totalAverage/ grades.size();
            System.out.printf("Overall Average Across All Subjects: %.2f%n", overallAve);
            System.out.println("Total Subjects Recorded: " + grades.size());
        }
    }
}
