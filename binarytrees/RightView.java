//199. Binary Tree Right Side View | Medium
//        Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
//        Example 1:
//
//        Input: root = [1,2,3,null,5,null,4]
//        Output: [1,3,4]
package binarytrees;

import java.util.ArrayList;
import java.util.List;



class RightView {
    public static class NodeTree {
        int val;
        NodeTree left;
        NodeTree right;
        NodeTree() {}
        NodeTree(int val) { this.val = val; }
        NodeTree(int val, NodeTree left, NodeTree right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> rightSideView(NodeTree root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }
    public static void rightView(NodeTree curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth+1);
        rightView(curr.left, result, currDepth+1);

    }
}
