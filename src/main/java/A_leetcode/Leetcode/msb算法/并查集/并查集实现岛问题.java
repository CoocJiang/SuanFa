package A_leetcode.Leetcode.msb算法.并查集;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class 并查集实现岛问题 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 1, 0, 0},
                {1, 1, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 1, 1},
                {0, 0, 1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1, 0}
        };
    }

    public static class dot {

    }

    public static class Node<V> {
        V value;

        public Node(V v) {
            value = v;
        }
    }

//    public int Island(int[][] board) {
//        int row = board.length;
//        int cul = board[0].length;
//        dot[][] dots = new dot[row][cul];
//        List<dot> dotList = new ArrayList<>();
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < cul; j++) {
//                if (board[i][j] == 1) {
//                    dots[i][j] = new dot();
//                    dotList.add(dots[i][j]);
//                }
//            }
//        }
//        Unionset<dot> uf = new Unionset<>(dotList);
//        for (int j = 0; j < cul; j++) {
//            if (board[0][j] == board[0][j + 1] && board[0][j] == 1) {
//                uf.union(dots[0][j],dots[0][j+1]);
//            }
//        }
//    }


    public class Unionset<V> {
        HashMap<V, 并查集实现岛问题.Node<V>> nodes;
        HashMap<并查集实现岛问题.Node<V>, 并查集实现岛问题.Node<V>> parents;

        HashMap<并查集实现岛问题.Node<V>, Integer> sizeMap;

        public Unionset(List<V> values) {
            parents = new HashMap<>();
            nodes = new HashMap<>();
            sizeMap = new HashMap<>();

            for (V v : values) {
                并查集实现岛问题.Node<V> node = new 并查集实现岛问题.Node(v);
                nodes.put(v, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public void union(Node<V> node,Node<V> node2) {
            并查集实现岛问题.Node<V> head1 = find(node);
            并查集实现岛问题.Node<V> head2 = find(node2);
            if (head1 == head2) {
                return;
            } else if (sizeMap.get(head1) > sizeMap.get(head2)) {
                parents.put(head2, head1);
                sizeMap.put(head1, sizeMap.get(head2) + sizeMap.get(head1));
            } else {
                parents.put(head1, head2);
                sizeMap.put(head2, sizeMap.get(head2) + sizeMap.get(head1));
            }
        }

        public 并查集实现岛问题.Node<V> find(并查集实现岛问题.Node<V> node) {
            Stack<并查集实现岛问题.Node<V>> path = new Stack<>();
            while (node != parents.get(node)) {
                path.push(node);
                node = parents.get(node);
            }
            while (path != null) {
                parents.put(path.pop(), node);
            }
            return node;
        }
    }
}
