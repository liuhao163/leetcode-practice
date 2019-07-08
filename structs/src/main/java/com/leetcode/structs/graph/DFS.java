package com.leetcode.structs.graph;

import java.util.*;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/7/8
 */
public class DFS {
    private List<Vertex> graph = new ArrayList<>();
    private Set<Vertex> visited = new HashSet<>();
    private Map<Integer, Integer> path = new HashMap<>();

    private boolean found = false;

    public DFS(List<Vertex> graph) {
        this.graph = graph;

        graph.forEach(vertex -> {
            path.put(vertex.getVal(), -1);
        });
    }

    public void search(Vertex end) {
        search(graph.get(0), end);
        GraphUtil.printPath(path, graph.get(0), end.getVal());
    }

    public void search(Vertex start, Vertex end) {
        if (found) {
            return;
        }
        visited.add(start);
        if (start.equals(end)) {
            found = true;
            return;
        }

        for (Vertex adjV : start.getAdj()) {
            if (visited.contains(adjV)) {
                continue;
            }
            path.put(adjV.getVal(), start.getVal());
            visited.add(adjV);
            search(adjV, end);
        }
    }

}
