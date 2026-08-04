import java.util.*;

public class insertion {

        public static void PrintArray(int arr[]){
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");

            }
            System.out.println();

        }
        public static void main(String[] args) {
            int arr[] = {3, 4, 5, 2, 1};


            for (int i = 1; i < arr.length ; i++) {
                int curr = arr[i];
                int j= i-1;
                while(j >=0 && curr <arr[j]){
                    arr[j+1] = arr[j];
                    j--;
                }
                arr[j+1] = curr;
            }

            PrintArray(arr);
        }

        }



