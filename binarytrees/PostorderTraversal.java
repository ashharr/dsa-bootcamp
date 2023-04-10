package binarytrees;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    public static class TreeNodes {
        int val;
        PostorderTraversal.TreeNodes left;
        PostorderTraversal.TreeNodes right;
        TreeNodes() {}
        TreeNodes(int val) { this.val = val; }
        TreeNodes(int val, PostorderTraversal.TreeNodes left, PostorderTraversal.TreeNodes right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<Integer> l=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNodes root) {
        traverse(root);
        return l;
    }

    public void traverse(PostorderTraversal.TreeNodes root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        traverse(root.right);
        l.add(root.val);
    }
}
