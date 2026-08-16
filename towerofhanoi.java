
import java.util.*;

public class towerofhanoi {

    public static void main(String[]args){
        hanoi(3,'A','B','C');

    }

    private static void hanoi(int i, char a, char b, char c) {
        if(i==0) return;
        hanoi(i-1,a,c,b);
        System.out.println(a+"->"+c);
        hanoi(i-1,b,a,c);

    }
}
