package lab01;
import java.util.*;

public class bai226_1 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Solve ax + b = 0");
        System.out.printf("The value of a is:" );
        String a = input.nextLine();
        System.out.printf("The value of b is:" );
        String b = input.nextLine();
        if (Double.parseDouble(a) == 0){
            if (Double.parseDouble(b) == 0){
                System.out.println("Always true");
            }
            else{
                System.out.println("No solution");
            }
        }
        else{
            double solution = Double.parseDouble(b)/Double.parseDouble(a);
            System.out.println("The solution is: " + solution);
        }

        input.close();
    }   
}


