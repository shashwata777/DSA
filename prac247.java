public class prac247 {

        public int smallestUniqueSubarray(int[] nums) {
            int n = nums.length;

            if (n == 1) return 1;

            int[] sa = buildSuffixArray(nums);
            int[] rank = new int[n];
            int[] lcp = new int[n];

            for (int i = 0; i < n; i++) {
                rank[sa[i]] = i;
            }

            // Kasai's LCP algorithm
            int h = 0;

            for (int i = 0; i < n; i++) {
                int pos = rank[i];

                if (pos == 0) continue;

                int j = sa[pos - 1];

                while (i + h < n && j + h < n &&
                        nums[i + h] == nums[j + h]) {
                    h++;
                }

                lcp[pos] = h;

                if (h > 0) h--;
            }

            int ans = n;

            for (int i = 0; i < n; i++) {
                int start = sa[i];

                int maxLCP = lcp[i];

                if (i + 1 < n) {
                    maxLCP = Math.max(maxLCP, lcp[i + 1]);
                }

                if (maxLCP < n - start) {
                    ans = Math.min(ans, maxLCP + 1);
                }
            }

            return ans;
        }

        private int[] buildSuffixArray(int[] nums) {
            int n = nums.length;

            int[] sa = new int[n];
            int[] temp = new int[n];
            int[] rank = nums.clone();
            int[] newRank = new int[n];

            for (int i = 0; i < n; i++) {
                sa[i] = i;
            }

            int maxRank = 100000;
            int k = 1;

            while (true) {

                countingSort(sa, temp, rank, k, maxRank);
                countingSort(temp, sa, rank, 0, maxRank);

                int classes = 1;
                newRank[sa[0]] = 0;

                for (int i = 1; i < n; i++) {
                    int a = sa[i - 1];
                    int b = sa[i];

                    int a1 = rank[a];
                    int b1 = rank[b];

                    int a2 = (a + k < n) ? rank[a + k] : -1;
                    int b2 = (b + k < n) ? rank[b + k] : -1;

                    if (a1 != b1 || a2 != b2) {
                        classes++;
                    }

                    newRank[b] = classes - 1;
                }

                int[] swap = rank;
                rank = newRank;
                newRank = swap;

                maxRank = classes - 1;

                if (classes == n) break;

                k *= 2;
            }

            return sa;
        }

        private void countingSort(int[] input, int[] output,
                                  int[] rank, int offset, int maxRank) {

            int n = input.length;
            int[] count = new int[Math.max(n + 2, maxRank + 2)];

            for (int idx : input) {
                int key = (idx + offset < n)
                        ? rank[idx + offset] + 1 : 0;
                count[key]++;
            }

            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            for (int i = n - 1; i >= 0; i--) {
                int idx = input[i];

                int key = (idx + offset < n)
                        ? rank[idx + offset] + 1 : 0;

                output[--count[key]] = idx;
            }
        }
    }

