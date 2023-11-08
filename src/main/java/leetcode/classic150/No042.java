package leetcode.classic150;

import java.util.*;

/**
 * @author hwang
 * @data 2023/11/8
 * @description
 */
public class No042 {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 你可以按任意顺序返回答案。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[2];

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                res[0] = map.get(nums[left]).pop();
                res[1] = map.get(nums[right]).pop();
                return res;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return res;
    }
}
