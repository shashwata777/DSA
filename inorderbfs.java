import java.util.*;



public class inorderbfs {

    ArrayList<Integer> inorder(node root){
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(root,ans);
        return ans;

    }

    void dfs(node root, ArrayList<Integer> ans){
        if(root==null) return;
        dfs(root.left,ans);
        ans.add(root.val);
        dfs(root.right,ans);

    }

    public static void main(String[]args){
        node a = new node(3);
        node b = new node(4);
        node c = new node(2);
        node d = new node(-1);
        node e = new node(1);
        node f = new node(6);
        node g = new node(9);

        a.left = b;
        a.right=c;
        b.left = d;
        b.right = e;

        c.left = f;
        c.right = g;

        inorderbfs obj = new inorderbfs();
        System.out.print("\nInorder: ");
        System.out.println(obj.inorder(a));

    }


}
