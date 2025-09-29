import java.util.Scanner;
import java.util.ArrayList;
public class ArrayL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList <Double> grades = new ArrayList<>();

        int counter = 0;
        double sum = 0;

        System.out.println("Enter grades (0 or negative to stop):");
        while (true){
            if (sc.hasNextDouble()){
                double input = sc.nextDouble();
                if (input <= 0){
                    break;
                }
                grades.add(input);
                sum += input;
                counter++;
            } else {
                System.out.println("Invalid Input.");
            }
        }
        System.out.println("Total grades: " + counter);
        System.out.println();

        for (int i = 0; i < counter; i++){
          System.out.println("Grade " + (i+1) + ": " + grades.get(i));
        }
        System.out.println();
        double maxGrade = grades.get(0);
        for (int i = 0; i < counter; i++){
            if (grades.get(i) > maxGrade){
                maxGrade = grades.get(i);
            }
        }
        System.out.println("Highest grade: " + maxGrade);

        double minGrade = grades.get(0);
        for (int i = 0; i < counter; i++){
            if (grades.get(i) < minGrade){
                minGrade = grades.get(i);
            }
        }
        System.out.println("Lowest grade: " + minGrade);

        double average = 0;
        for (int i = 0; i < counter; i++){
            average = sum/counter;
        }
        System.out.printf("Average grade: %.2f%n" , average);

    }
}
