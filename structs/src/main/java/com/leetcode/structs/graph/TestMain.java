package com.leetcode.structs.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuhaoeric
 * Create time: 2019/07/08
 * Description:
 */
public class TestMain {
    private static List<Vertex> list=new ArrayList<>();

    public static void main(String[] args) {
        Vertex graph0=new Vertex(0);
        Vertex graph1=new Vertex(1);
        Vertex graph2=new Vertex(2);
        Vertex graph3=new Vertex(3);
        Vertex graph4=new Vertex(4);
        Vertex graph5=new Vertex(5);
        Vertex graph6=new Vertex(6);
        Vertex graph7=new Vertex(7);

        graph0.addAdj(graph1);
        graph1.addAdj(graph0);

        graph0.addAdj(graph3);
        graph3.addAdj(graph0);

        graph1.addAdj(graph2);
        graph2.addAdj(graph1);

        graph1.addAdj(graph4);
        graph4.addAdj(graph1);

        graph2.addAdj(graph5);
        graph5.addAdj(graph2);

        graph3.addAdj(graph4);
        graph4.addAdj(graph3);

        graph4.addAdj(graph5);
        graph5.addAdj(graph4);

        graph4.addAdj(graph6);
        graph6.addAdj(graph4);

        graph5.addAdj(graph7);
        graph7.addAdj(graph5);

        graph6.addAdj(graph7);
        graph7.addAdj(graph6);

        list.add(graph0);
        list.add(graph1);
        list.add(graph2);
        list.add(graph3);
        list.add(graph4);
        list.add(graph5);
        list.add(graph6);
        list.add(graph7);

        BFS bfs=new BFS(list);
        bfs.search(list.get(6));
        System.out.println("\n========dfs");
        DFS dfs=new DFS(list);
        dfs.search(list.get(6));
        System.out.println("\n");
//        Vertex.sfs(list,graph6);

    }
}
