
//dp problem
import java.util.*;
public class sticklerthief {

    static int [] dp;
    public static  int findmaxsum(int arr[]){
        int n = arr.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        return loot(0,arr);
    }
    public static int loot(int i, int[] arr){
        if(i >=arr.length) return 0;
        if(dp[i]!= -1) return dp[i];
        int pick = arr[i] + loot(i+2 , arr);
        int skip= loot(i+1,arr);
        int ans = Math.max(pick,skip);
        dp[i] = ans;
        return ans;

    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of houses: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter money in each house:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result =  findmaxsum(arr);

        System.out.println("Maximum money = " + result);


    }

}
