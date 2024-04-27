package lab01;
import java.util.*;
import java.lang.Math;

public class bai226_2 {
    public static void main(String args[]){
        System.out.println("Solve the system:");
        System.out.println("a1x + b1y = c1");
        System.out.println("a2x + b2y = c2");
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter the first equation 's coefficent a1, b1 and c1(separate with ' ') : ");

        Double a1 = input.nextDouble();
        Double b1 = input.nextDouble();
        Double c1 = input.nextDouble();

        System.out.printf("Enter the second equation 's coefficent a2, b2 and c2(separate with ' ') : ");

        Double a2 = input.nextDouble();
        Double b2 = input.nextDouble();
        Double c2 = input.nextDouble();

        Double D = Math.abs((a1*b2) - (a2*b1));
        Double Dx = Math.abs((c1*b2) - (c2*b1));
        Double Dy = Math.abs((a1*c2) - (a2*c1));

        if (D != 0){
            Double x = Dx/D;
            Double y = Dy/D;
            System.out.println("The solution is: x = " + x + " y = " + y);
        }else{
            if (Dx == Double.parseDouble("0") && Dy == Double.parseDouble("0")){
                System.out.println("The system has infinity solutions!");
            }else{
                System.out.println("The system has no solution!");
            }
        }
        
        input.close();
    }
}


