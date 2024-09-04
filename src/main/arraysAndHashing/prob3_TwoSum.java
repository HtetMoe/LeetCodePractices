package main.arraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;

public class prob3_TwoSum {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6};
        int target = 10;
        System.out.println(STR."result => \{Arrays.toString(twoSum(nums, target))}");
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // value, index
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i]; // value
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[0]; // empty result list
    }
}
