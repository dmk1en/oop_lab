package lab01;
import java.util.*;

public class bai6_3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter a number: ");
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            for (int k=1;k<(n-i);k++){
                System.out.printf(" ");
            };
            for (int j = 1; j<=(2*i+1);j++){
                System.out.printf("*");
            };
            System.out.println();

        }

        sc.close();
    }
}




