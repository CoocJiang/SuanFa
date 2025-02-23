package A_leetcode.面试150;

import java.util.HashMap;

public  class No146 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }

    static class LRUCache {


       static class node{
            Integer key;
            Integer val;
            node next;

            node pre;

            public node(Integer key,Integer val){
                this.key = key;
                this.val = val;
            }

        }
        node tail = new node(-1,-1);
        node head = new node(-1,-1);

        HashMap<Integer,node> map;

        int size;

        int capacity;

        public LRUCache(int capacity) {
           this.capacity = capacity;
           this.size=0;
           map = new HashMap<>();
        }

        public int get(int key) {
            if (map.containsKey(key)){
                node node= map.get(key);

                node.pre.next = node.next;
                node.next.pre = node.pre;

                head.next.pre = node;
                node.next = head.next;
                node.pre = head;
                head.next = node;

                return node.val;
            }else {
                return -1;
            }
        }
        public void put(int key, int value) {
            if (size==0){
                node node = new node(key,value);
                node.pre = head;
                node .next = tail;
                head.next = node;
                tail.pre = node;
                map.put(key,node);
                size++;
            }else {
                if (!map.containsKey(key)){
                    if (size<capacity){
                        size++;
                        node node = new node(key,value);
                        head.next.pre = node;
                        node.next  = head.next;
                        node.pre = head;
                        head.next = node;
                        map.put(key,node);
                    }else {
                        //先移除最不常用的节点
                        tail = tail.pre;
                        tail.next.pre = null;
                        tail.next = null;
                        map.remove(tail.key);

                        node node = new node(key,value);
                        head.next.pre = node;
                        node.next  = head.next;
                        node.pre = head;
                        head.next = node;
                        map.put(key,node);
                    }
                }else {
                    node node=map.get(key);
                    map.get(key).val = value;

                    node.pre.next = node.next;
                    node.next.pre = node.pre;

                    head.next.pre = node;
                    node.next = head.next;
                    node.pre = head;
                    head.next = node;
                }
            }
        }
    }
}
