public class sqroot {

    int floatsqr(int n){

        int root = 0;
        for(int i=0; i <=n; i++){
            if(i*i>n) break;
            root = i;

        }
        return root;
    }

    public static void main(String [] args){
        sqroot obj = new sqroot();
        int  n = 10;
        System.out.println(obj.floatsqr(n));

    }
}
