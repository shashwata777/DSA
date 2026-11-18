public class capasityofshipping {
        static int leastWeightCapacity(int[] arr, int n, int d) {
            int max = Integer.MIN_VALUE, sum = 0;
            for (int ele : arr) {
                max = Math.max(max, ele);
                sum += ele;
            }
            int lo = max, hi = sum, ans = -1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (days(mid, arr) <= d) {
                    hi = mid - 1;
                    ans = mid;
                } else {
                    lo = mid + 1;
                }
            }
            return ans;
        }




        // 1 2 3 4 5 6 7 8 9 10 12
        static int days(int capacity, int[] arr) {
            int days = 0;
            int c = capacity;

            for (int ele : arr) {
                if (c >= ele) {
                    c -= ele;
                } else {
                    days++;
                    c = capacity - ele;
                }
            }
            days++;
            return days;
        }
        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int n = arr.length;
            int d = 5;
            System.out.println(leastWeightCapacity(arr, n, d));
        }
    }

