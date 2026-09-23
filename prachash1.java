import java.util.*;

public class prachash1 {
     static int  distinct(int arr[]) {
         HashSet<Integer> set = new HashSet<>();
         for (int ele : arr) {
             set.add(ele);
         }

         return set.size();
     }

        public static void main (String[] args){
                int arr[] ={1,2,3,4,3,5,8};
                System.out.println(distinct(arr));

        }

    }

