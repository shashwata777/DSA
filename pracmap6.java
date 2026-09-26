// count equal pairs

import java.util.*;

public class pracmap6 {

    long equal(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0; i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        long pairs = 0;
        for(char ch : map.keySet()){
            long frq = map.get(ch);
            pairs +=frq*frq;
        }
        return pairs;
    }

    public static void main(String[]args){

        pracmap6 obj = new pracmap6();
        String s = "aa";
        System.out.println(obj.equal(s));
    }
}
