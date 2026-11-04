
import java.util.*;

public class prac234 {

        static class Solution {

            class WindowCost {
                TreeMap<Integer, Integer> left = new TreeMap<>();
                TreeMap<Integer, Integer> right = new TreeMap<>();

                long leftSum = 0, rightSum = 0;
                int leftSize = 0, rightSize = 0;

                void addLeft(int num) {
                    left.put(num, left.getOrDefault(num, 0) + 1);
                    leftSum += num;
                    leftSize++;
                }

                void addRight(int num) {
                    right.put(num, right.getOrDefault(num, 0) + 1);
                    rightSum += num;
                    rightSize++;
                }

                void removeLeft(int num) {
                    int count = left.get(num);
                    if (count == 1) left.remove(num);
                    else left.put(num, count - 1);

                    leftSum -= num;
                    leftSize--;
                }

                void removeRight(int num) {
                    int count = right.get(num);
                    if (count == 1) right.remove(num);
                    else right.put(num, count - 1);

                    rightSum -= num;
                    rightSize--;
                }

                void rebalance() {
                    while (leftSize > rightSize + 1) {
                        int val = left.lastKey();
                        removeLeft(val);
                        addRight(val);
                    }

                    while (leftSize < rightSize) {
                        int val = right.firstKey();
                        removeRight(val);
                        addLeft(val);
                    }
                }

                void insert(int num) {
                    if (left.isEmpty() || num <= left.lastKey()) {
                        addLeft(num);
                    } else {
                        addRight(num);
                    }
                    rebalance();
                }

                void erase(int num) {
                    if (left.containsKey(num)) {
                        removeLeft(num);
                    } else {
                        removeRight(num);
                    }
                    rebalance();
                }

                long getCost() {
                    long median = left.lastKey();

                    return median * leftSize - leftSum
                            + rightSum - median * rightSize;
                }
            }

            public long minOperations(int[] nums, int x, int k) {

                int n = nums.length;
                int m = n - x + 1;

                long[] cost = new long[m];

                WindowCost window = new WindowCost();

                for (int i = 0; i < x; i++) {
                    window.insert(nums[i]);
                }

                cost[0] = window.getCost();

                for (int i = x; i < n; i++) {
                    window.erase(nums[i - x]);
                    window.insert(nums[i]);

                    cost[i - x + 1] = window.getCost();
                }

                long INF = Long.MAX_VALUE / 4;

                long[] prev = new long[n + 1];
                long[] curr = new long[n + 1];

                for (int j = 1; j <= k; j++) {

                    Arrays.fill(curr, INF);

                    for (int i = 1; i <= n; i++) {

                        curr[i] = curr[i - 1];

                        if (i >= x && prev[i - x] != INF) {

                            long take = prev[i - x] + cost[i - x];

                            curr[i] = Math.min(curr[i], take);
                        }
                    }

                    long[] temp = prev;
                    prev = curr;
                    curr = temp;
                }

                return prev[n];
            }
        }

        public static void main(String[] args) {

            Solution sol = new Solution();

            int[] nums = {5, -2, 1, 3, 7, 3, 6, 4, -1};

            int x = 3;
            int k = 2;

            long result = sol.minOperations(nums, x, k);

            System.out.println(result);
        }
    }


