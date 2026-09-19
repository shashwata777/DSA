
import java.util.*;
public class gethint {


        public static String getHint(String secret, String guess) {

            int bulls = 0;
            int[] secretCount = new int[10];
            int[] guessCount = new int[10];

            for (int i = 0; i < secret.length(); i++) {

                if (secret.charAt(i) == guess.charAt(i)) {
                    bulls++;
                } else {
                    secretCount[secret.charAt(i) - '0']++;
                    guessCount[guess.charAt(i) - '0']++;
                }
            }

            int cows = 0;

            for (int i = 0; i < 10; i++) {
                cows += Math.min(secretCount[i], guessCount[i]);
            }

            return bulls + "A" + cows + "B";
        }

        public static void main(String[] args) {

            String secret = "1807";
            String guess = "7810";

            System.out.println(getHint(secret, guess));
        }
    }



