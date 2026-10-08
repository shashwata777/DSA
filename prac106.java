public class prac106 {

    public int reverseDegree(String s) {

        int sum =0;

        for (int i =0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int position = ch - 'a' + 1;
            int reversePosition = 27 - position;
            sum = sum + (reversePosition * (i + 1));
        }

        return sum;
    }

            public  static void main(String[] args) {


                String s = "abc";

                prac106 obj = new prac106();

                System.out.println(obj.reverseDegree(s));


    }
}
