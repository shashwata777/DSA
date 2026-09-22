import java.util.*;
public class prachash2 {

    boolean twosum(int arr[], int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int ele : arr) {
            int rem = target - ele;
            if (set.contains(rem)) {
                return true;
            }
            set.add(ele);
        }
        return false;
    }
    public static void main (String[]args){
        int arr[]={1,2,3,4,5,6,7};
        int target = 9;
        prachash2 obj = new prachash2();
        System.out.println(obj.twosum(arr, target));
    }
}
