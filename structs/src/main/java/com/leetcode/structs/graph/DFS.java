package com.leetcode.structs.graph;

import java.util.*;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/7/8
 */
public class DFS {

    private List<Vertex> graph = new ArrayList<>();

    //利用visited和path
    private Set<Vertex> visited = new HashSet<>();
    private Map<Integer, Integer> path = new HashMap<>();
    //用于结束递归的标记位发现后置为true停止递归
    private boolean found = false;

    public DFS(List<Vertex> graph) {
        this.graph = graph;
    }

    public void search(Vertex end) {
        graph.forEach(vertex -> {
            path.put(vertex.getVal(), -1);
        });
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
