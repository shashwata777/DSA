// odd + 2 even+10

public class oddevenoperation {

    public static void main(String[]args){
        int [] arr = {1,2,3,4,5,6,7};
        for(int i =0;i<arr.length;i++){
            if(i%2==0){
                arr[i] +=2;
            }
            else{
                arr[i] +=10;
            }
            System.out.print(arr[i] + " ");
        }

    }
}

