import java.util.*;
class balance{
    int val;
    balance left;
    balance right;

    balance(int val) {
        this.val = val;
    }
}



public class balancedbinarytree {

    public boolean isbalanced(balance root){
        if(root==null) return true;

        int leftlevels = levels(root.left);
        int rightlevels = levels(root.right);
        if (Math.abs(leftlevels - rightlevels) > 1) {
            return false;
        }
        return isbalanced(root.left) &&isbalanced(root.right);
    }
    private int levels(balance root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(
                levels(root.left),
                levels(root.right)
        );
    }

    public static void main (String[]args){

        balancedbinarytree tree = new balancedbinarytree();
        balance a = new balance(3);
        balance b = new balance(4);
        balance c = new balance(2);
        balance d = new balance(-1);
        balance e = new balance(1);
        balance f = new balance(6);
        balance g = new balance(9);

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.left = f;
        c.right = g;

        System.out.println(tree.isbalanced(a));
    }


}
