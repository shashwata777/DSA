import java.util.*;

public class snakepattern2d {

    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of rows");
        int rows = sc.nextInt();
        System.out.println("enetr the no of columns ");
        int cols = sc.nextInt();
        int[][]arr = new int[rows][cols];


        System.out.println("enter the matrix");
          for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
               arr[i][j]= sc.nextInt();
                  System.out.print(arr[i][j]+ " ");
               }
                System.out.println();
        }
        for(int i=0;i<arr.length;i++){
            if(i%2==0) {
                for (int j = 0; j <arr[0].length ; j++) {
                    System.out.println(arr[i][j]+" ");
                    
                }
            }
            else {
                for (int j =arr[0].length-1; j>=0  ; j--) {
                    System.out.println(arr[i][j]+ " ");

                }
            }
            System.out.println();
            
            }


    }

  }
