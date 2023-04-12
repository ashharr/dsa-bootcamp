package binarytrees;
import java.util.ArrayList;
public class TreeNode {
    String data;
    int val;
    NodeTree left;
    NodeTree right;
    ArrayList<NodeTree> children;

    public TreeNode(String data) {
        this.data = data;
        this.children = new ArrayList<NodeTree>();

    }

    public void addChild(NodeTree node){
        this.children.add(node);
    }

    public String print(int level){
        StringBuilder res;
        res = new StringBuilder("  ".repeat(level) + data + "\n");
        for ( NodeTree node:
        this.children) {
            res.append(node.print(level + 1));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        NodeTree drinks = new NodeTree("Drinks");
        NodeTree hot = new NodeTree("Hot");
        NodeTree cold = new NodeTree("Cold");
        NodeTree coffee = new NodeTree("Coffee");
        NodeTree tea = new NodeTree("Tea");
        NodeTree pepsi = new NodeTree("Pepsi");
        NodeTree coke = new NodeTree("Coke");

        drinks.addChild(hot);
        drinks.addChild(cold);
        hot.addChild(tea);
        hot.addChild(coffee);
        cold.addChild(pepsi);
        cold.addChild(coke);
        System.out.println(drinks.print(0));


    }
}
