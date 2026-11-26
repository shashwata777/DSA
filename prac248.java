public class prac248 {

        public static boolean canAliceWin(int n) {
            int remove = 10;
            boolean aliceTurn = true;

            while (n >= remove) {
                n -= remove;
                remove--;
                aliceTurn = !aliceTurn;
            }

            return !aliceTurn;
        }

        public static void main(String[] args) {
            int n = 12;
            System.out.println(canAliceWin(n));
        }
    }

