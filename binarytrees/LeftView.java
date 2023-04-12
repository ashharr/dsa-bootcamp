package binarytrees;

import java.util.ArrayList;

public class LeftView {

static class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        leftView(root, result, 0);
        return result;
    }

    public void leftView(Node curr, ArrayList<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.data);
        }

        leftView(curr.left, result, currDepth+1);
        leftView(curr.right, result, currDepth+1);

    }
}
