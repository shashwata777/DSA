import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class binarytree {

    // Preorder
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Inorder
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Postorder
    public static void postorder(Node root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }


    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Sum of all nodes
    public static int sumNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return root.val + sumNodes(root.left) + sumNodes(root.right);
    }

    public static void main(String[] args) {

        // Create nodes
        Node a = new Node(3);   // root
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.left = f;
        c.right = g;

        // Traversals
        System.out.print("Preorder: ");
        preorder(a);

        System.out.print("\nInorder: ");
        inorder(a);

        System.out.print("\nPostorder: ");
        postorder(a);

        System.out.println("\nNumber of nodes: " + countNodes(a));
        System.out.println("Sum of nodes: " + sumNodes(a));
    }
}