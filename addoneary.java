import java.util.*;
public class addoneary {

    static ArrayList<Integer> addone(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int carry = 1;
        for (int i = n - 1; i >= 0; i--) {
            int sum = arr[i] + carry;

            if (sum <= 9) {
                ans.add(sum);
                carry = 0;
            } else {
                ans.add(0);
                carry = 1;
            }
        }
        if (carry == 1) {
            ans.add(1);
        }

        Collections.reverse(ans);
        return ans;
    }
    public static void main(String[] args) {

        int[] arr = {9, 9, 9};

        ArrayList<Integer> result = addone(arr);

        System.out.println(result);
    }
}