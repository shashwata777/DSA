
import java.util.HashMap;

public class prac111 {









        public static boolean isIsomorphic(String s, String t) {
            HashMap<Character, Character> map1 = new HashMap<>();
            HashMap<Character, Character> map2 = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);

                if (map1.containsKey(c1) && map1.get(c1) != c2) {
                    return false;
                }

                if (map2.containsKey(c2) && map2.get(c2) != c1) {
                    return false;
                }

                map1.put(c1, c2);
                map2.put(c2, c1);
            }

            return true;
        }

        public static void main(String[] args) {
            System.out.println(isIsomorphic("egg", "add"));
            System.out.println(isIsomorphic("f11", "b23"));
            System.out.println(isIsomorphic("paper", "title"));
        }
    }







