package b_a_class16图;

import java.util.*;

public class Code03_zj_Topology {
    public static void main(String[] args) {
        Graph graph = new Graph();

// 创建节点
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

// 创建边
        Edge edge1 = new Edge(0, node1, node2);
        Edge edge2 = new Edge(0, node1, node3);
        Edge edge3 = new Edge(0, node2, node4);
        Edge edge4 = new Edge(0, node3, node4);
        Edge edge5 = new Edge(0, node4, node5);

// 添加节点和边到图中
        graph.nodes.put(node1.value, node1);
        graph.nodes.put(node2.value, node2);
        graph.nodes.put(node3.value, node3);
        graph.nodes.put(node4.value, node4);
        graph.nodes.put(node5.value, node5);

        graph.edges.add(edge1);
        graph.edges.add(edge2);
        graph.edges.add(edge3);
        graph.edges.add(edge4);
        graph.edges.add(edge5);

// 调用拓扑排序算法
        List<Node> sortedNodes = sort(graph);

// 输出排序结果
        System.out.print("拓扑排序的结果为: ");
        for (Node node : sortedNodes) {
            System.out.print(node.value + " ");
        }
    }


    public static List<Node>sort (Graph graph){
        HashMap<Node,Integer> inmap=new HashMap<>();
        Queue<Node> zero = new LinkedList<>();
        List<Node> result = new ArrayList<>();
        for (Node nodes : graph.nodes.values()){
            if (nodes.in==0){
                zero.add(nodes);
            }
            inmap.put(nodes, nodes.in);
        }
        while (!zero.isEmpty()){
            Node cur  = zero.poll();
            result.add(cur);
            for (Node edgenode :cur.nexts){
                inmap.put(edgenode,inmap.get(edgenode)-1);
                if (inmap.get(edgenode)==0){
                    zero.add(edgenode);
                }
            }
        }
    return result;
    }
}
