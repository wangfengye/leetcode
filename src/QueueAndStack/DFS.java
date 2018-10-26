package QueueAndStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * DFS:深度优先遍历
 */
public class DFS {
    /**
     * 自建栈
     * @param node
     */
    public void dfs(Node node){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (stack.size()>0){
            Node base = stack.pop();
            System.out.print(base.val+" - ");
            for (int i =base.nodes.size()-1; i >=0 ; i--) {
                stack.push(base.nodes.get(i));
            }
        }
    }
    public void dfs2(Node node){
        System.out.print(node.val+" - ");
        for (Node child : node.nodes) {
            dfs(child);
        }
    }

    public static void main(String[] args){
        Node head = new Node(1);
        Node row21 = new Node(21);
        Node row22= new Node(22);
        Node row23= new Node(23);
        head.add(row21).add(row22).add(row23);
        Node row31 = new Node(31);
        Node row32 = new Node(32);
        row21.add(row31).add(row32);
        Node row33 = new Node(33);
        Node row34= new Node(34);
        row22.add(row33).add(row34);
        Node row35 = new Node(35);
        Node row36= new Node(36);
        row23.add(row35).add(row36);
        new DFS().dfs(head);
        System.out.println("\n/******************/");
        new DFS().dfs2(head);
    }

}
class Node{
    int val;
    List<Node> nodes;

    public Node(int val) {
        this.val = val;
        nodes = new ArrayList<>();
    }
    Node add(Node node){
        nodes.add(node);
        return this;
    }
}
