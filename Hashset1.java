import java.util.*;

public class Hashset1 {
    public static void main(String[]args){
        int arr[] = {1, 2, 2, 3, 4, 4, 5};

        int result = countelements(arr);

        System.out.println("Number of distinct elements: " + result);
    }

    public static int  countelements(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for(int ele : arr) set.add(ele);
        return set.size();
    }
}
