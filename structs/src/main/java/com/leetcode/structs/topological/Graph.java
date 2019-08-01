package com.leetcode.structs.topological;

import java.util.*;

import static com.sun.tools.javac.jvm.ByteCodes.ret;

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
        //统计入度
        int[] indegree = new int[v];
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
//              i先执行于j,j依赖i，统计j的入度w，等于统计j有多少前置依赖
                int w = adj[i].get(j);
                indegree[w]++;
            }
        }

        //队列，先执行的先放入队列中
        Map<Integer, LinkedList<Integer>> queueMap = new HashMap<>();

        //执行结果序列
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queueMap.put(i, new LinkedList<>());
                queueMap.get(i).add(i);
                result.put(i, new ArrayList<>());
            }
        }

        //遍历队列
        for (Map.Entry<Integer, LinkedList<Integer>> queue : queueMap.entrySet()) {
            //循环放入执行队列
            while (!queue.getValue().isEmpty()) {
                //入度为0的顶点出队，放入到结果执行序列中
                int v = queue.getValue().remove();
                result.get(queue.getKey()).add(v);
                for (int j = 0; j < adj[v].size(); j++) {
                    //将当前顶点到达的顶点入度--,等价于删除顶点。
                    int k = adj[v].get(j);
                    indegree[k]--;
                    //如果这个顶点的入度为0将其放到到执行序列中重复知道队列为空
                    if (indegree[k] == 0) {
                        queue.getValue().add(k);
                    }
                }
            }
        }

        //打印
        for (List<Integer> ret : result.values()) {
            System.out.print(ret);
            System.out.println();
        }
    }


    //深度优先遍历
    public void topoSortByDFS() {
        LinkedList<Integer>[] inverseAdj = new LinkedList[adj.length];
        for (int i = 0; i < adj.length; i++) {
            inverseAdj[i] = new LinkedList<>();
        }

        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);
                inverseAdj[w].add(i);
            }
        }

//        Map<Integer, LinkedList<Integer>> result = new HashMap<>();
        Map<Integer, Boolean> visted = new HashMap<>();
        for (int i = 0; i < adj.length; i++) {
            if (visted.get(i) == null || !visted.get(i)) {
                visted.put(i, true);
                dfs(i, inverseAdj, visted);
            }
        }

        //打印
//        for (List<Integer> ret : result.values()) {
//            System.out.print(ret);
//            System.out.println();
//        }
    }

    public void dfs(int v, LinkedList<Integer>[] inverseAdj, Map<Integer, Boolean> visted) {

        for (int j = 0; j < inverseAdj[v].size(); j++) {
            int w = inverseAdj[v].get(j);
            if (visted.get(w) != null && visted.get(w)) {
                continue;
            }
            visted.put(w, true);
//            result.addLast(w);
            dfs(w, inverseAdj, visted);
        }
//        result.addLast(v);
        System.out.print("->" + v);
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
    }

    public static void main(String[] args) {

        Graph g = new Graph(10);

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
