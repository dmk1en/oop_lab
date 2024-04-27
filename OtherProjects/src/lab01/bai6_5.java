package lab01;
import java.util.*;


public class bai6_5 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the ammount of numbers: ");
        int n = sc.nextInt();
        int[] list = new int[n];

        for (int i = 0; i < n ; i ++){
            list[i] = sc.nextInt();
        }
        Float sum = 0f;
        Arrays.sort(list);
        System.out.print("The sorted array: ");
        for (int num : list){
            System.out.print(num + " ");
            sum += num;
        }
        System.out.println();
        System.out.print("The sum: " + sum);
        System.out.println();
        Float average = sum/n;

        System.out.print("The average: " + average);
        sc.close();
    }
}




