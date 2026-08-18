import java.util.*;

public class hashmap1 {

    public static boolean check(int[] a, int[] b) {

        HashMap<Integer, Integer> amap = new HashMap<>();

        for (int ele : a) {
            if (amap.containsKey(ele)) {
                int frq = amap.get(ele);
                amap.put(ele, frq + 1);
            } else {
                amap.put(ele, 1);
            }
        }

        HashMap<Integer, Integer> bmap = new HashMap<>();
        for (int ele : b) {
            if (bmap.containsKey(ele)) {
                int frq = bmap.get(ele);
                bmap.put(ele, frq + 1);
            } else {
                bmap.put(ele, 1);
            }
        }

        for (int ele : bmap.keySet()) {

            int bfrq = bmap.get(ele);

            if (!amap.containsKey(ele)) {
                return false;
            }

            int afrq = amap.get(ele);
            if (afrq < bfrq) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = {2, 3, 5, 7};

        boolean result = check(a, b);

        System.out.println(result);
    }
}