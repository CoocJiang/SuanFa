package A_leetcode.leetcodeall;

import java.util.*;

public class No690 {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, 5, Arrays.asList(2, 3));
        Employee emp2 = new Employee(2, 3, Collections.emptyList());
        Employee emp3 = new Employee(3, 3, Collections.emptyList());

        // Add employees to a list
        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        System.out.println(getImportance(employees, 1));
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    };
    public static int getImportance(List<Employee> employees, int id) {
        List<Integer> listid1 = new ArrayList<>();
        List<Integer> listid2 = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = employees.size();
        int sum = 0;
        Employee cur;
        for (int i = 0;i<n;i++){
            cur = employees.get(i);
            if (cur.id==id){
                sum+=cur.importance;
                for (int j:cur.subordinates){
                    listid1.add(j);
                }
            }else {
                map.put(employees.get(i).id,i);
            }
        }
        while (listid1.size()!=0||listid2.size()!=0){
            if (listid1.isEmpty()){
                for (int i:listid2){
                    cur = employees.get(map.get(i));
                    sum+=cur.importance;
                    for (Integer subordinate : cur.subordinates) {
                        listid1.add(subordinate);
                    }
                }
                listid2.clear();
            }else {
                for (int i:listid1){
                    cur = employees.get(map.get(i));
                    sum+=cur.importance;
                    for (Integer subordinate : cur.subordinates) {
                        listid2.add(subordinate);
                    }
                }
                listid1.clear();
            }
        }
        return sum;
    }
}
