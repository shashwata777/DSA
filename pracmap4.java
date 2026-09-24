//frequent charecter

import java.util.*;

public class pracmap4 {

public char getmax(String s){
    HashMap<Character,Integer> map = new HashMap<>();
    for (int i = 0; i <s.length() ; i++) {
        char ch =s.charAt(i);
        if(map.containsKey(ch)){
            int frq = map.get(ch);
            map.put(ch,frq+1);

        }
        else map.put(ch,1);
        
    }
    int maxfrq = 0;
    for(char ch : map.keySet()){
        int frq = map.get(ch);

        if(frq>maxfrq)  maxfrq=frq;
    }

    char ans ='\0';
    for(char ch : map.keySet()){
        int frq = map.get(ch);

        if(frq==maxfrq && ch>ans){
        ans=ch;

        }

    }
return ans;
    
}
    public static void main (String[] args){
        pracmap4 obj = new pracmap4();

        System.out.println(obj.getmax("banana"));
        System.out.println(obj.getmax("aabbcc"));
        System.out.println(obj.getmax("programming"));

    }


}
