package a04Graph;

public class Edge {
    public int weight; // 边的权值
    public Node from; // 来自的结点
    public Node to; // 指向的结点

    public Edge(int weight, Node from, Node to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
