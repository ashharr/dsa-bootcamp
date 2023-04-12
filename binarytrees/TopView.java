package binarytrees;

//{ Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;



public class TopView {

        static class Node{
            int data;
            Node left;
            Node right;
            Node(int data){
                this.data = data;
                left=null;
                right=null;
            }
        }
    public static class Pair {
        int line;
        Node t;

        Pair(Node t,int line){
            this.line = line;
            this.t = t;
        }
    }
    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(root == null){
            return result;
        }

        // add your code


        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair curr = q.remove();
            int line = curr.line;
            Node temp = curr.t;

            if(map.get(line) == null) map.put(line, temp.data);

            if(temp.left != null){
                q.add(new Pair(temp.left, line-1));
            }
            if(temp.right != null){
                q.add(new Pair(temp.right, line+1));
            }

        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            result.add(entry.getValue());
        }
        return result;

    }
}