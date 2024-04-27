package lab01;
import java.util.*;

public class bai225 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two numbers you want to perform: ");
        String str_x1 = input.nextLine();
        String str_x2 = input.nextLine();

        double x1 = Double.parseDouble(str_x1);
        double x2 = Double.parseDouble(str_x2);

        double sum = x1+x2;
        double dif = x1-x2;
        double prod = x1*x2;
        String quot;
        if (x2 != 0){
            quot = String.valueOf(x1/x2);
        }else{
            quot = "Error!";
        }

        System.out.println("The sum is: "+sum);
        System.out.println("The different is: "+dif);
        System.out.println("The product is: "+prod);
        System.out.println("The quotient is: "+ quot);
        
        input.close();
        System.exit(0);
}}



