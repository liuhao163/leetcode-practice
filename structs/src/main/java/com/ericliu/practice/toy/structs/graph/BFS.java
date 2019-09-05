package com.ericliu.practice.toy.structs.graph;

import java.util.*;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/7/8
 */
public class BFS {

    private List<Vertex> list = new ArrayList<>();


    public BFS(List<Vertex> list) {
        this.list = list;
    }

    public void search(Vertex end) {
        //借用队列，将下一个要查找的点入队列
        LinkedList<Vertex> queue = new LinkedList<>();
        //记录搜索过的点，找到值后跳过
        Set<Vertex> visited = new HashSet<>();
        //记录路径key是当前的点的下标，value是来源，打印时候通过递归层层找到最开始的起点
        Map<Integer, Integer> path = new HashMap<>();

        //添加起点坐标
        queue.add(list.get(0));
        visited.add(list.get(0));
        //初始化路径
        list.forEach(v -> {
            path.put(v.getVal(), -1);
        });

        //第一层结束后才开始第二层
        while (queue.size() > 0) {
            //队列出列
            Vertex v = queue.poll();
            for (Vertex adjV : v.getAdj()) {
                if (visited.contains(adjV)) {
                    continue;
                }

                //修改path和visited
                visited.add(adjV);
                path.put(adjV.getVal(), v.getVal());
                if (adjV.equals(end)) {
                    //找到终点打印
                    GraphUtil.printPath(path, list.get(0), end.getVal());
                    return;
                }
                queue.add(adjV);
            }
        }
    }

    /**
     * 搜索n度还有
     *
     * @param list
     * @param degree
     * @return
     */
    public List<Vertex> searchByDegree(List<Vertex> list, int degree) {
        //记录当前是第几度关系的容器
        LinkedList<DegreeVertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();

        int i = 0;
        queue.add(new DegreeVertex(i, list.get(0)));
        visited.add(list.get(0));

        List<Vertex> ret = new ArrayList<>();
        while (queue.size() > 0) {
            DegreeVertex degreeVertex = queue.poll();
            //超过度直接返回
            if (degreeVertex.getDegree() > degree) {
                break;
            }

            i = degreeVertex.getDegree() + 1;
            for (Vertex adjV : degreeVertex.vertex.getAdj()) {
                if (visited.contains(adjV)) {
                    continue;
                }

                visited.add(adjV);
                if (i == degree) {
                    ret.add(adjV);
                }
                queue.add(new DegreeVertex(i, adjV));
            }
        }

        return ret;
    }

    class DegreeVertex {
        private int degree;
        private Vertex vertex;

        public DegreeVertex(int degree, Vertex g) {
            this.degree = degree;
            this.vertex = g;
        }

        public int getDegree() {
            return degree;
        }

        public Vertex getG() {
            return vertex;
        }
    }
}
