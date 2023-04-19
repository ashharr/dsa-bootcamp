package binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

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

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new LinkedList<List<Integer>>();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            if(root == null) return ans;
            while(!q.isEmpty()){
                int level = q.size();
                List<Integer> subList = new LinkedList<Integer>();
                for (int i = 0; i < level; i++) {
                    assert q.peek() != null;
                    if(q.peek().left != null)
                        q.offer(q.peek().left);

                    assert q.peek() != null;
                    if(q.peek().right != null)
                        q.offer(q.peek().right);
                    subList.add(q.poll().val);
                }
                ans.add(subList);
            }
            return ans;
        }
    }
}
