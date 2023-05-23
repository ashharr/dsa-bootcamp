package binarytrees;
import java.util.ArrayList;
public class TreeNode {
    String data;
    int val;
    TreeNode left;
    TreeNode right;
    ArrayList<TreeNode> children;

    public TreeNode(String data) {
        this.data = data;
        this.children = new ArrayList<TreeNode>();

    }

    public void addChild(TreeNode node){
        this.children.add(node);
    }

    public String print(int level){
        StringBuilder res;
        res = new StringBuilder("  ".repeat(level) + data + "\n");
        for ( TreeNode node:
        this.children) {
            res.append(node.print(level + 1));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        TreeNode drinks = new TreeNode("Drinks");
        TreeNode hot = new TreeNode("Hot");
        TreeNode cold = new TreeNode("Cold");
        TreeNode coffee = new TreeNode("Coffee");
        TreeNode tea = new TreeNode("Tea");
        TreeNode pepsi = new TreeNode("Pepsi");
        TreeNode coke = new TreeNode("Coke");

        drinks.addChild(hot);
        drinks.addChild(cold);
        hot.addChild(tea);
        hot.addChild(coffee);
        cold.addChild(pepsi);
        cold.addChild(coke);
        System.out.println(drinks.print(0));


    }
}
