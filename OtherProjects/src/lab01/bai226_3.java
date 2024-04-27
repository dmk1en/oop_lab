package lab01;
import java.util.*;
import java.lang.Math;

public class bai226_3 {
    public static void  main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Solve the equation: ax^2 + bx + c = 0");
        System.out.println("Enter the coefficient: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double delta = b*b - 4*a*c;

        if (delta > 0){
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("The solution is : x1 = " + x1 + " x2 = " + x2);
        }
        else if(delta == Double.parseDouble("0")){
            double x = ((-b)/(2 * a));
            System.out.println("The solution is : x = " + x);
        }
        else{
            System.out.println("No solution!");
        }
        sc.close();
    }
}


