//missing number

public class missnum {

    int misssum(int arr[]) {

        int n = arr.length + 1;

        int sum = n * (n + 1) / 2;

        int newsum = 0;

        for (int i = 0; i < arr.length; i++) {
            newsum += arr[i];
        }
        return sum - newsum;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 5};

        missnum obj = new missnum();

        System.out.println(obj.misssum(arr));
    }
}