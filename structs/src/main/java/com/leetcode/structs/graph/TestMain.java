package com.leetcode.structs.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: liuhaoeric
 * Create time: 2019/07/08
 * Description:
 */
public class TestMain {
    private static List<Graph> list=new ArrayList<>();

    public static void main(String[] args) {
        Graph graph0=new Graph(0);
        Graph graph1=new Graph(1);
        Graph graph2=new Graph(2);
        Graph graph3=new Graph(3);
        Graph graph4=new Graph(4);
        Graph graph5=new Graph(5);
        Graph graph6=new Graph(6);
        Graph graph7=new Graph(7);

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

        Graph.bfs(list,graph6);

        System.out.println();
        System.out.println("========sfs");
        Graph.sfs(list,graph6);

    }
}
