//subarray
import java.util.*;

public class pracmap1 {

    public boolean issubset(int a[],int b[]){
        HashMap<Integer,Integer> map1 = new HashMap<>();
        for(int ele: a){

            if(map1.containsKey(ele)){
                int frq = map1.get(ele);
                map1.put(ele,frq+1);
            }
            else map1.put(ele,1);
        }


        HashMap<Integer,Integer> map2 = new HashMap<>();
        for(int ele: b){
            if(!map1.containsKey(ele)) return false;

            if(map2.containsKey(ele)){
                int frq = map2.get(ele);
                map2.put(ele,frq+1);
            }
            else map2.put(ele,1);
        }

        for(int ele: map2.keySet()){
            int frq = map2.get(ele);
            int afrq = map1.get(ele);
            if(afrq < frq) return false;
        }
        return true;
    }

    public static void main(String []args){
        int a[]= {1,2,3,4,4,5,6};
        int b[]= {1,2,4};
        pracmap1 obj = new pracmap1();
        System.out.println(obj.issubset(a,b));
    }


}
