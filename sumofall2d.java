
import java.util.*;
public class sumofall2d {

    public static void main (String[]args ){
        Scanner sc = new Scanner(System.in);
        int[][]arr = new int [3] [4];
        int sum = 0;
        System.out.println("enter the matrix");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]= sc.nextInt();
                sum +=arr[i][j] ;
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println("sum ="+ sum);

    }





}
