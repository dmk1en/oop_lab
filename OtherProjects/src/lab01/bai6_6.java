package lab01;
import java.util.*;

public class bai6_6{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the matrix: ");
        System.out.print("Enter the number of columns of the matrix: ");
        int c = sc.nextInt();
        System.out.print("Enter the number of rows of the matrix: ");
        int r = sc.nextInt();

        System.out.println("Enter the data of the first matrix: ");

        int[][] matrix1 = new int[r][c];
        int[][] matrix2 = new int[r][c];
        int[][] matrix3 = new int[r][c];
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                matrix1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the data of the second matrix: ");
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                matrix2[i][j] = sc.nextInt();
            }
        }
        System.out.println("The sum of 2 matrices: ");
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                matrix3[i][j] = matrix1[i][j]+matrix2[i][j];
            }
        }

        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                System.out.print(matrix3[i][j]+" ");
            }
            System.out.println();
        }

        sc.close();
    }
}



