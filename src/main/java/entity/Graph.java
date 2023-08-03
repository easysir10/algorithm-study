package entity;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author hwang
 * @data 2023/7/21
 * @description
 */
public class Graph {

    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;

    public Graph(HashMap<Integer, Node> nodes, HashSet<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }
}
