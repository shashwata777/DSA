public class KokoEatingBananas {
        public static int  kokoEat(int[] arr, int k) {
            int max = Integer.MIN_VALUE;
            for (int ele : arr) {
                max = Math.max(max, ele);
            }
            int lo = 1, hi = max, speed = max;
            while (lo <= hi) {  // O(n * log(max))
                int mid = lo + (hi - lo) / 2;
                if (hours(mid, arr) <= k) {
                    hi = mid - 1;
                    speed = mid;
                } else {
                    lo = mid + 1;
                }
            }
            return speed;
        }
        private static  int hours(int speed, int[] arr) {

            int h = 0;

            for (int ele : arr) {

                if (ele % speed == 0)
                    h += ele / speed;
                else
                    h += (ele / speed + 1);
            }

            return h;
        }

    public static void main(String[] args) {

        int[] arr = {3, 6, 7, 11}; //calculate the banana eating speed per hour
        int k = 8;

        System.out.println(kokoEat(arr, k));
    }
    }

