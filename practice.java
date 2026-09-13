import java.util.*;

public class practice {


        public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

            if (!wordList.contains(endWord)) {
                return 0;
            }

            Set<String> set = new HashSet<>(wordList);
            Queue<String> queue = new LinkedList<>();

            queue.offer(beginWord);

            int steps = 1;

            while (!queue.isEmpty()) {

                int size = queue.size();

                for (int k = 0; k < size; k++) {

                    String word = queue.poll();

                    for (int i = 0; i < word.length(); i++) {

                        char[] chars = word.toCharArray();

                        for (char ch = 'a'; ch <= 'z'; ch++) {

                            if (chars[i] == ch) {
                                continue;
                            }

                            chars[i] = ch;

                            String newWord = new String(chars);

                            if (newWord.equals(endWord)) {
                                return steps + 1;
                            }

                            if (set.contains(newWord)) {
                                queue.offer(newWord);
                                set.remove(newWord);
                            }
                        }
                    }
                }

                steps++;
            }

            return 0;
        }

        public static void main(String[] args) {

            String beginWord = "hit";
            String endWord = "cog";

            List<String> wordList = Arrays.asList(
                    "hot",
                    "dot",
                    "dog",
                    "lot",
                    "log",
                    "cog"
            );

            int result = ladderLength(beginWord, endWord, wordList);

            System.out.println("Output: " + result);
        }
    }
