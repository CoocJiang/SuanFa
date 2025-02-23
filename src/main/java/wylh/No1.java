package wylh;

import java.util.*;

public class No1 {



    public ArrayList<ArrayList<Long>> diff (ArrayList<Long> leftIds, ArrayList<String> leftValues,
                                            ArrayList<Long> rightIds, ArrayList<String> rightValues) {
        // write code here
        ArrayList<Long> deletes = new ArrayList<>();
        ArrayList<Long> updates = new ArrayList<>();
        ArrayList<Long> adds = new ArrayList<>();

        HashMap<Long,String> mapleft = new HashMap<>();
        HashMap<Long,String> mapright = new HashMap<>();
        int l = leftIds.size();
        int r = rightIds.size();
        int num = 0;
        if (l<r){
            num = l;
        }else {
            num = r;
        }
        for (int i = 0;i<num;i++){
            mapleft.put(leftIds.get(i),leftValues.get(i));
            mapright.put(rightIds.get(i),rightValues.get(i));
        }
        if (num==r){
            for (int i = r;i<l;i++){
                mapleft.put(leftIds.get(i),leftValues.get(i));
            }
        }else {
            for (int i = l;i<r;i++){
                mapright.put(rightIds.get(i),rightValues.get(i));
            }
        }
        long key;
        String value;
        for (Map.Entry<Long,String> entry:mapleft.entrySet()){
            key = entry.getKey();
            value = entry.getValue();
            if (mapright.containsKey(key)){
                if (!mapright.get(key).equals(value)){
                    updates.add(key);
                }
            }else {
                deletes.add(key);
            }
        }
        for (Map.Entry<Long,String> entry:mapright.entrySet()){
            key = entry.getKey();
            if (!mapleft.containsKey(key)){
               adds.add(key);
            }
        }
        Collections.sort(adds);
        Collections.sort(deletes);
        Collections.sort(updates);
        ArrayList<ArrayList<Long>> ans  = new ArrayList<>();
        ans.add(adds);
        ans.add(updates);
        ans.add(deletes);
        return  ans;
    }
}
