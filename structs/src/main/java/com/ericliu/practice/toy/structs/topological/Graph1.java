package com.ericliu.practice.toy.structs.topological;

import java.util.*;

/**
 * @Author: liuhaoeric
 * Create time: 2019/08/01
 * Description:
 */
public class Graph1 {
    private int v;
    private LinkedList<Integer>[] adj;

    public Graph1(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void topoSortByKahn() {
        int[] indegree = new int[adj.length];
        for (LinkedList<Integer> list : adj) {
            for (Integer j : list) {
                indegree[j]++;
            }
        }

        Map<Integer, List<Integer>> ret = new HashMap<>();
        Map<Integer, LinkedList<Integer>> queue = new LinkedHashMap<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                queue.put(i, new LinkedList<>());
                queue.get(i).add(i);

                ret.put(i, new ArrayList<>());
                ret.get(i).add(i);
            }
        }

        for (Map.Entry<Integer, LinkedList<Integer>> entry : queue.entrySet()) {

            List<Integer> r = ret.get(entry.getKey());

            LinkedList<Integer> q = entry.getValue();
            while (!q.isEmpty()) {
                int vertex = q.remove();
                for (Integer j : adj[vertex]) {
                    indegree[j]--;
                    if (indegree[j] == 0) {
                        q.add(j);
                        r.add(j);
                    }
                }
            }
        }

        System.out.println(ret);
    }


    //深度优先遍历
    public void topoSortByDFS() {
        LinkedList<Integer>[] inverseAdj = new LinkedList[v];
        for (int i = 0; i < adj.length; i++) {
            inverseAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < adj.length; i++) {
            for (Integer j : adj[i]) {
                inverseAdj[j].add(i);
            }
        }

        boolean[] visted = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visted[i]) {
                visted[i] = true;
                dfs(i, inverseAdj, visted);
            }
        }

    }

    public void dfs(int v, LinkedList<Integer>[] inverseAdj, boolean[] visted) {
        for (Integer i : inverseAdj[v]) {
            if (visted[i]) {
                continue;
            }
            visted[i] = true;
            dfs(i, inverseAdj, visted);
        }

        System.out.print("->" + v);
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
    }

    public static void main(String[] args) {

        Graph1 g = new Graph1(10);

//     执行   9->5->1->2->7->3->4->6->8->0;

        g.addEdge(5, 1);
        g.addEdge(9, 5);
        g.addEdge(1, 2);
        g.addEdge(2, 7);
        g.addEdge(7, 3);

        g.addEdge(3, 4);
        g.addEdge(4, 6);
        g.addEdge(6, 8);
        g.addEdge(8, 0);
        g.topoSortByKahn();

        g.topoSortByDFS();
    }
}
