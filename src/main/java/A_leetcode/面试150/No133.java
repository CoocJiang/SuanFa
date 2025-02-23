package A_leetcode.面试150;

import sun.java2d.pipe.AAShapePipe;

import java.util.*;


public class No133 {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private static HashMap <Node, Node> visited = new HashMap <> ();
    public static Node cloneGraph(Node node) {
        return process(node);
    }
    //深度优先遍历DFS
    public static Node process(Node node){
        if (node==null){
            return null;
        }
        if (visited.containsKey(node)){
            return visited.get(node);
        }
        Node root = new Node(node.val,new ArrayList<>());
        visited.put(node,root);
        for (int i=0;i<node.neighbors.size();i++){
            //加入每一个node节点的邻居到当前root
            root.neighbors.add(process(node.neighbors.get(i)));
        }
        return root;
    }

    //广度优先遍历BFS
    public static Node process1(Node node){
        if (node==null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        visited.put(node,new Node(node.val,new ArrayList<>()));

        while (!queue.isEmpty()){

            Node cur = queue.remove();

            for (Node neighbor: cur.neighbors){
                if (!visited.containsKey(neighbor)){
                    visited.put(neighbor,new Node(neighbor.val,new ArrayList<>()));
                    queue.add(neighbor);
                }
                visited.get(cur).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }

}
