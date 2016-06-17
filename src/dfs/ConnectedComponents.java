package dfs;

import java.util.ArrayList;

/**
 * Created by rajat on 6/16/16.
 */
public class ConnectedComponents {

    public int countComponents(int n, int[][] edges) {
        if (n <= 0 || edges == null || edges.length == 0 || edges[0].length == 0) return 0;
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                componentsUtil(i, visited, adjList);
                count++;
            }
        }
        return count;
    }

    private void componentsUtil(int u, boolean[] visited, ArrayList<Integer>[] adjList) {
        visited[u] = true;
        adjList[u].forEach(i -> {
            if (!visited[i]) componentsUtil(i, visited, adjList);
        });
    }
}
