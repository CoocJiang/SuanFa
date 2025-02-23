package b_a_class16图;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Code03_zj_OrderDFS {
    public static class DirectedGraphNode {
        public int label;
        public ArrayList<DirectedGraphNode> neighbors;

        public DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }
    public static class Record {
        public DirectedGraphNode node;
        public long nodes;

        public Record(DirectedGraphNode n, long o) {
            node = n;
            nodes = o;
        }
    }
    public static class compare implements Comparator<Record>{

        @Override
        public int compare(Record o1, Record o2) {
            return (int) (o2.nodes-o1.nodes);
        }
    }
    public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        HashMap<DirectedGraphNode,Record> map = new HashMap<>();
        for (DirectedGraphNode cur:graph){
            f(cur,map);
        }
        List<Record> recordList= new ArrayList<>();
        for (Record r: map.values()){
            recordList.add(r);
        }
        recordList.sort(new compare());
        ArrayList<DirectedGraphNode> directedGraphNodeArrayList = new ArrayList<>();
        for (Record d:recordList){
            directedGraphNodeArrayList.add(d.node);
        }
        return directedGraphNodeArrayList ;
    }
    public static Record f(DirectedGraphNode cur,HashMap<DirectedGraphNode,Record> map){
       if (map.containsKey(cur)){
           return map.get(cur);
       }
       long ans = 0;
       for (DirectedGraphNode nodes:cur.neighbors){
           ans = ans+f(nodes,map).nodes;
       }
       Record record = new Record(cur,ans+1);
       map.put(cur,record);
       return record;
    }
}
