package A_leetcode.Leetcode.msb算法.图;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class zj_Dijkstra {
    public static void main(String[] args) {

//        Shortest distance from Node A to Node 3: 1
//        Shortest distance from Node A to Node 0: 0
//        Shortest distance from Node A to Node 2: 5
//        Shortest distance from Node A to Node 1: 4
        // 创建节点
        Node nodeA = new Node(0);
        Node nodeB = new Node(1);
        Node nodeC = new Node(2);
        Node nodeD = new Node(3);

        // 创建边
        Edge edge1 = new Edge(4, nodeA, nodeB);
        Edge edge2 = new Edge(1, nodeA, nodeD);
        Edge edge3 = new Edge(5, nodeA, nodeC);
        Edge edge4 = new Edge(2, nodeB, nodeD);
        Edge edge5 = new Edge(3, nodeD, nodeB);
        Edge edge6 = new Edge(3, nodeC, nodeD);

        // 添加边到节点的边列表
        nodeA.edges.add(edge1);
        nodeA.edges.add(edge2);
        nodeA.edges.add(edge3);
        nodeB.edges.add(edge4);
        nodeD.edges.add(edge5);
        nodeC.edges.add(edge6);

        // 运行 Dijkstra 算法
        HashMap<Node, Integer> distanceMap = dijkstra1(nodeA);

        // 打印结果
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            System.out.println("Shortest distance from Node A to Node " + entry.getKey().value + ": " + entry.getValue());
        }

    }
    public static HashMap<Node, Integer> dijkstra1(Node from){
        HashMap<Node,Integer> distanceMap = new HashMap<>();
        distanceMap.put(from,0);
        HashSet<Node> touchNodes = new HashSet<>();
        Node minnode = getMinDistanceAndUnselectedNode(distanceMap,touchNodes);
        while (minnode!=null){
            for (Edge edge:minnode.edges) {
                if (!distanceMap.containsKey(edge.to)) {
                    distanceMap.put(edge.to, distanceMap.get(minnode) + edge.weight);
                } else if (distanceMap.get(minnode) + edge.weight < distanceMap.get(edge.to)) {
                    distanceMap.put(edge.to, distanceMap.get(minnode) + edge.weight);
                }

            }
            touchNodes.add(minnode);
            minnode=getMinDistanceAndUnselectedNode(distanceMap,touchNodes);
        }
        return distanceMap;
    }
    public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> touchedNodes){
        Node minnode = null;
        Integer distance = Integer.MAX_VALUE;
        for (Map.Entry<Node,Integer> entry: distanceMap.entrySet()){
            Node node = entry.getKey();
            Integer m = entry.getValue();
            if (distance > m&& !touchedNodes.contains(node)){
                distance = m;
                minnode = node;
            }
        }
        return minnode;
    }
}
