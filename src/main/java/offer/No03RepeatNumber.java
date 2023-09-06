package offer;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hwang
 * @data 2023/8/31
 * @description
 */
public class No03RepeatNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber2(nums));
    }

    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
     * 请找出数组中任意一个重复的数字。
     *
     * @param nums 数组
     * @return 重复数字
     */
    public static int findRepeatNumber(int[] nums) {

        Set<Integer> tmpSet = new HashSet<>();
        for (int n : nums) {
            if (tmpSet.contains(n)) {
                return n;
            } else {
                tmpSet.add(n);
            }
        }

        return -1;
    }

    /**
     * 原地交换法
     *
     * @param nums 数组
     * @return 重复数字
     */
    public static int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
            } else if (nums[i] == nums[nums[i]]) {
                return nums[i];
            } else {
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }

        return -1;
    }
}
