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
            for (Vertex adjV : v.getAdj()) {
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

    /**
     * 搜索n度还有
     *
     * @param list
     * @param degree
     * @return
     */
    public List<Vertex> searchByDegree(List<Vertex> list, int degree) {
        LinkedList<DegreeVertex> queue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();

        int i = 0;
        queue.add(new DegreeVertex(i, list.get(0)));
        visited.add(list.get(0));


        List<Vertex> ret = new ArrayList<>();
        while (queue.size() > 0) {
            DegreeVertex degreeVertex = queue.poll();
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
