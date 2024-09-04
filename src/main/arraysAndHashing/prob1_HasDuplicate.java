package main.arraysAndHashing;

import java.util.HashSet;

public class prob1_HasDuplicate {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(STR."result => \{hasDuplicate(array)}");
    }

    public static boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(Integer element : nums) {
            if(set.contains(element)) {
                return true;
            }
            set.add(element);
        }
        return false;
    }
}
