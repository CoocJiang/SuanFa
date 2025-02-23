package A_leetcode.leetcodeall;

import java.util.HashMap;

public class No146 {

    static class LRUCache {
        static class Node{
            int id;
            int value;

            Node pre;
            Node next;

            public Node(int id, int value, Node pre, Node next) {
                this.id = id;
                this.value = value;
                this.pre = pre;
                this.next = next;
            }
            public Node(int id, int value) {
                this.id = id;
                this.value = value;
            }
        }

        HashMap<Integer,Node> map = new HashMap<>();
        int size = 0;

        Node head ;
        Node tail ;

        int capacity;


        public LRUCache(int capacity) {
             this.capacity = capacity;
             head = new Node(-1,-1);
             tail = new Node(-1,-1);
        }

        public int get(int key) {
            if(map.containsKey(key)){
                //更新双端链表结构
                return map.get(key).value;
            }else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (size<capacity){
                //直接在头节点插入即可
            }else {
                if (map.containsKey(key)){
                    //如果有直接 更新位置到第一
                }else {
                    // 移除最后一个，插入到head之后
                }

            }
        }
    }
}
