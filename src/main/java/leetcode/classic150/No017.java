package leetcode.classic150;

import java.util.Arrays;

/**
 * @author hwang
 * @data 2023/10/18
 * @description
 */
public class No017 {

    public static void main(String[] args) {
        No017 no017 = new No017();

        System.out.println(no017.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * <p>
     * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
     * 如果不存在符合条件的子数组，返回 0 。
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int low = 0;
        int high = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        while (high < nums.length) {
            sum += nums[high];
            while (sum >= target) {
                res = Math.min(res, high - low + 1);
                sum -= nums[low];
                low++;
            }
            high++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
