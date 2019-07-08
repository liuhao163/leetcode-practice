package com.leetcode.structs.graph;

import java.util.LinkedList;

/**
 * @Author: liuhaoeric
 * Create time: 2019/07/08
 * Description:
 */
public class Graph {
    private int v;
    //邻接表
    private LinkedList<Graph> adj = new LinkedList<>();

    public Graph(int v) {
        this.v = v;
    }

    public void addAdj(Graph g) {
        adj.add(g);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "v=" + v +
                '}';
    }
}
