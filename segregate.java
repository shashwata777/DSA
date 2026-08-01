public class segregate {
    public static void main(String[]args) {

        int[] arr = {0, 0, 1, 1, 0};
        int i = 0, j = arr.length - 1;
        while (i < j) {

            while (arr[i] == 0 && i < j) {
                i++;
            }

            while (arr[j] == 1 && i < j) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
             for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
        }
    }
}
