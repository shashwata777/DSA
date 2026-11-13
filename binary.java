public class binary {

    public int search(int[] arr, int target){
        int n= arr.length;
        int l=0,h=n-1;
        while(l<=h){
            int mid =(l+h)/2;
            if (arr[mid] == target)
                return mid ;
            else if (arr[mid] < target)
                l= mid+1;
            else  h = mid-1;


        }
        return -1;
    }
    public static void main (String[] args){
        binary  obj = new binary();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int target = 3;
        System.out.println(obj.search(arr,target));


    }
}
