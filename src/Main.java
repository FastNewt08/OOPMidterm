import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = new int[10];
        int count = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
                System.out.println("Enter number: ");
                int input = sc.nextInt();

                if (input <= 0){
                    System.out.println("Invalid Number.");
                    break;
                } else {
                    arr[i] = input;
                    count++;
                    sum += arr[i];
                }
        }
        for (int i = 0; i < count; i++){
            System.out.println(arr[i]);
        }
        System.out.println("Second last number: " + (arr[count - 2]));
        double average = (double) sum /count;
        System.out.println(average);

        for (int i = 0; i < count; i++){
            if (arr[i] < average){
                System.out.println(arr[i]);
            }
        }
    }
}