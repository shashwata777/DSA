import java.util.*;

public class missingarray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 3, 6, 7};

        missingarray obj = new missingarray();

        int result = obj.missingnum(arr);

        System.out.println("Missing number: " + result);
    }

    public int missingnum(int[] arr) {

        int n = arr.length + 1;
        int i = 0;

        while (i < arr.length) {

            if (arr[i] == i + 1 || arr[i] == n) {
                i++;
            }
            else {
                int idx = arr[i] - 1;
                swap(arr, i, idx);
            }
        }

        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return n;
    }

    private void swap(int[] arr, int i, int idx) {

        int temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
    }
}