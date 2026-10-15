public class prac114 {

        public static boolean canConstruct(String ransomNote, String magazine) {
            int[] freq = new int[26];

            for (int i = 0; i < magazine.length(); i++) {
                freq[magazine.charAt(i) - 'a']++;
            }

            for (int i = 0; i < ransomNote.length(); i++) {
                int index = ransomNote.charAt(i) - 'a';

                if (freq[index] == 0) {
                    return false;
                }

                freq[index]--;
            }

            return true;
        }

        public static void main(String[] args) {
            String ransomNote = "aa";
            String magazine = "aab";

            System.out.println(canConstruct(ransomNote, magazine));
        }
    }


