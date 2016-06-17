package dfs;

import java.util.*;

/**
 * Created by rajat on 6/16/16.
 */
public class Itinerary {

    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new LinkedList<>();
        if (tickets == null) return result;
        Map<String, PriorityQueue<String>> adjList = getAdjList(tickets);
        itneraryUtil("JFK", adjList, result);
        return result;
    }

    private void itneraryUtil(String source, Map<String, PriorityQueue<String>> adjList,
                              List<String> result) {
        while (adjList.containsKey(source) && !adjList.get(source).isEmpty()) {
            String dest = adjList.get(source).poll();
            itneraryUtil(dest, adjList, result);
        }
        result.add(0, source);
    }

    private Map<String, PriorityQueue<String>> getAdjList(String[][] tickets) {
        Map<String, PriorityQueue<String>> adjList = new HashMap<>();
        for (String[] ticket : tickets) {
            PriorityQueue<String> queue;
            if (adjList.containsKey(ticket[0])) queue = adjList.get(ticket[0]);
            else queue = new PriorityQueue<>();
            queue.offer(ticket[1]);
            adjList.put(ticket[0], queue);
        }
        return adjList;
    }

    public static void main(String[] args) {
        String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        System.out.println(new Itinerary().findItinerary(tickets));
    }
}
