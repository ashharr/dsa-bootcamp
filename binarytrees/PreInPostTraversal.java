package binarytrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PreInPostTraversal {
      public static class TreeNode {
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
    public static class Pair{
        TreeNode node;
        int traversal;
        Pair(TreeNode node, int t){
            this.node = node;
            this.traversal = t;
        }
    }

    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        Stack<Pair> s = new Stack<>();
        s.push(new Pair(root, 1));

        while(!s.isEmpty()){
            Pair it = s.pop();

            // Preorder first
            // if num == 1 pre
            // increment num
            // if left tree -> add to stack
            if(it.traversal == 1){
                pre.add(it.node.val);
                it.traversal++;
                s.push(it);
                if(it.node.left != null) s.push(new Pair(it.node.left,1));
            }
            // Inorder
            // if num == 2 in
            // increment num
            // if right tree -> add to stack
            else if(it.traversal == 2){
                in.add(it.node.val);
                it.traversal++;
                s.push(it);
                if(it.node.right != null) s.push(new Pair(it.node.right,1));
            }
            else if(it.traversal == 3){
                post.add(it.node.val);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(pre);
        ans.add(in);
        ans.add(post);
        return ans;
    }
}
