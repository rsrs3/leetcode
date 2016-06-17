package dfs;

import java.util.ArrayList;

/**
 * Created by rajat on 6/17/16.
 */
public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        int[] visited = new int[n];
        if (!validTreeUtil(-1, 0, visited, adjList)) return false;
        for (int i : visited) {
            if (i == 0) return false;
        }
        return true;
    }

    private boolean validTreeUtil(int pred, int curr, int[] visited,
                                  ArrayList<Integer>[] adjList) {
        visited[curr] = 1;
        for (int n : adjList[curr]) {
            if (n != pred) {
                if (visited[n] == 1) return false;
                else if (visited[n] == 0 && !validTreeUtil(curr, n, visited, adjList))
                    return false;
            }
        }
        visited[curr] = 2;
        return true;
    }


}
