import java.util.Scanner;
import java.util.ArrayList;
public class ArrayL {
    static ArrayList <Double> grades = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static double sum = 0;
    public static void main(String[] args) {

//        System.out.println("Enter grades (0 or negative to stop):");
//        while (true){
//            if (sc.hasNextDouble()){
//                double input = sc.nextDouble();
//                if (input <= 0){
//                    break;
//                }
//                grades.add(input);
//                sum += input;
//            } else {
//                System.out.println("Invalid Input.");
//                sc.next();
//            }
//        }
//        System.out.println("Total grades: " + grades.size());
//        System.out.println();
//
//        for (int i = 0; i < grades.size(); i++){
//          System.out.println("Grade " + (i+1) + ": " + grades.get(i));
//        }
//
//        if (!grades.isEmpty()){
//            double maxGrade = grades.get(0);
//            double minGrade = grades.get(0);
//
//            for (int i = 0; i < grades.size(); i++){
//                double current = grades.get(i);
//                if (current > maxGrade) maxGrade = current;
//                if (current < minGrade) minGrade = current;
//            }
//            double average = sum/grades.size();
//
//            System.out.println("\nHighest grade: " + maxGrade);
//            System.out.println("Lowest grade: " + minGrade);
//            System.out.printf("Average grade: %.2f%n" , average);
//        } else {
//            System.out.println("No grades were entered.");
//        }
        enterGrades();
        displayMimMax();
    }
    public static void enterGrades(){
        System.out.println("Enter grades (0 or negative to stop): ");
        while (true){
            if (sc.hasNextDouble()){
                double grade = sc.nextDouble();
                if (grade <= 0){
                    return;
                }
                grades.add(grade);
                sum += grade;
            }
            else {
                System.out.println("Invalid input.");
                sc.next();
            }
        }
    }
    public static void displayMimMax(){
        for (int i = 0; i < grades.size(); i++){
            System.out.println("Grade " + (i +1) + ": " + grades.get(i));
        }
        if (!grades.isEmpty()){
            double maxGrade = grades.get(0);
            double minGrade = grades.get(0);

            for (int i = 0; i < grades.size(); i++){
                double current = grades.get(i);
                if (current > maxGrade) maxGrade = current;
                if (current < minGrade) minGrade = current;
            }
            double average = sum / grades.size();

            System.out.println("Highest Grade: " + maxGrade);
            System.out.println("Lowest Grade: " + minGrade);
            System.out.printf("Average: %.2f%n" , average);
        } else {
            System.out.println("No grades were entered.");
        }
    }
}
