package a04Graph;

import java.util.*;

public class sort {
    // 拓扑排序
    public static List<Node> sortedTopology(Graph graph){
        // 表示结点入度的map
        HashMap<Node, Integer> inMap = new HashMap<>();
        // 入度为0的队列
        Queue<Node> zero = new LinkedList<>();
        // 遍历将图中所有结点入度信息存至map，并将初始入度为0的结点加入队列中
        for (Node node : graph.nodes.values()){
            inMap.put(node, node.in);
            if (node.in == 0){
                zero.add(node);
            }
        }
        // 将队列中的结点加入result的List中，队列中每弹出一个结点，该结点后继结点入度-1
        List<Node> result = new ArrayList<>();
        while (!zero.isEmpty()){
            Node cur = zero.poll();
            result.add(cur);
            for (Node next : cur.nexts){
                inMap.put(next, inMap.get(next) - 1);
                if(inMap.get(next) == 0){
                    zero.add(next);
                }
            }
        }
        return result;
    }

}
