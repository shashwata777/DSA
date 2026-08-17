import java.util.*;

public class Hashset2sum {

    public static void main(String[] args) {

        int arr[] = {1, 2, 2, 3, 4, 4, 5};
        int target = 7;

        boolean result = countelements(arr, target);

        System.out.println("Two sum exists: " + result);
    }

        public static boolean  countelements(int arr[],int target){
            HashSet<Integer> set = new HashSet<>();
            for(int ele : arr){
                int rem = target - ele;
                if(set.contains(rem)) {
                    return true;
                }
                set.add(ele);
            }

            return false;
        }
    }


