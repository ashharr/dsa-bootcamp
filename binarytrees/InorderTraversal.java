//94. Binary Tree Inorder Traversal | Easy
//
//        Given the root of a binary tree, return the inorder traversal of its nodes' values.
//
//        Example 1:
//
//
//        Input: root = [1,null,2,3]
//        Output: [1,3,2]

package binarytrees;

import java.util.ArrayList;
import java.util.List;




public class InorderTraversal {

    public static class TreeNodes {
        int val;
        TreeNodes left;
        TreeNodes right;
        TreeNodes() {}
        TreeNodes(int val) { this.val = val; }
        TreeNodes(int val, TreeNodes left, TreeNodes right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<Integer>l=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNodes root) {
        traverse(root);
        return l;
    }

    public void traverse(TreeNodes root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        l.add(root.val);
        traverse(root.right);
    }
}
