package A_leetcode.面试150;

import java.util.*;

//380题
//变长数组可以在 O(1)O(1)O(1) 的时间内完成获取随机元素操作，但是由于无法在 O(1)O(1)O(1) 的时间内判断元素是否存在，
// 因此不能在 O(1)O(1)O(1) 的时间内完成插入和删除操作。哈希表可以在 O(1)O(1)O(1) 的时间内完成插入和删除操作，
// 但是由于无法根据下标定位到特定元素，因此不能在 O(1)O(1)O(1) 的时间内完成获取随机元素操作。
// 为了满足插入、删除和获取随机元素操作的时间复杂度都是 O(1)O(1)O(1)，需要将变长数组和哈希表结合，
class RandomizedSet {
    List<Integer> nums;
    HashMap<Integer,Integer> map;
    Random random;
    public RandomizedSet() {
        random = new Random();
        map = new HashMap<>();
        nums = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (nums.contains(val)){
            return false;
        }else {
            nums.add(val);
            map.put(val,nums.size()-1);
            return true;
        }
    }

    public boolean remove(int val) {
        if (nums.contains(val)){
            int index = map.get(val);
            nums.set(index,nums.get(nums.size()-1));
            map.put(nums.get(nums.size()-1),index);
            nums.remove(nums.size()-1);
            return true;
        }else {
            return false;
        }
    }

    public int getRandom() {
        int randomNumber = random.nextInt(nums.size() + 1);
        return nums.get(randomNumber);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
