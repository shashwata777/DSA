

import java.util.*;
public class anagram {





        public static List<List<String>> groupAnagrams(String[] strs) {

            Map<String, List<String>> map = new HashMap<>();

            for (String s : strs) {

                int[] count = new int[26];

                for (char c : s.toCharArray()) {
                    count[c - 'a']++;
                }

                StringBuilder key = new StringBuilder();

                for (int i = 0; i < 26; i++) {
                    key.append('#').append(count[i]);
                }

                map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(s);
            }

            return new ArrayList<>(map.values());
        }

        public static void main(String[] args) {

            String[] strs = {
                    "eat",
                    "tea",
                    "tan",
                    "ate",
                    "nat",
                    "bat"
            };

            List<List<String>> result = groupAnagrams(strs);

            System.out.println(result);
        }

}
