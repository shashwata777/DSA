public class prac104 {


    public boolean  same(String s1, String s2) {


        if(s1.equals(s2) ){
            return true;
        }
        return false;

    }

    public static void main (String[]args){

        String s1 = "f11";
        String s2 = "b23";
        prac104 obj = new prac104();
        System.out.println(obj.same(s1,s2));
    }
}


