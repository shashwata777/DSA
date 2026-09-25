//pair difference k

import java.util.*;

public class pracmap5 {

    int countpairs(int[] arr, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : arr){
            if(!map.containsKey(ele)){
                map.put(ele,1);
            }
            else map.put(ele,map.get(ele)+1);
        }

        int pairs=0;
        for(int ele : map.keySet()){
            int rem1 = ele-k;
            int rem2 = ele+k;
            if(map.containsKey(rem1)) pairs +=( map.get(ele))*( map.get(rem1));
            if(map.containsKey(rem2)) pairs +=( map.get(ele))*( map.get(rem2));
        }
        pairs /=2;
        return pairs;
    }
    public static void main(String []args){
        pracmap5 obj = new pracmap5();
        int[] arr = {1, 4, 1, 4, 5};
        int k = 3;
        System.out.println(obj.countpairs(arr,k));


    }
}
