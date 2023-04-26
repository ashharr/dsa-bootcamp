//104. Maximum Depth of Binary Tree | Easy
//        Given the root of a binary tree, return its maximum depth.
//        A binary tree's maximum depth is the number of nodes along
//        the longest path from the root node down to the farthest leaf node.
//        Example 1:
//        Input: root = [3,9,20,null,null,15,7]
//        Output: 3

package binarytrees;

public class MaxDepthOfTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int maxHeight=1;
    public int maxDepth(TreeNode root) {
        if(root ==null) return 0;
        int h = heightOfTree(root, maxHeight);
        return h;
    }

    public int heightOfTree(TreeNode root, int height){
        if(root == null){
            return maxHeight;
        }
        if(root.right != null){
            maxHeight = Math.max(maxHeight, height+1);
            heightOfTree(root.right, height+1);
        }
        if(root.left != null){
            maxHeight =  Math.max(maxHeight, height+1);
            heightOfTree(root.left, height+1);
        }
        return maxHeight;
    }
}
