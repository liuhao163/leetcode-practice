package com.leetcode.structs.graph;

import java.util.*;

/**
 * @Author: liuhaoeric
 * Create time: 2019/07/08
 * Description:
 */
public class Graph {
    private int val;
    //邻接表
    private LinkedList<Graph> adj = new LinkedList<>();

    public Graph(int val) {
        this.val = val;
    }

    public void addAdj(Graph g) {
        adj.add(g);
    }

    public int getVal() {
        return val;
    }

    public LinkedList<Graph> getAdj() {
        return adj;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "v=" + val +
                '}';
    }


    public static void bfs(List<Graph> graphs, Graph end) {
        LinkedList<Graph> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Integer[] path = new Integer[graphs.size()];

        for (int i = 0; i < graphs.size(); i++) {
            path[i] = -1;
        }

        visited.add(graphs.get(0).getVal());
        queue.add(graphs.get(0));

        while (queue.size() > 0) {
            Graph g = queue.poll();
            visited.add(g.getVal());
            for (int i = 0; i < g.getAdj().size(); i++) {
                Graph adj = g.getAdj().get(i);
                if (visited.contains(adj.getVal())) {
                    continue;
                }

                //当前adj下标设置为g的值
                path[adj.getVal()] = g.getVal();
                if (adj.getVal() == end.getVal()) {
                    print(path, graphs.get(0), end.getVal());
                }

                visited.add(adj.getVal());
                queue.add(adj);
            }
        }
    }

    private static boolean found=false;
    public static void sfs(List<Graph> graphs, Graph end) {
        LinkedList<Graph> stack = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Integer[] path = new Integer[graphs.size()];

        for (int i = 0; i < graphs.size(); i++) {
            path[i] = -1;
        }

//        visited.add(graphs.get(0).getVal());

        bfsearch(visited, path,graphs.get(0), end);

        print(path, graphs.get(0), end.getVal());

//        while (stack.size() > 0) {
//            Graph g = stack.removeFirst();
//
//            for (int i = 0; i < g.getAdj().size(); i++) {
//                Graph adj = g.getAdj().get(i);
//                if (visited.contains(adj.getVal())) {
//                    continue;
//                }
//
//                //当前adj下标设置为g的值
//                path.add(adj.getVal(), g.getVal());
//                if (adj.getVal() == end.getVal()) {
//                    print(path, graphs.get(0), end.getVal());
//                }
//
//                visited.add(adj.getVal());
//                stack.addFirst(adj);
//            }
//        }
    }

    private static void bfsearch(Set<Integer> visited, Integer[] path,Graph g, Graph end) {
        if (found) {
            return;
        }
        visited.add(g.getVal());
        if (g.getVal() == end.getVal()) {
            found=true;
            return;
        }

        for (int i = 0; i < g.getAdj().size(); i++) {
            if(visited.contains(g.getAdj().get(i).getVal())){
                continue;
            }

            path[g.getAdj().get(i).getVal()] = g.getVal();
            bfsearch(visited, path,g.getAdj().get(i),end);
        }


    }

    private static void print(Integer[] path, Graph s, Integer e) {
        if (path[e] != -1 || s.getVal() != e) {
            print(path, s, path[e]);
        }

        System.out.print(" " + e);

    }

}
