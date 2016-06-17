package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rajat on 6/17/16.
 */
public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<Integer, UndirectedGraphNode> visited = new HashMap<>();
        return cloneGraphUtil(node, visited);
    }

    private UndirectedGraphNode cloneGraphUtil(UndirectedGraphNode node,
                                               Map<Integer, UndirectedGraphNode> visited) {
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        visited.put(node.label, newNode);
        for (UndirectedGraphNode neighbour : node.neighbors) {
            if (visited.containsKey(neighbour.label)) {
                newNode.neighbors.add(visited.get(neighbour.label));
            } else {
                newNode.neighbors.add(cloneGraphUtil(neighbour, visited));
            }
        }
        return newNode;
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }
}
