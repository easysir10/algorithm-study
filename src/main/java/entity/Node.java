package entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author hwang
 * @data 2023/7/21
 * @description
 */
public class Node implements Serializable {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
