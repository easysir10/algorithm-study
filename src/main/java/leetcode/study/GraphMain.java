package leetcode.study;

import entity.Edge;
import entity.Graph;
import entity.Node;

import java.math.BigInteger;
import java.util.*;

/**
 * @author hwang
 * @data 2023/7/21
 * @description
 */
public class GraphMain {

    /**
     * 图的广度优先遍历（宽度优先）
     *
     * @param node
     */
    public static void bfs(Node node) {
        if (null == node) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }

    /**
     * 图的深度优先遍历（宽度优先）
     *
     * @param node
     */
    public static void dfs(Node node) {
        if (null == node) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.add(cur);
                    stack.add(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

    /**
     * 拓扑排序算法
     *
     * @param graph
     */
    public static List<Node> sortedTopology(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();

        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (0 == node.in) {
                zeroInQueue.add(node);
            }
        }

        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node node : cur.nexts) {
                inMap.put(node, inMap.get(node) - 1);
                if (0 == inMap.get(node)) {
                    zeroInQueue.add(node);
                }
            }
        }

        return result;
    }

    /**
     * prim最小生成树算法
     *
     * @param graph
     * @return
     */
    public static Set<Edge> primMST(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        HashSet<Node> set = new HashSet<>();
        HashSet<Edge> result = new HashSet<>();

        for (Node node : graph.nodes.values()) {
            if (!set.contains(node)) {
                set.add(node);
                priorityQueue.addAll(node.edges);
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if (!set.contains(toNode)) {
                        set.add(toNode);
                        result.add(edge);
                        priorityQueue.addAll(toNode.edges);
                    }
                }
            }
        }
        return result;
    }

    /**
     * dijkstra算法
     *
     * @param head
     * @return
     */
    public static HashMap<Node, Integer> dijkstra(Node head) {
        HashMap<Node, Integer> map = new HashMap<>();
        map.put(head, 0);
        HashSet<Node> set = new HashSet<>();
        Node minNode = getMinDistanceAndUnselectedNode(map, set);

        while (null != minNode) {
            int distance = map.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!map.containsKey(toNode)) {
                    map.put(toNode, distance + edge.weight);
                }
                map.put(edge.to, Math.min(map.get(toNode), distance + edge.weight));
            }
            set.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(map, set);
        }
        return map;
    }

    public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> map, HashSet<Node> set) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : map.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!set.contains(node) && distance < minDistance) {
                minDistance = distance;
                minNode = node;
            }
        }
        return minNode;
    }
}
