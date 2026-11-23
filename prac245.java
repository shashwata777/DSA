
import java.util.ArrayList;
public class prac245 {

        static class ProductOfNumbers {

            ArrayList<Integer> prefix;

            public ProductOfNumbers() {
                prefix = new ArrayList<>();
                prefix.add(1);
            }

            public void add(int num) {

                if (num == 0) {
                    prefix.clear();
                    prefix.add(1);
                } else {
                    int last = prefix.get(prefix.size() - 1);
                    prefix.add(last * num);
                }
            }

            public int getProduct(int k) {

                int n = prefix.size();

                if (k >= n) {
                    return 0;
                }

                return prefix.get(n - 1) / prefix.get(n - 1 - k);
            }
        }

        public static void main(String[] args) {

            ProductOfNumbers obj = new ProductOfNumbers();

            obj.add(3);
            obj.add(0);
            obj.add(2);
            obj.add(5);
            obj.add(4);

            System.out.println(obj.getProduct(2)); // 20
            System.out.println(obj.getProduct(3)); // 40
            System.out.println(obj.getProduct(4)); // 0

            obj.add(8);

            System.out.println(obj.getProduct(2)); // 32
        }
    }

