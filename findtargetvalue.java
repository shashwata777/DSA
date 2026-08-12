// [2,5,7] t=9 output= 0,1

public class findtargetvalue {
    public static void main(String[] args){
        int []arr={2,7,11,5};
        int t =9;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] + arr[j] == t){
                    System.out.println(i +" "+j);
                    System.out.println("[" + i + "," + j + "]");
                }
            }
        }
    }
}
