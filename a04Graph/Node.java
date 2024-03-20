package a04Graph;

import java.util.ArrayList;

public class Node {
    public int value; // 结点值
    public int in; // 入度
    public int out; // 出度
    public ArrayList<Node> nexts; // 结点出去指向的点
    public ArrayList<Edge> edges; // 结点出去的边

    public Node(int value){
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
