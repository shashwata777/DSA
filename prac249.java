public class prac249 {


        public static int maximumSaleItems(int[][] items, int budget) {
            int n = items.length;

            int[] free = new int[n];

            // Count free items for each purchased item type
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j && items[j][0] % items[i][0] == 0) {
                        free[i]++;
                    }
                }
            }

            int[] dp = new int[budget + 1];

            for (int i = 0; i < n; i++) {
                int price = items[i][1];
                int bonus = free[i];

                int[] current = new int[budget + 1];

                for (int b = price; b <= budget; b++) {
                    current[b] = dp[b - price] + 1 + bonus;
                }

                for (int b = price; b <= budget; b++) {
                    current[b] = Math.max(
                            current[b],
                            current[b - price] + 1
                    );
                }

                for (int b = 0; b <= budget; b++) {
                    dp[b] = Math.max(dp[b], current[b]);
                }
            }

            return dp[budget];
        }

        public static void main(String[] args) {

            int[][] items = {
                    {6, 2},
                    {2, 6},
                    {3, 4}
            };

            int budget = 9;

            System.out.println(maximumSaleItems(items, budget));
        }
    }


