package binarytrees;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorder {
    List<Integer> res=new ArrayList<>();
    public List<Integer> inorderTraversal(NodeTree root) {
        while(root!= null){
            if(root.left == null){
                res.add(root.val);
                root = root.right;
            }
            else {
                NodeTree prev = root.left;
                while(prev.right != null && prev.right != root){
                    prev = prev.right;
                }
                if(prev.right == null){
                    // create a thread to root
                    prev.right = root;
                    root = root.left;
                } else {
                    // destroy the thread
                    prev.right = null;
                    res.add(root.val);
                    root = root.right;
                }
            }
        }

        return res;
    }
}
