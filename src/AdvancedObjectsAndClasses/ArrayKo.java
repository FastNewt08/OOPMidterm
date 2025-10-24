package AdvancedObjectsAndClasses;

//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class ArrayKo {
//    public static void main(String[] args) {
//        ArrayList<Double> grades = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//
//        double sum = 0;
//
//        System.out.println("Enter grades (0 or negative to stop): ");
//        while (true) {
//            if (sc.hasNextDouble()) {
//                double grade = sc.nextDouble();
//
//                if (grade <= 0) {
//                    break;
//                }
//                grades.add(grade);
//                sum += grade;
//            } else {
//                System.out.println("Invalid input.");
//                sc.next();
//            }
//        }
//        System.out.println("Total grades: " + grades.size());
//        System.out.println();
//
//        for (int i = 0; i < grades.size(); i++){
//            System.out.println("Grade " + (i+1) + ": " + grades.get(i));
//        }
//
//        if (!grades.isEmpty()){
//            double maxGrade = grades.get(0);
//            double minGrade = grades.get(0);
//
//            for (int i = 0; i < grades.size(); i++){
//                if (grades.get(i) > maxGrade) maxGrade = grades.get(i);
//                if (grades.get(i) < minGrade) minGrade = grades.get(i);
//            }
//            double average = sum/grades.size();
//
//            System.out.println("Highest grade: " + maxGrade);
//            System.out.println("Lowest grade: " + minGrade);
//            System.out.printf("Average grade: %.2f%n" , average);
//        }
//    }
//}

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayKo {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        ArrayList<Double> grades = new ArrayList<>();

        double sum = 0;
        System.out.println("Enter number (0 or negative to stop): ");
        while (true){
            if (sc.hasNextDouble()){
                double grade = sc.nextDouble();
                if (grade < 0){
                    break;
                } else {
                    grades.add(grade);
                    sum += grade;
                }
            }
        }
        System.out.println("Total grades: " + grades.size());
        System.out.println();

        for (int i = 0; i < grades.size(); i++){
            System.out.println("Grade " + (i+1) + ": " + grades.get(i));
        }

        if(!grades.isEmpty()){
            double maxGrade = grades.get(0);
            double minGrade = grades.get(0);

            for (int i = 0; i < grades.size(); i++){
                if (grades.get(i) > maxGrade) maxGrade = grades.get(i);
                if (grades.get(i) < minGrade) minGrade = grades.get(i);
            }
            double average = sum/grades.size();

            System.out.println("Highest Grade: " + maxGrade);
            System.out.println("Lowest Grade: " + minGrade);
            System.out.printf("Average Grade: %.2f%n" ,average);
        }
    }
}