public class decendingsortar {

        public int search(int[] arr, int target){
            int n= arr.length;
            int l=0,h=n-1;
            while(l<=h){
                int mid =(l+h)/2;
                if (arr[mid] == target)
                    return mid ;
                else if (arr[mid] > target)
                    l= mid+1;
                else if  (arr[mid] < target)
                    h = mid-1;


            }
            return -1;
        }
        public static void main (String[] args){
            decendingsortar obj = new  decendingsortar();
            int[] arr = {100,91,43,29,9,7};
            int target = 9;
            System.out.println(obj.search(arr,target));


        }
    }


