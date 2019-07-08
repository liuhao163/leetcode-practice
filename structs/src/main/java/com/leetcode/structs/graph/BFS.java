package com.leetcode.structs.graph;

import java.util.*;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/7/8
 */
public class BFS {

    private List<Vertex> list = new ArrayList<>();

    private LinkedList<Vertex> queue = new LinkedList<>();
    private Set<Vertex> visited = new HashSet<>();
    private Map<Integer, Integer> path = new HashMap<>();

    public BFS(List<Vertex> list) {
        this.list = list;
        list.forEach(v -> {
            path.put(v.getVal(), -1);
        });

    }

    public void search(Vertex end) {
        queue.add(list.get(0));
        visited.add(list.get(0));

        while (queue.size() > 0) {
            Vertex v = queue.poll();
            for(Vertex adjV:v.getAdj()){
                if (visited.contains(adjV)) {
                    continue;
                }

                visited.add(adjV);
                path.put(adjV.getVal(), v.getVal());
                if (adjV.equals(end)) {
                    //print
                    GraphUtil.printPath(path, list.get(0), end.getVal());
                    return;
                }
                queue.add(adjV);
            }
        }
    }
}
