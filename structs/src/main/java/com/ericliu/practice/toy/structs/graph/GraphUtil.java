package com.ericliu.practice.toy.structs.graph;

import java.util.Map;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/7/8
 */
public class GraphUtil {

    public static void printPath(Map<Integer, Integer> path, Vertex start, Integer end) {
        if (path.containsKey(end) && path.get(end) != -1 && start.getVal() != end) {
            printPath(path, start, path.get(end));
        }

        System.out.print("--" + end);
    }
}
