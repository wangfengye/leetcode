package QueueAndStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hashMap = new HashMap<>();//key为原始元素,value为clone元素
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hashMap.put(node, head);
        searchDFS(hashMap, node);
        return head;
    }

    private void searchDFS(HashMap<UndirectedGraphNode, UndirectedGraphNode> hashMap, UndirectedGraphNode node) {
        if (node == null) return;
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (!hashMap.containsKey(neighbor)) {
                UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                hashMap.put(neighbor, newNeighbor);
                searchDFS(hashMap, neighbor);
            }
            hashMap.get(node).neighbors.add(hashMap.get(neighbor));
        }
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int label) {
        this.label = label;
        neighbors = new ArrayList<>();
    }
}