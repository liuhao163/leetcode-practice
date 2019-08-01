package com.leetcode.structs.topological;

import java.util.*;

/**
 * @Author: liuhaoeric
 * Create time: 2019/08/01
 * Description:
 */
public class Graph {
    private int v;
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void topoSortByKahn() {

        int[] indegree = new int[v];
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
//              i--->adj[i].get(j)
                int w = adj[i].get(j);
                indegree[w]++;
            }
        }

        Map<Integer, LinkedList<Integer>> queueMap = new HashMap<>();

        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queueMap.put(i, new LinkedList<>());
                queueMap.get(i).add(i);
                result.put(i, new ArrayList<>());
            }
        }

        for (Map.Entry<Integer, LinkedList<Integer>> queue : queueMap.entrySet()) {
            while (!queue.getValue().isEmpty()) {
                int v = queue.getValue().remove();
                result.get(queue.getKey()).add(v);
                for (int j = 0; j < adj[v].size(); j++) {
                    //              i--->adj[i].get(j)
                    int k = adj[v].get(j);
                    indegree[k]--;
                    if (indegree[k] == 0) {
                        queue.getValue().add(k);
                    }
                }
            }
        }

        for (List<Integer> ret : result.values()) {
            System.out.print(ret);
            System.out.println();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
    }

    public static void main(String[] args) {

        Graph g = new Graph(10);

//     执行   9->5->1->2->7->0;

//     执行   3->4->6->8
        g.addEdge(9, 5);
        g.addEdge(5, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 7);
        g.addEdge(7, 0);

        g.addEdge(3, 4);
        g.addEdge(4, 6);
        g.addEdge(6, 8);
        g.topoSortByKahn();
    }
}
