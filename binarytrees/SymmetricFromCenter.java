//  101. Symmetric Tree | Easy
//        Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
//
//        Example 1:
//
//        Input: root = [1,2,2,3,4,4,3]
//        Output: true

package binarytrees;

import java.util.ArrayList;

 public class SymmetricFromCenter {
     static class TreeNode {
        String data;
        int val;
        TreeNode left;
        TreeNode right;
        ArrayList<TreeNode> children;

        public TreeNode(String data) {
            this.data = data;
            this.children = new ArrayList<TreeNode>();
        }
    }


     public boolean isSymmetric(TreeNode root) {
         return root==null || isSymmetricHelp(root.left, root.right);
     }

     public boolean isSymmetricHelp(TreeNode left, TreeNode right){
         if(left == null || right == null){
             return left == right;
         }
         if(left.val != right.val){
             return false;
         }
         return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
     }

}
